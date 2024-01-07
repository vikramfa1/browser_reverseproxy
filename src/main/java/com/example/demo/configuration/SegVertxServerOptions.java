package com.example.demo.configuration;

import io.vertx.core.http.ClientAuth;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.net.PfxOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Stream;

import static com.example.demo.constants.ApplicationConstants.CIPHERS_ORDERED;

@Component
@Slf4j
public class SegVertxServerOptions {

    @Bean
    public HttpServerOptions vertxServerOptions() {
        HttpServerOptions serverOptions = new HttpServerOptions();
        PfxOptions pfxOptions = new PfxOptions();
        pfxOptions.setPassword("awvmware331!");
        pfxOptions.setPath("src/main/resources/rootCA.pfx");
        serverOptions.setSsl(true).setPfxKeyCertOptions(pfxOptions);
        Stream.of(CIPHERS_ORDERED).forEach(serverOptions::addEnabledCipherSuite);
        Arrays.asList("TLSv1.1", "TLSv1.2", "TLSv1.3").forEach(serverOptions::addEnabledSecureTransportProtocol);
        log.info("configured https server options with keystore");
        setPfxTrustStoreOptions(serverOptions);
        serverOptions.setClientAuth(ClientAuth.REQUIRED);
        return serverOptions;
    }

    private void setPfxTrustStoreOptions(HttpServerOptions httpServerOptions) {
        final PfxOptions pfxOptions = new PfxOptions();
        final String keyStorePath = "src/main/resources/client-keystore.pfx";
        log.info("Trust-store certificates absolute path = {}", keyStorePath);
        pfxOptions.setPath(keyStorePath);
        pfxOptions.setPassword("password");
        httpServerOptions.setPfxTrustOptions(pfxOptions);
        log.info("configured https server options with keystore");
    }


}
