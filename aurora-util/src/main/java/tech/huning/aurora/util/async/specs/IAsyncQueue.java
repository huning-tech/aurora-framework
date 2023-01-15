package tech.huning.aurora.util.async.specs;

import tech.huning.aurora.util.async.exception.AsyncException;

/**
 * 异步任务队列
 *
 * <p>更多内容参看<a href="https://huning.tech"><b>胡宁Tech</b></a>
 * @author huning
 */
public interface IAsyncQueue {

    IAsyncQueue schedule(IAsyncTask task) throws AsyncException;

    IAsyncQueue register(IAsyncExecutor executor) throws AsyncException;

    IAsyncQueue register(IAsyncOverflowHandler handler) throws AsyncException;

    IAsyncStock getStock() throws AsyncException;

    IAsyncHandling getHandling() throws AsyncException;

    void listen() throws AsyncException;

    void shutdown();

}
