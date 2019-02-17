package com.onemena.game.custom.handler;

import org.tio.core.ChannelContext;

import com.google.protobuf.MessageLite;

/**
 * @author nonpool
 * @version 1.0
 * @since 2018/1/29
 */
public abstract class AbstractDataHandler<T extends MessageLite> implements DataHandler<T> {

    /**
     * 统一异常处理方法
     */
    @Override
    public void handler(T t, ChannelContext ctx) {
        try {
            this.onEvent(t, ctx);
        } catch (Exception e) {
            exceptionCaught(e);
        }
    }


    /**
     * 暴露给子类的业务逻辑处理方法
     *
     * @param t   消息对象
     * @param ctx
     * @throws Exception
     */
    abstract void onEvent(T t, ChannelContext ctx) throws Exception;

    /**
     * 异常处理
     *
     * @param cause
     */
    void exceptionCaught(Throwable cause) {

    }
}
