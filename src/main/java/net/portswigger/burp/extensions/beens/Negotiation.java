package net.portswigger.burp.extensions.beens;

import com.google.gson.annotations.Expose;

public class Negotiation {
    private @Expose String[] enabled_ciphers;
    private @Expose String[] enabled_protocols;
    private @Expose String tls_negotiation_behavior;
    private @Expose boolean disable_ssl_session_resume;
    private @Expose boolean allow_unsafe_renegotiation;
    private @Expose boolean enforce_upstream_trust;

    public Negotiation(String[] enabled_ciphers, String[] enabled_protocols, boolean disable_ssl_session_resume) {
        this.enabled_ciphers = enabled_ciphers;
        this.enabled_protocols = enabled_protocols;
        this.tls_negotiation_behavior = "use_custom";
        this.disable_ssl_session_resume = disable_ssl_session_resume;
    }

    public void setEnabledProtocols(String[] enabled_protocols) {
        this.enabled_protocols = enabled_protocols;
    }

    public void setEnabledCiphers(String[] enabled_ciphers) {
        this.enabled_ciphers = enabled_ciphers;
    }

    public void setDisableSslSessionResume(boolean disable_ssl_session_resume) {
        this.disable_ssl_session_resume = disable_ssl_session_resume;
    }

    public void setTlsNegotiationBehavior(String tls_negotiation_behavior) {
        this.tls_negotiation_behavior = tls_negotiation_behavior;
    }
}
