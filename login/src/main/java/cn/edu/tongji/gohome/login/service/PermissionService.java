package cn.edu.tongji.gohome.login.service;

import org.springframework.stereotype.Service;

@Service
public interface PermissionService {
    Boolean checkUserIsHost(Long id);
    Boolean checkIsUser(Long id);
    Boolean checkIsAdmin(Long id);
}
