package tech.huning.aurora.util.async.specs;

import tech.huning.aurora.util.async.exception.AsyncException;

public interface IAsyncOverflowHandler {

    void handle(IAsyncTask task) throws AsyncException;

}
