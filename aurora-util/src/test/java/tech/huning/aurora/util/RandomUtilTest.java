package tech.huning.aurora.util;

import org.junit.Test;

import java.util.UUID;
import java.util.logging.Logger;

/**
 *
 *
 * <p>更多内容参看<a href="https://huning.tech"><b>胡宁Tech</b></a>
 * @author huning
 */
public class RandomUtilTest {

    @Test
    public void test() {
        Logger.getGlobal().info(RandomUtil.getString(64));
        Logger.getGlobal().info(UUID.randomUUID().toString().replaceAll("-", ""));
    }

}
