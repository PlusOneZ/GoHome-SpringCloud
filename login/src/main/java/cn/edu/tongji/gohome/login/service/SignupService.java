package cn.edu.tongji.gohome.login.service;

import org.springframework.stereotype.Service;

/**
 * For Signup
 *
 * @author 卓正一
 * @since 2021-11-23 7:55 PM
 */
@Service
public interface SignupService {

    Boolean checkPhoneAvailable(String phoneCode, String phone);

    void changeCustomerPassword(String phoneCode, String phone, String newPassword);

    void changeCustomerPassword(Long userId, String newPassword);

    // TODO 分割一个发送短信的服务接口
    // TODO 一个身份证照片检验服务

    Long customerSignup(String phoneCode, String phone, String password, String username);

    Long customerSignup(String phoneCode, String phone, String password, String username, String gender);

    void hostSignup(String phoneCode, String phone, String password, String username, String IdCardNum, String realName, String gender);

    void hostSignup(String residentId, String realName, Long customerId);
}
