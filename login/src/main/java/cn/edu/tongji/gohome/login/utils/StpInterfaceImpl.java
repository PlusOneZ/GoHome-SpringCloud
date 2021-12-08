package cn.edu.tongji.gohome.login.utils;

import cn.dev33.satoken.stp.StpInterface;

import cn.edu.tongji.gohome.login.service.PermissionService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * StpInterfaceImpl
 *
 * @author 卓正一
 * @since 2021/11/22 10:33 PM
 */
@Component
public class StpInterfaceImpl implements StpInterface {
    @Resource
    PermissionService permissionService;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        List<String> permissions = new ArrayList<>();
        System.out.println(loginId);
        permissions.add("browse");
        if (permissionService.checkUserIsHost(Long.valueOf((String) loginId))) {
            permissions.add("stay");
            permissions.add("host");
        }
        if (permissionService.checkIsUser(Long.valueOf((String) loginId))) {
            if (!permissions.contains("host")) {
                permissions.add("upgrade");
            }
            permissions.add("order");
            permissions.add("purchase");
        }
        if (permissionService.checkIsAdmin(Long.valueOf((String) loginId))) {
            permissions.add("admin");
        }
        return permissions;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        List<String> role = new ArrayList<>();
        if (permissionService.checkUserIsHost((Long) loginId)) {
            role.add("host");
        } else if (permissionService.checkIsUser((Long) loginId)) {
            role.add("customer");
        } else if (permissionService.checkIsAdmin((Long) loginId)) {
            role.add("admin");
        } else {
            role.add("guest");
        }
        return role;
    }
}
