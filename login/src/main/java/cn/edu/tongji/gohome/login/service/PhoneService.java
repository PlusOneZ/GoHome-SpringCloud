package cn.edu.tongji.gohome.login.service;

import org.springframework.stereotype.Service;

@Service
public interface PhoneService {
    Boolean isPhoneValidate(String phoneNumber);
}
