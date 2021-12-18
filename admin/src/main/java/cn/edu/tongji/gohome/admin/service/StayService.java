package cn.edu.tongji.gohome.admin.service;


import cn.edu.tongji.gohome.admin.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public interface StayService {
    Page<ReturnExamineStayItem> getStayExamineList(Integer pageNum);

    ReturnDetailExamine getStayExamineDetail(Long stayId);

    Page<ReturnReportStay> getStayReportList(Integer pageNum);

    ReturnDetailStayReport getStayReportDetail(Long reportId);

    HttpStatus postStayExamine(UploadedExamine ask);

    HttpStatus postStayReport(UploadedStayReport ask);
}
