package com.example.demo.router;

import com.example.demo.handler.*;
import io.vertx.rxjava.core.Vertx;
import io.vertx.rxjava.ext.web.Router;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderRouter {

    @Autowired
    URLRewriteHandler urlRewriteHandler;

    @Autowired
    UserPolicyValidationHandler userPolicyValidationHandler;

    @Autowired
    BlockUrlListValidationHandler blockUrlListValidationHandler;

    public Router apiRouter(Vertx vertx) {
        Router router = Router.router(vertx);

        router.route("/AccessDenied").handler(urlRewriteHandler::serveAccessDeniedPage);
        router.route().handler(userPolicyValidationHandler::validateUserPolicy);
        router.route().handler(blockUrlListValidationHandler::validateBlockUrlList);
        router.route().handler(urlRewriteHandler::setRequestBodyContext);
        router.route().handler(urlRewriteHandler::getURLDataResponse);
        return router;
    }
}
