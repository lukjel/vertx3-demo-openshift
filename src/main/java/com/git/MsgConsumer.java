package com.git;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class MsgConsumer extends AbstractVerticle {

    private static final Logger log = LoggerFactory.getLogger(MsgConsumer.class);

    @Override
    public void start() throws Exception {
        log.debug("start");
        vertx.eventBus().consumer("test", (Message<JsonObject> msg) -> {
            log.debug("msg: " + msg.body());
            msg.reply("hello!");
           
        });
        log.debug("start end");
    }
}
