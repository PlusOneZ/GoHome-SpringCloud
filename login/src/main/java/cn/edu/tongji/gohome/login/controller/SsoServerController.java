package cn.edu.tongji.gohome.login.controller;

import cn.dev33.satoken.config.SaTokenConfig;
import cn.dev33.satoken.sso.SaSsoHandle;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import cn.edu.tongji.gohome.login.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "SSO")
@RestController
//@RequestMapping("api/v1/login/")
public class SsoServerController {

    @Resource
    LoginService loginService;

    /*
     * SSO-Server端：处理所有SSO相关请求
     */
    @RequestMapping("/sso/*")
    @ApiOperation(value = "SSO login", notes = "use /doLogin?name=<phone>&pwd=<password> to login.")
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
            if (loginService.checkUserLogin(name, pwd)) {
                System.out.println(loginService.getCustomerIdByPhone(name));

                StpUtil.login(loginService.getCustomerIdByPhone(name));

                return SaResult.ok("登录成功！").setData(StpUtil.getTokenValue());
            }

            return SaResult.error("登录失败！");
        });
    }

}