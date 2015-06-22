package com.git;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.impl.LoggerFactory;

public class ServerStarter {

    static {
        System.setProperty("vertx.logger-delegate-factory-class-name", Log4j2DelegateFactory.class.getCanonicalName());
    }
    private static final Logger log = LoggerFactory.getLogger(ServerStarter.class);

    public static void main(String[] args) {
        VertxOptions options = new VertxOptions();
        options.setClustered(true);
        Vertx.clusteredVertx(options, vertxHandler -> {
            if (vertxHandler.succeeded()) {
                log.error(" ------------------------ cluster ok");
                Vertx vertx = vertxHandler.result();
                vertx.deployVerticle(ServerVerticle.class.getCanonicalName());
            } else {
                log.error(" ######################## error", vertxHandler.cause());
            }
        });
    }
}
