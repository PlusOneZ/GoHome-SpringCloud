package cn.edu.tongji.gohome.gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * LoginController
 *
 * @author 卓正一
 * @since 2021/11/22 8:47 PM
 */
@RestController
@RequestMapping("api/v1/login/")
public class LoginController {

    @GetMapping("")
    public ResponseEntity<String> userLogin() {
        return ResponseEntity.ok("success!");
    }
}
