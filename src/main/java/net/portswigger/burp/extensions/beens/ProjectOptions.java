package net.portswigger.burp.extensions.beens;

import com.google.gson.annotations.Expose;

public class ProjectOptions {
    private @Expose SSL ssl;

    public ProjectOptions(SSL ssl) {
        this.ssl = ssl;
    }

    public SSL getSsl() {
        return ssl;
    }

    public void setSsl(SSL ssl) {
        this.ssl = ssl;
    }
}
