package net.portswigger.burp.extensions.beens;

import com.google.gson.annotations.Expose;

public class ProxySettings {
    private final @Expose Proxy proxy;

    public ProxySettings(Proxy proxy) {
        this.proxy = proxy;
    }
    public ProxySettings toggleMatchAndReplace(MatchAndReplace rule) {
        Proxy existing = this.proxy;
        existing.toggleMatchAndReplace(rule);
        return new ProxySettings(existing);
    }
}
