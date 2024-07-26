package net.portswigger.burp.extensions;

import burp.api.montoya.core.Annotations;
import burp.api.montoya.http.message.HttpRequestResponse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ThreadPoolExecutor;

public class TriggerCipherGuesser implements ActionListener, Runnable {
    private ThreadPoolExecutor taskEngine;
    private final List<HttpRequestResponse> requestResponses;

    public TriggerCipherGuesser(ThreadPoolExecutor taskEngine, List<HttpRequestResponse> requestResponses) {
        this.taskEngine = taskEngine;
        this.requestResponses = requestResponses;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(requestResponses.isEmpty()) return;
        (new Thread(this)).start();
    }


    @Override
    public void run() {
            taskEngine.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Utilities.log(String.format("|*| Starting attack on %s targets", requestResponses.size()));
                        ListIterator<HttpRequestResponse> it = requestResponses.listIterator();
                        for(String[] protocol : Constants.BRUTEFORCE_CIPHERS.keySet()) {
                            if(!it.hasNext()) {
                                Utilities.log("|*| Nothing to do!");
                                break;
                            }
                            String[] ciphers = Constants.BRUTEFORCE_CIPHERS.get(protocol);
                            Utilities.updateTLSSettings(protocol, ciphers);
                            Utilities.log(String.format("|*| Probing protocols: %s", Utilities.stringify(protocol)));
                            while (it.hasNext()) {
                                HttpRequestResponse requestResponse = it.next();
                                String negotiation = Utilities.negotiation(protocol,ciphers);
                                HttpRequestResponse prob = Utilities.attemptRequest(requestResponse, negotiation);
                                if ( prob != null && Utilities.compareResponses(requestResponse, prob)) {
                                    String comment = String.format(
                                            "|*| URL %s response was changed. Status code %s. TLS settings: %s",
                                            requestResponse.request().url(),
                                            prob.response().statusCode(),
                                            negotiation );
                                    Utilities.log(comment);
                                    Utilities.addComment(requestResponse,negotiation);
                                    it.remove();
                                }
                            }
                            while (it.hasPrevious()) {
                                it.previous();
                            }
                            Thread.sleep(100);
                        }
                        Utilities.log("|*| Finished!");
                    }catch (Exception e) {
                        Utilities.log(e.getMessage());
                    }
                    finally {
                        Utilities.loadTLSSettings();
                    }
                }
            });
        }

}
