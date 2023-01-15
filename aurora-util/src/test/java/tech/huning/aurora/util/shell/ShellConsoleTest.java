package tech.huning.aurora.util.shell;

import tech.huning.aurora.util.os.SystemUtil;
import tech.huning.aurora.util.shell.exception.ShellException;
import org.junit.Test;
import tech.huning.aurora.util.shell.model.ShellCommand;

/**
 * Shell控制台(执行器)测试
 *
 * <p>更多内容参看<a href="https://huning.tech"><b>胡宁Tech</b></a>
 * @author huning
 */
public class ShellConsoleTest {

    @Test
    public void test() throws ShellException {
        if(SystemUtil.isLinux()) {
            ShellConsole.getInstance().exec(new ShellCommand("ps -ef"));
        }
    }

}
