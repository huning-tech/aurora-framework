package tech.huning.aurora.util.async.specs;

import tech.huning.aurora.util.async.exception.AsyncException;

public interface IAsyncQueue {

    IAsyncQueue schedule(IAsyncTask task) throws AsyncException;

    IAsyncQueue register(IAsyncExecutor executor) throws AsyncException;

    IAsyncQueue register(IAsyncOverflowHandler handler) throws AsyncException;

    IAsyncStock getStock() throws AsyncException;

    IAsyncHandling getHandling() throws AsyncException;

    void listen() throws AsyncException;

    void shutdown();

}
