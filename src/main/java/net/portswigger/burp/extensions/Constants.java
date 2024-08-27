package net.portswigger.burp.extensions;

import java.util.HashMap;
import java.util.Map;

public class Constants {


    public static int MAX_ATTEMPTS = 3;
    public static String BURP_TLS_NEGOTIATION = "use_custom";
    public static String MATCH_AND_REPLACE_RULE_TYPE = "request_header";
    public static String MATCH_AND_REPLACE_REGEXP = "^User-Agent.*$";

    public static String[] MATCH_AND_REPLACE_REGEXP_HTTP2 = new String[] {
            "^Sec-Ch-Ua:.*$",
            "^Sec-Ch-Ua-Mobile:.*$",
            "^Sec-Ch-Ua-Platform:.*$",
            "^Sec-Fetch-Site:.*$",
            "^Sec-Fetch-Mode:.*$",
            "^Sec-Fetch-User:.*$",
            "^Sec-Fetch-Dest:.*$",
//            "^Sec-CH-UA-Arch:.*$",
//            "^Sec-CH-UA-Bitness:.*$",
//            "^Sec-CH-UA-Model:.*$",
//            "^Sec-CH-UA-Platform-Version:.*$",
//            "^Sec-CH-UA-Form-Factors:.*$",
//            "^Sec-CH-UA-Full-Version-List:.*$",
//            "^Sec-CH-UA-WoW64:.*$",
//            "^Priority:.*$"
    };
    public static String FROZEN_UA = "User-Agent: Mozilla/5.0 (%s) %s";

    public static Map<String,String> FIREFOX_PLATFORMS = Map.of(
            "Windows",
            "Windows NT 10.0; Win64; x64; rv:129.0",
            "Mac",
            "Macintosh; Intel Mac OS X 14.6; rv:129.0",
            "Linux",
            "X11; Linux x86_64; rv:129.0");
    public static Map<String,String> CHROME_PLATFORMS = Map.of(
            "Windows",
            "Windows NT 10.0; Win64; x64",
            "Mac",
            "Macintosh; Intel Mac OS X 10_15_7",
            "Linux",
            "X11; Linux x86_64");
    public static Map<String,String> SAFARI_PLATFORMS = Map.of(
            "Windows",
            "Macintosh; Intel Mac OS X 10_15_7",
            "Mac",
            "Macintosh; Intel Mac OS X 10_15_7",
            "Linux",
            "Macintosh; Intel Mac OS X 10_15_7");
    // Platforms
    public static Map<String,Map<String,String>> BROWSERS_PLATFORMS = Map.of(
            "Firefox", FIREFOX_PLATFORMS,
            "Chrome", CHROME_PLATFORMS,
            "Safari", SAFARI_PLATFORMS
    );
    // Browsers
    public static Map<String,String> BROWSERS_USER_AGENTS = Map.of(
            "Firefox", "User-Agent: Mozilla/5.0 (%s) Gecko/20100101 Firefox/129.0",
            "Chrome", "User-Agent: Mozilla/5.0 (%s) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36",
            "Safari", "User-Agent: Mozilla/5.0 (%s) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.5 Safari/605.1.15"
    );
    public static Map<String,String[]> BROWSERS_PROTOCOLS = Map.of(
            "Firefox", new String[]{"TLSv1.2", "TLSv1.3"},
            "Chrome", new String[]{"TLSv1.2", "TLSv1.3"},
            // ! Burp Suite TLS protocol version is TLSv1
            "Safari", new String[]{"TLSv1.3", "TLSv1.2", "TLSv1.1", "TLSv1"}
    );
    public static Map<String,String[]> BROWSERS_CIPHERS = Map.of(
            "Firefox", new String[]{
                    "TLS_AES_128_GCM_SHA256",
                    "TLS_CHACHA20_POLY1305_SHA256",
                    "TLS_AES_256_GCM_SHA384",
                    "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
                    "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
                    "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256",
                    "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256",
                    "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384",
                    "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
                    "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA",
                    "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
                    "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA",
                    "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA",
                    "TLS_RSA_WITH_AES_128_GCM_SHA256",
                    "TLS_RSA_WITH_AES_256_GCM_SHA384",
                    "TLS_RSA_WITH_AES_128_CBC_SHA",
                    "TLS_RSA_WITH_AES_256_CBC_SHA"},
            "Chrome", new String[]{
                    "TLS_AES_128_GCM_SHA256",
                    "TLS_AES_256_GCM_SHA384",
                    "TLS_CHACHA20_POLY1305_SHA256",
                    "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
                    "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
                    "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384",
                    "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
                    "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256",
                    "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256",
                    "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA",
                    "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA",
                    "TLS_RSA_WITH_AES_128_GCM_SHA256",
                    "TLS_RSA_WITH_AES_256_GCM_SHA384",
                    "TLS_RSA_WITH_AES_128_CBC_SHA",
                    "TLS_RSA_WITH_AES_256_CBC_SHA"
            },
            "Safari", new String[]{
                    "TLS_AES_128_GCM_SHA256",
                    "TLS_AES_256_GCM_SHA384",
                    "TLS_CHACHA20_POLY1305_SHA256",
                    "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384",
                    "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
                    "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256",
                    "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
                    "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
                    "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256",
                    "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA",
                    "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
                    "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA",
                    "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA",
                    "TLS_RSA_WITH_AES_256_GCM_SHA384",
                    "TLS_RSA_WITH_AES_128_GCM_SHA256",
                    "TLS_RSA_WITH_AES_256_CBC_SHA",
                    "TLS_RSA_WITH_AES_128_CBC_SHA",
                    "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA",
                    "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA",
                    "SSL_RSA_WITH_3DES_EDE_CBC_SHA"
            }
    );

    // https://developers.cloudflare.com/ssl/reference/cipher-suites/supported-cipher-suites/
    public static Map<String[],String[]> BRUTEFORCE_CIPHERS = Map.of(
            new String[]{"TLSv1.3"}, new String[]{
                    "TLS_AES_128_GCM_SHA256",
                    "TLS_AES_256_GCM_SHA384",
                    "TLS_CHACHA20_POLY1305_SHA256"},
            new String[]{"TLSv1.2"}, new String[]{
                    "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
                    "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256",
                    "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
                    "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256",
                    "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256",
                    "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256",
                    "TLS_RSA_WITH_AES_128_GCM_SHA256",
                    "TLS_RSA_WITH_AES_128_CBC_SHA256",
                    "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384",
                    "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384",
                    "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
                    "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384",
                    "TLS_RSA_WITH_AES_256_GCM_SHA384",
                    "TLS_RSA_WITH_AES_256_CBC_SHA256" },
            new String[]{"TLSv1"}, new String[]{
                    "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
                    "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA",
                    "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA",
                    "TLS_RSA_WITH_AES_128_CBC_SHA",
                    "TLS_RSA_WITH_AES_256_CBC_SHA",
                    "SSL_RSA_WITH_3DES_EDE_CBC_SHA"},
            // Firefox ciphers
            new String[]{"TLSv1.2", "TLSv1.3"}, new String[]{
                    "TLS_AES_128_GCM_SHA256",
                    "TLS_CHACHA20_POLY1305_SHA256",
                    "TLS_AES_256_GCM_SHA384",
                    "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
                    "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
                    "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256",
                    "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256",
                    "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384",
                    "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
                    "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA",
                    "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
                    "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA",
                    "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA",
                    "TLS_RSA_WITH_AES_128_GCM_SHA256",
                    "TLS_RSA_WITH_AES_256_GCM_SHA384",
                    "TLS_RSA_WITH_AES_128_CBC_SHA",
                    "TLS_RSA_WITH_AES_256_CBC_SHA"},
            // Safari ciphers
            new String[]{"TLSv1.3", "TLSv1.2", "TLSv1.1", "TLSv1"}, new String[]{
                    "TLS_AES_128_GCM_SHA256",
                    "TLS_AES_256_GCM_SHA384",
                    "TLS_CHACHA20_POLY1305_SHA256",
                    "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384",
                    "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
                    "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256",
                    "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
                    "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
                    "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256",
                    "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA",
                    "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
                    "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA",
                    "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA",
                    "TLS_RSA_WITH_AES_256_GCM_SHA384",
                    "TLS_RSA_WITH_AES_128_GCM_SHA256",
                    "TLS_RSA_WITH_AES_256_CBC_SHA",
                    "TLS_RSA_WITH_AES_128_CBC_SHA",
                    "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA",
                    "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA",
                    "SSL_RSA_WITH_3DES_EDE_CBC_SHA"
            }
    );
    public static Map<Integer, String> defaultContextCipherSuites() {
        Map<Integer, String> cipherSuiteMap = new HashMap<>();
        cipherSuiteMap.put(47, "TLS_RSA_WITH_AES_128_CBC_SHA");
        cipherSuiteMap.put(50, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA");
        cipherSuiteMap.put(51, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA");
        cipherSuiteMap.put(53, "TLS_RSA_WITH_AES_256_CBC_SHA");
        cipherSuiteMap.put(56, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA");
        cipherSuiteMap.put(57, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA");
        cipherSuiteMap.put(60, "TLS_RSA_WITH_AES_128_CBC_SHA256");
        cipherSuiteMap.put(61, "TLS_RSA_WITH_AES_256_CBC_SHA256");
        cipherSuiteMap.put(64, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256");
        cipherSuiteMap.put(103, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256");
        cipherSuiteMap.put(106, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256");
        cipherSuiteMap.put(107, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256");
        cipherSuiteMap.put(156, "TLS_RSA_WITH_AES_128_GCM_SHA256");
        cipherSuiteMap.put(157, "TLS_RSA_WITH_AES_256_GCM_SHA384");
        cipherSuiteMap.put(158, "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256");
        cipherSuiteMap.put(159, "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384");
        cipherSuiteMap.put(162, "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256");
        cipherSuiteMap.put(163, "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384");
        cipherSuiteMap.put(255, "TLS_EMPTY_RENEGOTIATION_INFO_SCSV");
        cipherSuiteMap.put(4865, "TLS_AES_128_GCM_SHA256");
        cipherSuiteMap.put(4866, "TLS_AES_256_GCM_SHA384");
        cipherSuiteMap.put(4867, "TLS_CHACHA20_POLY1305_SHA256");
        cipherSuiteMap.put(49161, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA");
        cipherSuiteMap.put(49162, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA");
        cipherSuiteMap.put(49171, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
        cipherSuiteMap.put(49172, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA");
        cipherSuiteMap.put(49187, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256");
        cipherSuiteMap.put(49188, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384");
        cipherSuiteMap.put(49191, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");
        cipherSuiteMap.put(49192, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");
        cipherSuiteMap.put(49195, "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");
        cipherSuiteMap.put(49196, "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384");
        cipherSuiteMap.put(49199, "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
        cipherSuiteMap.put(49200, "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");
        cipherSuiteMap.put(52392, "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
        cipherSuiteMap.put(52393, "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256");
        cipherSuiteMap.put(52394, "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
        // Safari
        cipherSuiteMap.put(49160,"TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA");
        cipherSuiteMap.put(49170,"TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA");
        cipherSuiteMap.put(10,"SSL_RSA_WITH_3DES_EDE_CBC_SHA");

        return cipherSuiteMap;
    }
}
