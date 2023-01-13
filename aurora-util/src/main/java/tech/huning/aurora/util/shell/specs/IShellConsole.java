package tech.huning.aurora.util.shell.specs;


import tech.huning.aurora.util.shell.exception.ShellException;
import tech.huning.aurora.util.shell.model.ShellCommand;
import tech.huning.aurora.util.shell.model.ShellResult;

public interface IShellConsole {

    ShellResult exec(ShellCommand cmd) throws ShellException;

}
