package cn.edu.tongji.gohome.login.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.gohome.login.service.LoginService;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * LoginController
 *
 * @author 卓正一
 * @since 2021/11/22 8:47 PM
 */
@Api(tags = "Login")
@RestController
@RequestMapping("api/v1/login/")
public class LoginController {

    @Resource
    LoginService loginService;

    @ApiOperation("Customer login")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "success!"),
                    @ApiResponse(code = 401, message = "Wrong password or user not exist")
            }
    )
    @GetMapping("customer")
    public ResponseEntity<String> userCustomerLogin(
            @ApiParam(value = "International Phone Code", defaultValue = "+86", example = "+86") @RequestParam String phoneCode,
            @ApiParam(value = "Phone Number", example = "19946254155") @RequestParam String phone,
            @ApiParam(value = "Password", example = "123456") @RequestParam String password) {
        if (loginService.checkUserLogin(phone, password)) {
            Long id = loginService.getCustomerIdByPhone(phone);
            StpUtil.login(id);
            return ResponseEntity.ok("success! role: " + StpUtil.getPermissionList());
        } else {
            return ResponseEntity.status(401).body("Wrong password or user not exist");
        }
    }

    @ApiOperation("Host login")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "success!"),
                    @ApiResponse(code = 401, message = "Wrong password or user not exist")
            }
    )
    @GetMapping("host")
    public ResponseEntity<String> userHostLogin(
            @ApiParam(value = "International Phone Code", example = "+86") @RequestParam String phoneCode,
            @ApiParam(value = "Phone Number", example = "19946254155") @RequestParam String phone,
            @ApiParam(value = "Password", example = "123456") @RequestParam String password) {
        // Duplicate code for stputil to recognize session
        if (loginService.checkUserLogin(phone, password)) {
            StpUtil.login(loginService.getCustomerIdByPhone(phone));

            return ResponseEntity.ok("success! role: " + StpUtil.getPermissionList());
        } else {
            return ResponseEntity.status(401).body("Wrong password or user not exist");
        }
    }

    @ApiOperation("Administrator login")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "success!"),
                    @ApiResponse(code = 401, message = "Wrong password or user not exist")
            }
    )
    @GetMapping("administrator")
    public ResponseEntity<String> userAdminLogin(
            @ApiParam(value = "Administrator's name", example = "19946254155") @RequestParam String adminName,
            @ApiParam(value = "Password", example = "19946254155") @RequestParam String password) {
        if (loginService.checkAdminLogin(adminName, password)) {
            //TODO: Test this
            StpUtil.login((long) loginService.getAdminIdByName(adminName));

            return ResponseEntity.ok("success! role: " + StpUtil.getPermissionList());
        } else {
            return ResponseEntity.status(401).body("Wrong password or admin not exist");
        }
    }

    //TODO: Write API to get all permissions

    @ApiOperation("All permissions for user")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK"),
                    @ApiResponse(code = 401, message = "Not Logged in.")
            }
    )
    @GetMapping("permission")
    public ResponseEntity<List<String>> getUserPermissions() {
        return ResponseEntity.ok(StpUtil.getPermissionList());
    }

    @ApiOperation("Role for user")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK"),
                    @ApiResponse(code = 401, message = "Not Logged in.")
            }
    )
    @GetMapping("userRole")
    public ResponseEntity<List<String>> getUserRoles() {
        return ResponseEntity.ok(StpUtil.getRoleList());
    }

}
