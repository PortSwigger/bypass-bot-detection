package net.portswigger.burp.extensions.beens;

import com.google.gson.annotations.Expose;

public class SSL {
    private @Expose Negotiation negotiation;

    public SSL(Negotiation negotiation) {
        this.negotiation = negotiation;
    }

    public Negotiation getNegotiation() {
        return negotiation;
    }

    public void setNegotiation(Negotiation negotiation) {
        this.negotiation = negotiation;
    }
}
