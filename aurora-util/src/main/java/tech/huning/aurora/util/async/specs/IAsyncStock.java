package tech.huning.aurora.util.async.specs;

import java.util.List;

public interface IAsyncStock {

    int getTotal();
    List<IAsyncTask> getList();

}
