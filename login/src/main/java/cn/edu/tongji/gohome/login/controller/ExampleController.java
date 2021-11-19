package cn.edu.tongji.gohome.login.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 就是给你们一个例子
 *
 * @author 卓正一
 * @since  2021/11/19 11:24 AM
 */

@RestController
@RequestMapping("api/v1/example")
public class ExampleController {

    @RequestMapping
    public String exampleApi() {
        return "you heard me!";
    }
}
