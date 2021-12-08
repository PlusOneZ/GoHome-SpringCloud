package cn.edu.tongji.gohome.login.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * AliyunCloudConfig
 *
 * @author 卓正一
 * @since 2021/12/8 1:43 PM
 */
@Configuration
@ConfigurationProperties(prefix = "aliyuncloud", ignoreUnknownFields = false)
@PropertySource("classpath:config/secret.properties")
@Data
@Component
public class AliyunCloudConfig {
    private String appcode;
}
