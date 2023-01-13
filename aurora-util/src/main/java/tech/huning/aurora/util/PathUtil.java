package tech.huning.aurora.util;

import java.io.File;
import java.util.Objects;

/**
 * Path工具类
 *
 * <p>更多内容参看<a href="https://huning.tech"><b>胡宁Tech</b></a>
 * @author huning
 */
public class PathUtil {

    private PathUtil(){

    }

    public static String format(String path) {
        if(Objects.isNull(path) || path.isEmpty()) {
            return path;
        }
        if(path.endsWith(File.separator)) {
            return path;
        }
        return path + File.separator;
    }

}
