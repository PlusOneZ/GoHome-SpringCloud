package cn.edu.tongji.gohome.login.service;

import cn.edu.tongji.gohome.login.dto.CustomerBriefInfoDTO;
import cn.edu.tongji.gohome.login.dto.VerifyCodeToken;
import org.springframework.stereotype.Service;

/**
 * LoginService
 *
 * @author 卓正一
 * @since 2021/11/22 8:56 PM
 */
@Service
public interface LoginService {
    Boolean checkUserLogin(String userPhone, String password);

    Boolean checkAdminLogin(String adminName, String password);

    Long getCustomerIdByPhone(String phone);

    Integer getAdminIdByName(String adminName);

    CustomerBriefInfoDTO getCustomerBriefInfoByCustomerId(Long id);

    VerifyCodeToken getVerificationCodeAndToken();

    String getCustomerPhoneById(Long id);
}
