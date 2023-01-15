package tech.huning.aurora.util.async.specs;

import tech.huning.aurora.util.async.exception.AsyncException;

/**
 * 异步任务处理溢出处理器
 *
 * <p>更多内容参看<a href="https://huning.tech"><b>胡宁Tech</b></a>
 * @author huning
 */
public interface IAsyncOverflowHandler {

    void handle(IAsyncTask task) throws AsyncException;

}
