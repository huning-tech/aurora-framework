package tech.huning.aurora.util.async.exception;

import tech.huning.aurora.specs.exception.CommonException;
import tech.huning.aurora.specs.model.ResultCode;
import tech.huning.aurora.util.StringUtil;
import tech.huning.aurora.util.async.core.AsyncFault;
import tech.huning.aurora.util.async.specs.IAsyncFault;

public class AsyncException extends CommonException {

    private IAsyncFault asyncFault;

    public AsyncException(IAsyncFault resultCode) {
        this(resultCode, null);
    }

    public AsyncException(Throwable cause) {
        this(AsyncFault.SERVICE_EXCEPTION, cause);
    }

    public AsyncException(IAsyncFault asyncFault, Throwable cause) {
        super(cause, ResultCode.ASYNC_FAILURE.getCode(),
                StringUtil.isEmpty(asyncFault.getMessage()) ? ResultCode.ASYNC_FAILURE.getMsg() : asyncFault.getMessage());
        this.asyncFault = asyncFault;
    }

    public IAsyncFault getAsyncFault() {
        return asyncFault;
    }

}
