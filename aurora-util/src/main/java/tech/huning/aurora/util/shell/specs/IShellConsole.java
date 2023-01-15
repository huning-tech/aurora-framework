package tech.huning.aurora.util.shell.specs;

import tech.huning.aurora.util.shell.exception.ShellException;
import tech.huning.aurora.util.shell.model.ShellCommand;
import tech.huning.aurora.util.shell.model.ShellResult;

/**
 * Shell控制台(执行器)
 *
 * <p>更多内容参看<a href="https://huning.tech"><b>胡宁Tech</b></a>
 * @author huning
 */
public interface IShellConsole {

    ShellResult exec(ShellCommand cmd) throws ShellException;

}
