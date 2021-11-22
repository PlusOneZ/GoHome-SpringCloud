package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.controller;/**
 * @author 梁乔 2021/11/20
 **/

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取用户的所有个人信息
 * @author 梁乔
 * @date 2021/11/20 21:06 
 */
@RestController
@RequestMapping("api/customer/basicinfo/get")
public class GetCustomerDetailController {

    @RequestMapping(value = "example",method = RequestMethod.GET)
    public String simpleGetExample(Integer customerId){
        return "aaaaaaa"+"userId:"+customerId;
    }

}