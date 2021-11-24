package cn.edu.tongji.gohome.login.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.gohome.login.service.SignupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * SignupController
 *
 * @author 卓正一
 * @since 2021/11/23 10:18 PM
 */
@RestController
@RequestMapping("api/v1/signup")
public class SignupController {

    // TODO: test all

    @Resource
    private SignupService signupService;

    @RequestMapping("checkPhone")
    public ResponseEntity<HashMap<String, Boolean>> checkCustomerPhoneAvailable(String phoneCode, String phone) {
        HashMap<String, Boolean> retMap = new HashMap<String, Boolean>();
        retMap.put("phoneUnique", signupService.checkPhoneAvailable(phoneCode, phone));
        return ResponseEntity.ok(retMap);
    }

    @RequestMapping("changePassword")
    public ResponseEntity<HashMap<String, Boolean>> changeCustomerPassword(
        @RequestParam(required = true) String newPassword,
        @RequestParam(required = false) String phoneCode,
        @RequestParam(required = false) String phone
    ) {
        if (StpUtil.getLoginId() == null) {
            signupService.changeCustomerPassword(phoneCode, phone, newPassword);
        }
        Long id = Long.valueOf((String) StpUtil.getLoginId());
        signupService.changeCustomerPassword(id, newPassword);

        HashMap<String, Boolean> retMap = new HashMap<String, Boolean>();
        retMap.put("changeState", true);
        return ResponseEntity.ok(retMap);
    }

    @RequestMapping("customer")
    public ResponseEntity<HashMap<String, Boolean>> customerSignup(
            @RequestParam String phoneCode,
            @RequestParam String phone,
            @RequestParam String password,
            @RequestParam String username
    ) {
        signupService.customerSignup(phoneCode, phone, password, username);

        HashMap<String, Boolean> retMap = new HashMap<String, Boolean>();
        retMap.put("registerState", true);
        return ResponseEntity.ok(retMap);
    }

    @RequestMapping("host")
    public ResponseEntity<HashMap<String, Boolean>> hostSignup(
            @RequestParam String phoneCode,
            @RequestParam String phone,
            @RequestParam String password,
            @RequestParam String username,
            @RequestParam String realname,
            @RequestParam String ID,
            @RequestParam String gender
    ) {
        signupService.hostSignup(phoneCode,phone, password, username, ID, realname, gender);

        HashMap<String, Boolean> retMap = new HashMap<String, Boolean>();
        retMap.put("registerState", true);
        return ResponseEntity.ok(retMap);
    }

}
