package com.git;

import io.vertx.core.logging.impl.LogDelegate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author lzeligowski
 */
public class Log4j2Delegate implements LogDelegate {

    private Logger log;

    public Log4j2Delegate(String name) {
        this.log = LogManager.getLogger(name);
    }

    @Override
    public void debug(Object message) {
        log.debug(message);
    }

    @Override
    public void debug(Object message, Throwable t) {
        log.debug(message, t);
    }

    @Override
    public void error(Object message) {
        log.error(message);
    }

    @Override
    public void error(Object message, Throwable t) {
        log.error(message, t);
    }

    @Override
    public void fatal(Object message) {
        log.fatal(message);
    }

    @Override
    public void fatal(Object message, Throwable t) {
        log.fatal(message, t);
    }

    @Override
    public void info(Object message) {
        log.info(message);
    }

    @Override
    public void info(Object message, Throwable t) {
        log.info(message, t);
    }

    @Override
    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    @Override
    public boolean isInfoEnabled() {
        return log.isInfoEnabled();
    }

    @Override
    public boolean isTraceEnabled() {
        return log.isTraceEnabled();
    }

    @Override
    public void trace(Object message) {
        log.trace(message);
    }

    @Override
    public void trace(Object message, Throwable t) {
        log.trace(message, t);
    }

    @Override
    public void warn(Object message) {
        log.warn(message);
    }

    @Override
    public void warn(Object message, Throwable t) {
        log.warn(message, t);
    }

}
