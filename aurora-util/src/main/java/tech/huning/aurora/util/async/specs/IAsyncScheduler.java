package tech.huning.aurora.util.async.specs;

import tech.huning.aurora.util.async.exception.AsyncException;

/**
 * 异步任务调度器
 *
 * <p>更多内容参看<a href="https://huning.tech"><b>胡宁Tech</b></a>
 * @author huning
 */
public interface IAsyncScheduler {

    IAsyncQueue getClient(IAsyncTopic topic) throws AsyncException;

    IAsyncQueue getServer(IAsyncConfig config) throws AsyncException;

    IAsyncQueue getServer(IAsyncTopic topic) throws AsyncException;

}
