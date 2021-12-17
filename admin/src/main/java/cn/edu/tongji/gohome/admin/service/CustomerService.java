package cn.edu.tongji.gohome.admin.service;

import cn.edu.tongji.gohome.admin.dto.ReturnReportPost;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface CustomerService {
    Page<ReturnReportPost> getPostReportList(Integer pageNum);

    HashMap<String, Object> getPostReportDetail(Long reporterId,Long customerId);

}
