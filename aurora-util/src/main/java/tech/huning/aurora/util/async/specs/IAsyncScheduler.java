package tech.huning.aurora.util.async.specs;

import tech.huning.aurora.util.async.exception.AsyncException;

public interface IAsyncScheduler {

    IAsyncQueue getClient(IAsyncTopic topic) throws AsyncException;

    IAsyncQueue getServer(IAsyncConfig config) throws AsyncException;

    IAsyncQueue getServer(IAsyncTopic topic) throws AsyncException;

}
