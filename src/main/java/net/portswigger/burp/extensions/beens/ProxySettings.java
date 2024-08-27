package net.portswigger.burp.extensions.beens;

import com.google.gson.annotations.Expose;

import java.util.List;

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
    public ProxySettings toggleHTTPDowngradeMatchAndReplace(List<MatchAndReplace> rules) {
        Proxy existing = this.proxy;
        existing.toggleHTTPDowngradeMatchAndReplace(rules);
        return new ProxySettings(existing);
    }
}
