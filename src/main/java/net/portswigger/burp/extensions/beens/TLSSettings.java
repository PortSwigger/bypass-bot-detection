package net.portswigger.burp.extensions.beens;

import com.google.gson.annotations.Expose;
import net.portswigger.burp.extensions.Constants;

public class TLSSettings {
    private @Expose ProjectOptions project_options;

    public TLSSettings(ProjectOptions project_options) {
        this.project_options = project_options;
    }

    public void addProtocols(String[] protocols) {
        SSL ssl = this.project_options.getSsl();
        Negotiation negotiation = ssl.getNegotiation();
        negotiation.setEnabledProtocols(protocols);
        negotiation.setTlsNegotiationBehavior(Constants.BURP_TLS_NEGOTIATION);
        ssl.setNegotiation(negotiation);
        this.project_options.setSsl(ssl);
    }

    public void addCiphers(String[] ciphers) {
        SSL ssl = this.project_options.getSsl();
        Negotiation negotiation = ssl.getNegotiation();
        negotiation.setEnabledCiphers(ciphers);
        negotiation.setTlsNegotiationBehavior(Constants.BURP_TLS_NEGOTIATION);
        ssl.setNegotiation(negotiation);
        this.project_options.setSsl(ssl);
    }

    public void toggleHTTPSettings() {
        HTTP http = this.project_options.getHTTP();
        boolean enabled = http.getHttp2().getEnableHTTP2();
        http.setHttp2(new HTTP2(!enabled));
        this.project_options.setHTTP(http);
    }

    public boolean enabledHTTPDowngrade() {
        return this.project_options.getHTTP().getHttp2().getEnableHTTP2();
    }
}
