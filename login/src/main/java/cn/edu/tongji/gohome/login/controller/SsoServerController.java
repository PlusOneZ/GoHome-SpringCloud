package cn.edu.tongji.gohome.login.controller;

import cn.dev33.satoken.config.SaTokenConfig;
import cn.dev33.satoken.sso.SaSsoHandle;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import cn.edu.tongji.gohome.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * SsoServerController
 *
 * @author 卓正一
 * @since 2021/12/1 7:49 PM
 */
@RestController
//@RequestMapping("api/v1/login/")
public class SsoServerController {

    @Resource
    LoginService loginService;

    /*
     * SSO-Server端：处理所有SSO相关请求 (下面的章节我们会详细列出开放的接口)
     */
    @RequestMapping("/sso/*")
    public Object ssoRequest() {
        SaSsoHandle.ssoDoLogin();

        return SaSsoHandle.serverRequest();
    }

    /**
     * 配置SSO相关参数
     */
    @Autowired
    private void configSso(SaTokenConfig cfg) {
        // 配置：未登录时返回的View
        cfg.sso.setNotLoginView(() -> {
            String msg = "not logged in";
            // TODO 这段代码要让前端知道没登陆并且跳转到登陆界面。
            return msg;
        });

        // 配置：登录处理函数
        cfg.sso.setDoLoginHandle((name, pwd) -> {
            // name: 电话号码，pwd 密码
//            if (loginService.checkUserLogin(name, pwd)) {
//                System.out.println("成功");
//                System.out.println(loginService.getCustomerIdByPhone(name));
//
//                StpUtil.login(loginService.getCustomerIdByPhone(name));
//
//                return SaResult.ok("登录成功！").setData(StpUtil.getTokenValue());
//            }
//
//            System.out.println("失败");
//            return SaResult.error("登录失败！");
            // 此处仅做模拟登录，真实环境应该查询数据进行登录
            if("sa".equals(name) && "123456".equals(pwd)) {
                StpUtil.login(10001);
                return SaResult.ok("登录成功！").setData(StpUtil.getTokenValue());
            }
            return SaResult.error("登录失败！");
        });
    }

}