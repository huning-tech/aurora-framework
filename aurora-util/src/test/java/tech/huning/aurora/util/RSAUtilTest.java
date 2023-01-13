package tech.huning.aurora.util;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Map;
import java.util.logging.Logger;

/**
 * RSA工具类测试
 *
 * <p>更多内容参看<a href="https://huning.tech"><b>胡宁Tech</b></a>
 * @author huning
 */
public class RSAUtilTest {

    @Test
    public void test() {
        Map<String, String> keys = RSAUtil.createKeys(512);
        Logger.getGlobal().info(JSON.toJSONString(keys));
    }

}
