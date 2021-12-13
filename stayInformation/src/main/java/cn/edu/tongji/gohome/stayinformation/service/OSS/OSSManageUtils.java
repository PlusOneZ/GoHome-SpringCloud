package cn.edu.tongji.gohome.stayinformation.service.OSS;

import com.aliyun.oss.OSSClient;
import java.io.ByteArrayInputStream;
import java.util.Date;

/**
 * @author 12094
 */
public class OSSManageUtils {
    /**
     * 上传OSS服务器文件 @Title: uploadFile
     *  @param bs spring 上传的文件
     * fileName 文件名
     *  @throws Exception 设定文件
     *  @return url 请求路径
     */
    public static String uploadFile(byte[] bs,String fileName) throws Exception {
        //随机名处理
        // 加载配置文件，初始化OSSClient
        OSSConfigure ossConfigure = new OSSConfigure("application-oss.properties");

        OSSClient ossClient = new OSSClient(
                "oss-cn-shanghai.aliyuncs.com",
                "LTAI5t9L46CRZ9pYLUUdSS8b",
                "Mw6UGxmaFWQtK7jTsfAq4MHir3GNRC"
        );
        //创建存贮空间
        //ossClient.createBucket(ossConfigure.getBucketName());
        // 上传文件
        ossClient.putObject("tongjigohome",fileName,new ByteArrayInputStream(bs));
        //设置url过期时间为100年
        Date expiration=new Date(System.currentTimeMillis()+3600L*1000*24*365*100);
        String url = ossClient.generatePresignedUrl("tongjigohome", fileName, expiration).toString();
        // 关闭OSSClient
        ossClient.shutdown();
        return url;
    }



}


