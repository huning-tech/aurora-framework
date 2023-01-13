package tech.huning.aurora.util.async.core;

import tech.huning.aurora.util.async.specs.IAsyncConfig;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class AsyncThreadFactory implements ThreadFactory {

    private IAsyncConfig config;

    private AtomicInteger threadId;

    private static AsyncThreadFactory instance;

    private AsyncThreadFactory(IAsyncConfig config){
        this.config = config;
        this.threadId = new AtomicInteger(config.getThreadStartId());
    }

    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable,this.config.getThreadPrefix() + this.threadId.incrementAndGet());
        thread.setDaemon(false);
        return thread;
    }

    public static AsyncThreadFactory build(IAsyncConfig config) {
        if(null != instance) {
            return instance;
        }
        synchronized (AsyncThreadFactory.class) {
            instance = new AsyncThreadFactory(config);
        }
        return instance;
    }

}
