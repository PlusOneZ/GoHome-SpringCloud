package cn.edu.tongji.gohome.admin.service;

import cn.edu.tongji.gohome.admin.dto.ReturnLogin;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    ReturnLogin getLogin(String adminName, String password);

}
