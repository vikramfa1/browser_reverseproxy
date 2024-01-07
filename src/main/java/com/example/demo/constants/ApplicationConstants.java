package com.example.demo.constants;

public class ApplicationConstants {

    public static final String[] CIPHERS_ORDERED = {
            "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384",
            "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
            "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384",
            "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256",
            "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA",
            "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
            "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", // N-ssllabs
            "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", // N-ssllabs
            // "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", // N-bctls, ssllabs[3,4]
            "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256",
            "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", // N-ssllabs
            "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256",
            "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256",
            // "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", // N-ssllabs, N-bctls
            // "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", // N-bctls, ssllabs[3,4]
            // "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", // N-bctls, ssllabs[3,4]
            "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA",
            "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA",
            "TLS_RSA_WITH_AES_256_GCM_SHA384", // N-ssllabs
            "TLS_RSA_WITH_AES_128_GCM_SHA256",
            "TLS_RSA_WITH_AES_256_CBC_SHA256",
            "TLS_RSA_WITH_AES_128_CBC_SHA256",
            "TLS_RSA_WITH_AES_256_CBC_SHA",
            "TLS_RSA_WITH_AES_128_CBC_SHA"
    };
}
