package com.git;

import io.vertx.core.logging.impl.LogDelegate;
import io.vertx.core.logging.impl.LogDelegateFactory;

/**
 *
 * @author lzeligowski
 */
public class Log4j2DelegateFactory implements LogDelegateFactory {

    @Override
    public LogDelegate createDelegate(String name) {
        return new Log4j2Delegate(name);
    }

}
