package com.example.demo.service;

import com.example.demo.router.SenderRouter;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.rxjava.core.AbstractVerticle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class VertxHttpServerArticle extends AbstractVerticle {


    @Autowired
    SenderRouter senderRouter;

    @Autowired
    HttpServerOptions vertxServerOptions;

    @Value("${server.port}")
    private int port;

    @Override
    public void start(Promise<Void> startFuture) {
        startServer(startFuture);
    }
    public void startServer(Promise<Void> startFuture) {
        vertx.createHttpServer(vertxServerOptions)
                .requestHandler(senderRouter.apiRouter(vertx))
                .listen(port,"localhost", result -> {
                if(result.succeeded()) {
                    log.info("Listening on {}", port);
                    System.out.println("cluster1 vertx: " + vertx.isClustered());
                    startFuture.complete();
                } else if(result.failed()) {
                    log.error("Unable to listen on {}", port);
                }
                });
    }
}
