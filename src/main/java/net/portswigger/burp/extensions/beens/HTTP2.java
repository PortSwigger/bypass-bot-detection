package net.portswigger.burp.extensions.beens;

import com.google.gson.annotations.Expose;

public class HTTP2 {
    private @Expose boolean enable_http2;

    public HTTP2(boolean enable_http2) {
        this.enable_http2 = enable_http2;
    }

    public boolean getEnableHTTP2() {
        return enable_http2;
    }

    public void setEnableHTTP2(boolean enable_http2) {
        this.enable_http2 = enable_http2;
    }
}
