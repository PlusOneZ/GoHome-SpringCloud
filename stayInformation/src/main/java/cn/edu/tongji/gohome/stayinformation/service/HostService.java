package cn.edu.tongji.gohome.stayinformation.service;

import org.springframework.stereotype.Service;

@Service
public interface HostService {

    Integer findHostIdByCustomerId(long customerId);
}
