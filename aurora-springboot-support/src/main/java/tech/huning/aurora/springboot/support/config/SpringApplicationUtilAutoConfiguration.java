package tech.huning.aurora.springboot.support.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import tech.huning.aurora.springboot.support.util.SpringApplicationUtil;

@Configuration
public class SpringApplicationUtilAutoConfiguration implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(SpringApplicationUtilAutoConfiguration.class);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(logger.isDebugEnabled()) {
            logger.debug("setApplicationContext:{}", applicationContext);
        }
        SpringApplicationUtil.setApplicationContext(applicationContext);
    }

}
