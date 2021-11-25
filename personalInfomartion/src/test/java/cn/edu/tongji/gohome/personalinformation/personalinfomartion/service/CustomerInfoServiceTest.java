package cn.edu.tongji.gohome.personalinformation.personalinfomartion.service;

import cn.edu.tongji.gohome.personalinformation.personalinfomartion.service.CustomerInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 范例：对一个service的单元测试
 * @author 梁乔
 * @since 2021/11/24 14:09 
 */
@SpringBootTest//获取启动类没加载配置
@RunWith(SpringRunner.class)//让Junit运行Spring的测试环境，获得Spring环境的上下文
public class CustomerInfoServiceTest {
    @Resource
    private CustomerInfoService customerInfoService;

    @Test
    public void setCustomerInfoService(){
        Long customerId = 1L;
        customerInfoService.searchCustomerInfoByCustomerId(customerId);
    }
}