package cn.edu.tongji.gohome.login.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * EncryptorConfig
 *
 * @author 卓正一
 * @since 2021/12/7 4:45 PM
 */
@Configuration
@ConfigurationProperties(prefix = "encryptor", ignoreUnknownFields = false)
@PropertySource("classpath:config/secret.properties")
@Data
@Component
public class EncryptorConfig {
    private String password;
    private String algorithm;
}
