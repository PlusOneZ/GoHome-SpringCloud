package cn.edu.tongji.gohome.gateway.utils;

import cn.dev33.satoken.stp.StpInterface;
import cn.edu.tongji.gohome.gateway.service.PermissionService;
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
        if (permissionService.checkUserIsHost((Long) loginId)) {
            permissions.add("all-host");
            permissions.add("all-customer");
        } else if (permissionService.checkIsUser((Long) loginId)) {
            permissions.add("all-customer");
        } else if (permissionService.checkIsAdmin((Long) loginId)){
            permissions.add("all-admin");
        } else {
            permissions.add("all-guest");
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
        } else if (permissionService.checkIsAdmin((Long) loginId)){
            role.add("admin");
        } else {
            role.add("guest");
        }
        return role;
    }
}
