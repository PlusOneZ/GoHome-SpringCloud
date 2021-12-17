package cn.edu.tongji.gohome.admin.service;


import cn.edu.tongji.gohome.admin.dto.ReturnExamineStayItem;
import cn.edu.tongji.gohome.admin.dto.ReturnReportStay;
import cn.edu.tongji.gohome.admin.model.OrderReportEntity;
import cn.edu.tongji.gohome.admin.model.StayEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface StayService {
    Page<ReturnExamineStayItem> getStayExamineList(Integer pageNum);

    StayEntity getStayExamineDetail(Long stayId);

    Page<ReturnReportStay> getStayReportList(Integer pageNum);

    HashMap<String,Object> getStayReportDetail(Long reportId);
}
