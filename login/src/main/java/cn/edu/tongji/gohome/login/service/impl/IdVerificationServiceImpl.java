package cn.edu.tongji.gohome.login.service.impl;

import cn.edu.tongji.gohome.login.config.AliyunCloudConfig;
import cn.edu.tongji.gohome.login.payload.IdVerificationResult;
import cn.edu.tongji.gohome.login.service.IdVerificationService;

import cn.edu.tongji.gohome.login.service.exception.ThirdPartyRequestException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * IdVerificationService
 *
 * @author 卓正一
 * @since 2021/12/8 10:49 AM
 */
@Service
@EnableConfigurationProperties(AliyunCloudConfig.class)
public class IdVerificationServiceImpl implements IdVerificationService {

    @Resource
    AliyunCloudConfig aliyunCloudConfig;

    @Override
    public IdVerificationResult verifyIdImage(String base64Image) {
        String requestUrl = "https://aiperson.market.alicloudapi.com/ai_market/ai_ocr_universal/shen_fen_zheng/v1";
        //阿里云APPCODE
        String appcode = aliyunCloudConfig.getAppcode();

        CloseableHttpClient httpClient = null;
        try {
            httpClient = HttpClients.createDefault();
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            // 装填参数

            //启用BASE64编码方式进行识别
            //内容数据类型是BASE64编码

            params.add(new BasicNameValuePair("IMAGE", base64Image));
            params.add(new BasicNameValuePair("IMAGE_TYPE", "0"));


            // 创建一个HttpPost实例
            HttpPost httpPost = new HttpPost(requestUrl);
            httpPost.addHeader("Authorization", "APPCODE " + appcode);
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

            // 设置请求参数
            httpPost.setEntity(new UrlEncodedFormEntity(params, "utf-8"));

            // 发送POST请求
            HttpResponse execute = httpClient.execute(httpPost);

            // 获取状态码
            int statusCode = execute.getStatusLine().getStatusCode();
            System.out.println(statusCode);

            // 获取结果
            HttpEntity entity = execute.getEntity();
            String result = EntityUtils.toString(entity, "utf-8");
            System.out.println(result);
            return getResultFromString(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        IdVerificationResult err = new IdVerificationResult();
        err.setVerifyResult(1);
        return err;
    }

    private IdVerificationResult getResultFromString(String requestJsonResult) {
        ObjectMapper objectMapper = new ObjectMapper();
        IdVerificationResult result = new IdVerificationResult();
        try {
            Map<?, ?> resultTree = objectMapper.readValue(requestJsonResult, HashMap.class);
            if (resultTree.containsKey("身份证识别实体信息")) {
                Map<?, ?> information = (Map<?, ?>) resultTree.get("身份证识别实体信息");
                if (information.containsKey("身份证人像面实体信息")) {
                    Map<?, ?> personalInfo = (Map<?, ?>) information.get("身份证人像面实体信息");
                    result.setTrueID((String) personalInfo.get("身份证号"));
                    result.setTrueName((String) personalInfo.get("姓名"));
                }
            }
            if (result.getTrueID().isEmpty()) {
                result.setVerifyResult(1);
            } else {
                result.setVerifyResult(0);
            }
            return result;
        } catch (IOException e) {
            throw new ThirdPartyRequestException();
        }
    }
}
