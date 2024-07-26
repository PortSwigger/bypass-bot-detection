package net.portswigger.burp.extensions;

import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;
import net.portswigger.burp.extensions.beens.Browsers;
import net.portswigger.burp.extensions.beens.MatchAndReplace;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BypassBotDetection implements BurpExtension {
    @Override
    public void initialize(MontoyaApi montoyaApi) {
        montoyaApi.extension().setName(Utilities.getResourceString("tool_name"));
        try {
            new Utilities(montoyaApi);
            BlockingQueue<Runnable> tasks = new LinkedBlockingQueue<>();
            ThreadPoolExecutor taskEngine = new ThreadPoolExecutor(1, 1, 1, TimeUnit.MINUTES, tasks);
            Utilities.saveTLSSettings();
            montoyaApi.userInterface().registerContextMenuItemsProvider(new TLSContextMenuItemsProvider(taskEngine));
            montoyaApi.logging().logToOutput(Utilities.getResourceString("greetings"));
            montoyaApi.extension().registerUnloadingHandler(()-> {
                Utilities.unloaded.set(true);
                try {
                    taskEngine.getQueue().clear();
                    taskEngine.shutdown();
                }finally {
                    Utilities.loadTLSSettings();
                    Utilities.log("Extension unloaded.");
                }
            });
            // warming up
            Utilities.log(Utilities.getResourceString("loading"));
            Utilities.updateTLSSettings(Constants.BROWSERS_PROTOCOLS.get(Browsers.FIREFOX.name), Constants.BROWSERS_CIPHERS.get(Browsers.FIREFOX.name));
            Utilities.updateProxySettings(MatchAndReplace.create(Browsers.FIREFOX));


        } catch (Exception e) {
            montoyaApi.logging().logToError(Utilities.getResourceString("error"));
            montoyaApi.logging().logToError(e.getMessage());
        }
    }
}
