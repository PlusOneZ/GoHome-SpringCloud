package cn.edu.tongji.gohome.login.service;

import org.springframework.stereotype.Service;

/**
 * EncryptService
 *
 * @author 卓正一
 * @since 2021/12/7 4:04 PM
 */
@Service
public interface EncryptService {

    String encryptPassword(String pwd);

    Boolean comparePasswords(String secret, String origin);

}
