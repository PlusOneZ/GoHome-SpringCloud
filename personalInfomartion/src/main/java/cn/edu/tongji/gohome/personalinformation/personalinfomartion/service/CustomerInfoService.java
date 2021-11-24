package cn.edu.tongji.gohome.personalinformation.personalinfomartion.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * CustomerInfoService类，待实现的接口
 * @author 梁乔
 * @since 2021/11/23 11:34
 */
@Service
public interface CustomerInfoService {
    HashMap<String,Object> searchCustomerInfoByCustomerId(Long customerId);
}