package cn.edu.tongji.gohome.order.service;

import cn.edu.tongji.gohome.order.dto.OrderInfoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<OrderInfoDto> searchOrderInfoForCustomerId(long customerId);
}
