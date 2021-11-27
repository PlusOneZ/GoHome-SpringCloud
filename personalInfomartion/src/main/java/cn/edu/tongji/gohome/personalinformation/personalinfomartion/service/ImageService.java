package cn.edu.tongji.gohome.personalinformation.personalinfomartion.service;

import org.springframework.stereotype.Service;

/**
 * ImageService
 *
 * @author 梁乔
 * @date 2021/11/24 16:24
 */
@Service
public interface ImageService {
    String base64UploadFile(String base64Data, String fileName);
}
