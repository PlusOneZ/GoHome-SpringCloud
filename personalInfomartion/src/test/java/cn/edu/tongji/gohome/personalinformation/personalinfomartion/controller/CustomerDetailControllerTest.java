package cn.edu.tongji.gohome.personalinformation.personalinfomartion.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;
import java.beans.Transient;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * 测试一个controller类，相当于不启动整个服务单独测api
 * @author 梁乔
 * @since 2021/11/24 14:18 
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc//用于自动配置MockMvc，配置后的MockMVC类可以直接注入
public class CustomerDetailControllerTest {
    @Autowired
    private MockMvc mockMvc;

    /**
    * 初始化方法，对于每个测试方法都要执行一次
     * @return : void
    * @author 梁乔
    * @since 14:21 2021-11-24
    */
    @Before
    public void setUp() throws Exception{
        System.out.println("--------------------start-------------------");
        get();
        System.out.println("=====================end=====================");
    }


    /**
    * 测试主体，测试一个api，可以随意命名，这里由于测的是get就使用get作为方法名
     * 请注意url的写法，第一个符号是 /
     * @return : void
    * @author 梁乔
    * @since 14:39 2021-11-24
    */
    @Test
    @Transactional//开启事务功能
    @Rollback()//事务回滚，默认是true
    public void get() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/personinfo/customer/details")//构造请求url
                        .param("customerId", "1")//添加请求传值
                        .accept(MediaType.APPLICATION_JSON)//返回类型
                        .header("Authorization","Bearer ********-****-****-****-************")//代表在报文头添加一些必须的信息，这里添加的是token,(后续修改)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())//断言，默认200
                .andDo(print());//结果处理器，标识要对结果做什么事情，这里打印
    }


}