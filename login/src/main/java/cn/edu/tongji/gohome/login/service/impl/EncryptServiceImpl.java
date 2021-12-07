package cn.edu.tongji.gohome.login.service.impl;

import cn.edu.tongji.gohome.login.config.EncryptorConfig;
import cn.edu.tongji.gohome.login.service.EncryptService;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * EncryptServiceImpl
 *
 * @author 卓正一
 * @since 2021/12/7 4:05 PM
 */
@Service
@EnableConfigurationProperties(EncryptorConfig.class)
public class EncryptServiceImpl implements EncryptService {

    private final StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();

    @Resource
    EncryptorConfig encryptorConfig;

    private boolean isSetup = false;

    private void setup() {
        if (!isSetup) {
            standardPBEStringEncryptor.setAlgorithm(encryptorConfig.getAlgorithm());
            standardPBEStringEncryptor.setPassword(encryptorConfig.getPassword());
            isSetup = true;
        }
    }

    @Override
    public String encryptPassword(String pwd) {
        setup();
        return  standardPBEStringEncryptor.encrypt(pwd);
    }

    @Override
    public Boolean comparePasswords(String secret, String origin) {
        setup();
        return standardPBEStringEncryptor.decrypt(secret).equals(origin);
    }

}
