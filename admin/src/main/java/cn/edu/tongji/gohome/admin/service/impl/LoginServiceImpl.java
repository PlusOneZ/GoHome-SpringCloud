package cn.edu.tongji.gohome.admin.service.impl;

import cn.edu.tongji.gohome.admin.dto.ReturnLogin;
import cn.edu.tongji.gohome.admin.model.AdministratorEntity;
import cn.edu.tongji.gohome.admin.repository.AdministratorEntityRepository;
import cn.edu.tongji.gohome.admin.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;


@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private AdministratorEntityRepository administratorEntityRepository;

    @Override
    public ReturnLogin getLogin(String adminName, String password) {

        AdministratorEntity real=administratorEntityRepository.findDistinctByAdminName(adminName);
        ReturnLogin res=new ReturnLogin();
        res.setLoginState(real.getAdminPassword().equals(password));

        if(res.getLoginState()) {
            res.setUserAvatar(real.getAdminAvatarLink());
            res.setUserName(real.getAdminName());
        }
        return res;
    }
}
