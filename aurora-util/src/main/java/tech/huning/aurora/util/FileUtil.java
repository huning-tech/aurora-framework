package tech.huning.aurora.util;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class FileUtil {

    public static void deleteFiles(File file){

        if(null == file || !file.exists()) {
            return;
        }

        if(file.isDirectory()) {
            Arrays.stream(Objects.requireNonNull(file.listFiles())).forEach(FileUtil::deleteFiles);
        }

        file.delete();
    }

}
