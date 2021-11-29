package cn.edu.tongji.gohome.login.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ExampleController
 *
 * @author 卓正一
 * @since 2021/11/23 3:09 PM
 */

@RestController
@RequestMapping("api/v1/example")
public class ExampleController {

    @RequestMapping("haha")
    public String exampleApi() {
        return "you heard me!";
    }
}
