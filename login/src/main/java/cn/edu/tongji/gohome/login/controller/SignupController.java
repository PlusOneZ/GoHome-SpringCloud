package cn.edu.tongji.gohome.login.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.gohome.login.service.LoginService;
import cn.edu.tongji.gohome.login.service.PhoneService;
import cn.edu.tongji.gohome.login.service.SignupService;
import cn.edu.tongji.gohome.login.service.exception.DataFormatException;
import cn.edu.tongji.gohome.login.service.exception.LoginRequiredException;
import io.swagger.annotations.*;
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
@Api(tags = "Signup")
@RestController
@RequestMapping("api/v1/signup")
public class SignupController {

    @Resource
    private SignupService signupService;

    @Resource
    private LoginService loginService;

    @Resource
    private PhoneService phoneService;

    @ApiOperation("Check Whether the Phone is Available")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK")
            }
    )
    @GetMapping("checkPhone")
    public ResponseEntity<HashMap<String, Boolean>> checkCustomerPhoneAvailable(
            @ApiParam(value = "International Phone Code", defaultValue = "+86") @RequestParam String phoneCode,
            @ApiParam(value = "Phone", defaultValue = "19946254155") @RequestParam String phone) {
        HashMap<String, Boolean> retMap = new HashMap<String, Boolean>();
        retMap.put("phoneUnique", signupService.checkPhoneAvailable(phone));
        return ResponseEntity.ok(retMap);
    }

    @ApiOperation("Change User Password")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK"),
                    @ApiResponse(code = 401, message = "Not Logged In")
            }
    )
    @PutMapping("changePassword")
    public ResponseEntity<HashMap<String, Boolean>> changeCustomerPassword(
            @ApiParam(value = "New Password", defaultValue = "13456") @RequestParam(required = true) String newPassword,
            @ApiParam(value = "International Phone Code", defaultValue = "+86") @RequestParam(required = false) String phoneCode,
            @ApiParam(value = "Phone", defaultValue = "19946254155") @RequestParam String phone
    ) {
        if (StpUtil.getLoginId() == null) {
            signupService.changeCustomerPassword(phone, newPassword);
        }
        Long id = Long.valueOf((String) StpUtil.getLoginId());
        signupService.changeCustomerPassword(id, newPassword);

        HashMap<String, Boolean> retMap = new HashMap<String, Boolean>();
        retMap.put("changeState", true);
        return ResponseEntity.ok(retMap);
    }

    @ApiOperation("Customer Signup")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK"),
                    @ApiResponse(code = 403, message = "User Already Exist")
            }
    )
    @PostMapping("customer")
    public ResponseEntity<HashMap<String, Object>> customerSignup(
            @ApiParam(value = "International Phone Code", defaultValue = "+86") @RequestParam(required = false) String phoneCode,
            @ApiParam(value = "Phone", defaultValue = "19946254155") @RequestParam String phone,
            @ApiParam(value = "Password", defaultValue = "13456") @RequestParam String password,
            @ApiParam(value = "User Nick Name", defaultValue = "haha") @RequestParam String username
    ) {
        if (!phoneService.isPhoneValidate(phone)) {
            throw new DataFormatException();
        }
        Long id = signupService.customerSignup(phoneCode, phone, password, username);

        HashMap<String, Object> retMap = new HashMap<String, Object>();
        retMap.put("registerState", true);
        retMap.put("customerId", id);
        return ResponseEntity.ok(retMap);
    }

    @ApiOperation("Host Signup")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK"),
                    @ApiResponse(code = 403, message = "User Already Exist")
            }
    )
    @PostMapping("host")
    public ResponseEntity<HashMap<String, Boolean>> hostSignup(
            @ApiParam(value = "International Phone Code", defaultValue = "+86") @RequestParam String phoneCode,
            @ApiParam(value = "Phone", defaultValue = "19946254155") @RequestParam String phone,
            @ApiParam(value = "Password", defaultValue = "13456") @RequestParam String password,
            @ApiParam(value = "User Nick Name", defaultValue = "haha") @RequestParam String username,
            @ApiParam(value = "User Real Name", defaultValue = "吴克") @RequestParam String realname,
            @ApiParam(value = "User Resident ID Card Number", defaultValue = "200001199901011010") @RequestParam String ID,
            @ApiParam(value = "User gender", defaultValue = "m") @RequestParam String gender
    ) {
        if (!phoneService.isPhoneValidate(phone)) {
            throw new DataFormatException();
        }
        signupService.hostSignup(phoneCode, phone, password, username, ID, realname, gender);

        HashMap<String, Boolean> retMap = new HashMap<String, Boolean>();
        retMap.put("registerState", true);
        return ResponseEntity.ok(retMap);
    }

    @ApiOperation("Customer Upgrade to Host")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK"),
                    @ApiResponse(code = 401, message = "Wrong Password")
            }
    )
    @PostMapping("upgradeToHost")
    public ResponseEntity<HashMap<String, Boolean>> upgradeToHost(
            @ApiParam(value = "International Phone Code", defaultValue = "+86") @RequestParam String phoneCode,
            @ApiParam(value = "Phone", defaultValue = "19946254155") @RequestParam String phone,
            @ApiParam(value = "Password", defaultValue = "13456") @RequestParam String password,
            @ApiParam(value = "User Nick Name", defaultValue = "haha") @RequestParam(required = false) String username,
            @ApiParam(value = "User Real Name", defaultValue = "吴克") @RequestParam String realname,
            @ApiParam(value = "User Resident ID Card Number", defaultValue = "200001199901011010") @RequestParam String ID,
            @ApiParam(value = "User gender", defaultValue = "m") @RequestParam String gender
    ) {
        if (!phoneService.isPhoneValidate(phone)) {
            throw new DataFormatException();
        }
        if (!loginService.checkUserLogin(phone, password)) {
            throw new LoginRequiredException();
        }
        // TODO： 并发不安全
        Long customerId = loginService.getCustomerIdByPhone(phone);
        signupService.hostSignup(ID, realname, customerId);
        signupService.setCustomerGender(customerId, gender);

        HashMap<String, Boolean> retMap = new HashMap<String, Boolean>();
        retMap.put("registerState", true);
        return ResponseEntity.ok(retMap);
    }

}
