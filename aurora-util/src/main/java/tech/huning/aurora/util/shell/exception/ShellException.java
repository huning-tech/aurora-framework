package tech.huning.aurora.util.shell.exception;

public class ShellException extends Exception {

    public ShellException() {
        super();
    }

    public ShellException(String message) {
        super(message);
    }

    public ShellException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShellException(Throwable cause) {
        super(cause);
    }

}
