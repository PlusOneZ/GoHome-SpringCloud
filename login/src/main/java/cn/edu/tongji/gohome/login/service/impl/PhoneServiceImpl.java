package cn.edu.tongji.gohome.login.service.impl;

import cn.edu.tongji.gohome.login.service.PhoneService;
import org.springframework.stereotype.Service;

/**
 * PhoneServiceImple类
 *
 * @author 汪明杰
 * @date 2021/12/6 11:22
 */
@Service
public class PhoneServiceImpl implements PhoneService {

    private static final int PHONE_LENGTH_CN = 11;

    @Override
    public Boolean isPhoneValidate(String phoneNumber){
        return phoneNumber.length() == PHONE_LENGTH_CN;
    }
}
