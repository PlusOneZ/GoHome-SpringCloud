package cn.edu.tongji.gohome.stayinformation.service.OSS;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;

/**
 * @author chenglong
 * @Title: OSSConfig
 * @ProjectName ytmonitor
 * @Description: TODO
 * @date 2019/6/415:38
 */
@NoArgsConstructor
@AllArgsConstructor
public class OSSConfigure {
    //地域节点
    private String endpoint;
    //access keyId
    private String accessKeyId;
    //accesskeyId
    private String accessKeySecret;
    //存储空间
    private String bucketName;
    //访问路径
    private String accessUrl;

    /**
     * 通过配置文件.properties文件获取，这几项内容。
     *
     * @param storageConfName
     * @throws IOException
     */
    public OSSConfigure(String storageConfName) throws IOException {
        endpoint = "oss-cn-shanghai.aliyuncs.com";
        accessKeyId = "LTAI5t9L46CRZ9pYLUUdSS8b";
        accessKeySecret = "Mw6UGxmaFWQtK7jTsfAq4MHir3GNRC";
        bucketName = "tongjigohome";
        accessUrl = "http://tongjigohome.oss-cn-shanghai.aliyuncs.com/";
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getAccessUrl() {
        return accessUrl;
    }

    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }
}

