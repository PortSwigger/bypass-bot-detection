package net.portswigger.burp.extensions.beens;

import com.google.gson.annotations.Expose;

public class ClientCertificate {
    private final @Expose  String[] certificates;
    private final @Expose boolean use;

    public ClientCertificate(String[] certificates, boolean use) {
        this.certificates = certificates;
        this.use = use;
    }
}
