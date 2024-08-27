package net.portswigger.burp.extensions.beens;

public enum OS {
    WINDOWS("Windows"),
    MACOS("Mac"),
    LINUX("Linux");
    public final String name;

    OS(String name) {
        this.name = name;
    }
}
