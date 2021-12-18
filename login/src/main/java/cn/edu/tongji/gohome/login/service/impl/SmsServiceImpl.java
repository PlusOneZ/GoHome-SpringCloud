package cn.edu.tongji.gohome.login.service.impl;

import java.nio.charset.StandardCharsets;

import cn.edu.tongji.gohome.login.config.SmschineseConfig;
import cn.edu.tongji.gohome.login.service.SmsService;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * SmsServiceImpl
 *
 * @author 卓正一
 * @since 2021/12/14 3:19 PM
 */
@Service
public class SmsServiceImpl implements SmsService {

    @Resource
    SmschineseConfig smschineseConfig;

    public Boolean sendSmsToClient(String phone, String code) {
        try {
            HttpClient client = new HttpClient();
            PostMethod post = new PostMethod("http://utf8.api.smschinese.cn");
            post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");//在头文件中设置转码
            NameValuePair[] data = {
                    new NameValuePair("Uid", smschineseConfig.getUserid()),
                    new NameValuePair("Key", smschineseConfig.getAppkey()),
                    new NameValuePair("smsMob", phone),
                    new NameValuePair("smsText", getText(code))
            };
            post.setRequestBody(data);

            client.executeMethod(post);
            Header[] headers = post.getResponseHeaders();
            int statusCode = post.getStatusCode();
            System.out.println("statusCode:" + statusCode);
            for (Header h : headers) {
                System.out.println(h.toString());
            }
            System.out.println("result: ");
            String result = new String(post.getResponseBodyAsString().getBytes(StandardCharsets.UTF_8));
            System.out.println(result); //打印返回消息状态

            post.releaseConnection();
            return statusCode == 200 && result.equals("1");
        } catch (java.io.IOException e) {
            return false;
        }
    }

    private String getText(String code) {
        return "欢迎使用归宿平台，您的验证码是" + code + "，发送后10分钟内有效。请保管好您的验证码，不要透露给陌生人。";
    }

}