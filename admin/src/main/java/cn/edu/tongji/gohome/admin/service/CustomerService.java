package cn.edu.tongji.gohome.admin.service;

import cn.edu.tongji.gohome.admin.dto.ReturnDetailReportPost;
import cn.edu.tongji.gohome.admin.dto.ReturnReportPost;
import cn.edu.tongji.gohome.admin.dto.UploadedPostReport;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    Page<ReturnReportPost> getPostReportList(Integer pageNum);

    ReturnDetailReportPost getPostReportDetail(Long reporterId, Long customerId);

    HttpStatus postPostReport(UploadedPostReport ask);
}
