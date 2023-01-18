package tech.huning.aurora.springboot.support.log;

import org.springframework.boot.context.properties.ConfigurationProperties;
import tech.huning.aurora.springframework.support.log.LogConfig;

/**
 * 日志配置信息
 *
 * <p>更多内容参看<a href="https://huning.tech"><b>胡宁Tech</b></a>
 * @author huning
 */
@ConfigurationProperties(prefix = LogConfig.PREFIX)
public class LogProperties extends LogConfig {

}
