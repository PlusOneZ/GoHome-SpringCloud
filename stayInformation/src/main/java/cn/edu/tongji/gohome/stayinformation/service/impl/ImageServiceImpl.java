package cn.edu.tongji.gohome.stayinformation.service.impl;

import cn.edu.tongji.gohome.stayinformation.service.ImageService;
import cn.edu.tongji.gohome.stayinformation.service.OSS.OSSManageUtils;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

/**
 * ImageServiceImpl类
 *
 * @author 汪明杰
 * @date 2021/11/24 16:25
 */
@Service
public class ImageServiceImpl implements ImageService {


    public String base64UploadFile(String base64Data, String fileName){
        try {
            //base64,前缀
            String dataPrix = "";
            //base64,后缀
            String data = "";
            if(base64Data == null || "".equals(base64Data)){
                throw new Exception("上传失败，上传图片数据为空");
            }else{
                String [] d = base64Data.split("base64,");
                if(d != null && d.length == 2){
                    dataPrix = d[0];
                    data = d[1];
                }else{
                    throw new Exception("上传失败，数据不合法");
                }
            }
            //文件扩展名
            String suffix = "";
            if("data:image/jpeg;".equalsIgnoreCase(dataPrix)){//data:image/jpeg;base64,base64编码的jpeg图片数据
                suffix = ".jpg";
            } else if("data:image/x-icon;".equalsIgnoreCase(dataPrix)){//data:image/x-icon;base64,base64编码的icon图片数据
                suffix = ".ico";
            } else if("data:image/gif;".equalsIgnoreCase(dataPrix)){//data:image/gif;base64,base64编码的gif图片数据
                suffix = ".gif";
            } else if("data:image/png;".equalsIgnoreCase(dataPrix)){//data:image/png;base64,base64编码的png图片数据
                suffix = ".png";
            }else{
                throw new Exception("上传图片格式不合法");
            }
            //生成的文件名称
            String tempFileName = fileName;
            //因为BASE64Decoder的jar问题，此处使用spring框架提供的工具包
            byte[] bs = Base64Utils.decodeFromString(data);
            try{
                //使用oss文件上传
                return OSSManageUtils.uploadFile(bs,tempFileName);
            }catch(Exception ee){
                throw new RuntimeException("OSS文件上传失败，"+ee.getMessage());
            }
        } catch (Exception ex) {
            return "OSS文件上传失败，"+ex.getMessage();
        }
    }
}
