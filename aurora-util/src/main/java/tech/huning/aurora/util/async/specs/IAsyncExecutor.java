package tech.huning.aurora.util.async.specs;

import tech.huning.aurora.util.async.exception.AsyncException;

public interface IAsyncExecutor<T> {

    default void run(IAsyncTask<T> task) throws InterruptedException {
        try{
            exec(task);
            succ(task);
        }catch (AsyncException e) {
            fail(task, e);
        }catch (InterruptedException e) {
            throw e;
        } catch (Exception e) {
            fail(task, new AsyncException(e));
        }
    }

    void exec(IAsyncTask<T> task) throws AsyncException, InterruptedException;

    default void fail(IAsyncTask<T> task, AsyncException exception) {

    }

    default void succ(IAsyncTask<T> task) {

    }

}
