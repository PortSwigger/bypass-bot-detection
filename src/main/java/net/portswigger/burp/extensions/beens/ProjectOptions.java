package net.portswigger.burp.extensions.beens;

import com.google.gson.annotations.Expose;

public class ProjectOptions {
    private @Expose SSL ssl;
    private @Expose HTTP http;

    public ProjectOptions(SSL ssl) {
        this.ssl = ssl;
    }

    public SSL getSsl() {
        return ssl;
    }
    public HTTP getHTTP() {
        return http;
    }

    public void setSsl(SSL ssl) {
        this.ssl = ssl;
    }
    public void setHTTP(HTTP http) {
        this.http = http;
    }
}
