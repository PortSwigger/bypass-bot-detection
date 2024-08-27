package net.portswigger.burp.extensions.beens;

import com.google.gson.annotations.Expose;

public class HTTP {
    private @Expose HTTP2 http2;

    public HTTP(HTTP2 http2) {
        this.http2 = http2;
    }

    public HTTP2 getHttp2() {
        return http2;
    }

    public void setHttp2(HTTP2 http2) {
        this.http2 = http2;
    }
}
