package cn.edu.tongji.gohome.personalinformation.personalinfomartion.controller;

import cn.edu.tongji.gohome.personalinformation.personalinfomartion.service.CustomerInfoService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * <b>与获取用户信息有关的api</b>
 * @author 梁乔
 * @date 2021/11/20 21:06 
 */
@RestController
@RequestMapping("api/v1/personinfo/")

public class CustomerDetailController {

    @Resource
    private CustomerInfoService customerInfoService;

    @RequestMapping(value = "customer/details",method = RequestMethod.GET)
    public ResponseEntity<HashMap<String,Object>> getCustomerInfo(){

        return new ResponseEntity<>(customerInfoService.searchCustomerInfoByCustomerId(1L), HttpStatus.OK);

    }

}