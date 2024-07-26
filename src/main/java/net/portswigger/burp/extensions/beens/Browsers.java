package net.portswigger.burp.extensions.beens;

public enum Browsers {
    FIREFOX("Firefox"),
    CHROME("Chrome"),
    SAFARI("Safari");
    public final String name;

    Browsers(String name) {
        this.name = name;
    }
}
