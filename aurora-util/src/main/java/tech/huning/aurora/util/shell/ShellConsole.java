package tech.huning.aurora.util.shell;

import tech.huning.aurora.util.shell.exception.ShellException;
import tech.huning.aurora.util.shell.model.ShellCommand;
import tech.huning.aurora.util.shell.model.ShellResult;
import tech.huning.aurora.util.shell.specs.IShellConsole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ShellConsole implements IShellConsole {

    private static Logger logger = LoggerFactory.getLogger(ShellConsole.class);

    private static ShellConsole instance = new ShellConsole();

    private ShellConsole(){}

    public static ShellConsole getInstance() {
        return instance;
    }

    @Override
    public ShellResult exec(ShellCommand cmd) throws ShellException {

        ShellResult shellResult = new ShellResult();
        Process process = null;
        try {
            logger.debug("execute {} start", cmd.getLine());

            List<String> cmds = new ArrayList<String>();
            cmds.add("sh");
            cmds.add("-c");
            cmds.add(cmd.getLine());
            ProcessBuilder pb =new ProcessBuilder(cmds);
            process = pb.start();

            logger.debug("execute {} waitFor", cmd.getLine());
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                throw new ShellException(e);
            }

            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            StringBuffer errorBuffer = new StringBuffer();
            String error;
            while ((error = errorReader.readLine()) != null) {
                errorBuffer.append(error);
            }

            if(errorBuffer.length() > 0) {
                shellResult.setSucc(false);
                shellResult.setError(errorBuffer.toString());
                logger.error("execute {}, error {}", cmd.getLine(), errorBuffer.toString());
                return shellResult;
            }

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuffer inputBuffer = new StringBuffer();
            String input;
            while ((input = inputReader.readLine()) != null) {
                inputBuffer.append(input);
            }

            if(inputBuffer.length() > 0) {
                shellResult.setData(inputBuffer.toString());
                logger.debug("execute {}, data {}", cmd.getLine(), inputBuffer.toString());
            }

            shellResult.setSucc(true);
        } catch (IOException e) {
            throw new ShellException(e);
        } finally {
            if(null != process) {
                process.destroy();
            }
        }

        logger.debug("execute {} finish, result {}", cmd.getLine(), shellResult.getData());
        return shellResult;
    }

}
