package tech.huning.aurora.util.async.specs;

/**
 * 异步任务
 *
 * <p>更多内容参看<a href="https://huning.tech"><b>胡宁Tech</b></a>
 * @author huning
 */
public interface IAsyncTask<T> {

    String getId();

    T getData();

}
