package cn.edu.tongji.gohome.login.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.gohome.login.service.LoginService;
import cn.edu.tongji.gohome.login.service.SignupService;
import cn.edu.tongji.gohome.login.service.exception.DataFormatException;
import cn.edu.tongji.gohome.login.service.exception.LoginRequiredException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Resource
    private LoginService loginService;

    @GetMapping("checkPhone")
    public ResponseEntity<HashMap<String, Boolean>> checkCustomerPhoneAvailable(String phoneCode, String phone) {
        HashMap<String, Boolean> retMap = new HashMap<String, Boolean>();
        retMap.put("phoneUnique", signupService.checkPhoneAvailable(phoneCode, phone));
        return ResponseEntity.ok(retMap);
    }

    @PutMapping("changePassword")
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

    @PostMapping("customer")
    public ResponseEntity<HashMap<String, Object>> customerSignup(
            @RequestParam String phoneCode,
            @RequestParam String phone,
            @RequestParam String password,
            @RequestParam String username
    ) {
        if (phone.length() != 11) {
            throw new DataFormatException();
        }
        Long id = signupService.customerSignup(phoneCode, phone, password, username);

        HashMap<String, Object> retMap = new HashMap<String, Object>();
        retMap.put("registerState", true);
        retMap.put("customerId", id);
        return ResponseEntity.ok(retMap);
    }

    @PostMapping("host")
    public ResponseEntity<HashMap<String, Boolean>> hostSignup(
            @RequestParam String phoneCode,
            @RequestParam String phone,
            @RequestParam String password,
            @RequestParam String username,
            @RequestParam String realname,
            @RequestParam String ID,
            @RequestParam String gender
    ) {
        if (phone.length() != 11) {
            throw new DataFormatException();
        }
        signupService.hostSignup(phoneCode,phone, password, username, ID, realname, gender);

        HashMap<String, Boolean> retMap = new HashMap<String, Boolean>();
        retMap.put("registerState", true);
        return ResponseEntity.ok(retMap);
    }

    @PostMapping("upgradeToHost")
    public ResponseEntity<HashMap<String, Boolean>> upgradeToHost(
            @RequestParam String phoneCode,
            @RequestParam String phone,
            @RequestParam String password,
            @RequestParam(required = false) String username,
            @RequestParam String realname,
            @RequestParam String ID,
            @RequestParam String gender
    ) {
        if (phone.length() != 11) {
            throw new DataFormatException();
        }
        if (!loginService.checkUserLogin(phoneCode, phone, password)) {
            throw new LoginRequiredException();
        }
        // TODO： 并发不安全
        Long customerId = loginService.getCustomerIdByPhone(phoneCode, phone);
        signupService.hostSignup(ID, realname, customerId);
        signupService.setCustomerGender(customerId, gender);

        HashMap<String, Boolean> retMap = new HashMap<String, Boolean>();
        retMap.put("registerState", true);
        return ResponseEntity.ok(retMap);
    }

}
