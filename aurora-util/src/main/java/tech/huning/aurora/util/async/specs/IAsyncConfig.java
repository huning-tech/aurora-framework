package tech.huning.aurora.util.async.specs;

public interface IAsyncConfig {

    IAsyncTopic getTopic();

    default int getTaskCapacity() {
        return 200;
    }

    default int getExecutorCapacity() {
        return 1;
    }

    default int getConcurrent() {
        return 2;
    }

    default String getThreadPrefix(){
        return "async-scheduler-exec-";
    }

    default int getThreadStartId(){
        return 0;
    }

}
