package cn.edu.tongji.gohome.login.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * SmschineseConfig
 *
 * @author 卓正一
 * @since 2021/12/14 3:46 PM
 */
@Configuration
@ConfigurationProperties(prefix = "smschinese", ignoreUnknownFields = false)
@PropertySource("classpath:config/secret.properties")
@Data
@Component
public class SmschineseConfig {
    private String appkey;
    private String userid;
}
