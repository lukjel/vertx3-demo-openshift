package com.git;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.impl.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.handler.sockjs.BridgeOptions;
import io.vertx.ext.web.handler.sockjs.PermittedOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;

public class ServerVerticle extends AbstractVerticle {

    private static final Logger log                 = LoggerFactory.getLogger(ServerVerticle.class);

    @Override
    public void start() throws Exception {
        log.debug("start");
        String httpAddress = System.getProperty("http.address");
        String httpPort = System.getProperty("http.port");
        log.debug(" : address=" + httpAddress + " port=" + httpPort);
        if (httpPort == null) {
            log.debug(" : httpPort null - def: 8000");
            httpPort = "8000";
        }
        if (httpAddress==null) {
            log.debug(" : httpAddress null - def: localhost");
            httpAddress = "localhost";
        }
        int port = Integer.parseInt(httpPort);
        HttpServer http = vertx.createHttpServer();
        SockJSHandler sockJS = SockJSHandler.create(vertx);
        BridgeOptions allAccessOptions = new BridgeOptions().addInboundPermitted(new PermittedOptions().setAddress("test")).addOutboundPermitted(new PermittedOptions().setAddress("test"));
        sockJS.bridge(allAccessOptions);
        Router router = Router.router(vertx);
        router.route("/eventbus/*").handler(sockJS);
        router.route("/*").handler(StaticHandler.create("webroot"));
        http.requestHandler(router::accept).listen(port,httpAddress);
        log.debug("start end");
    }
}
