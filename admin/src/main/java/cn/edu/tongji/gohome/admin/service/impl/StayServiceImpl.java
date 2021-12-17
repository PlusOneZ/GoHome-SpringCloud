package cn.edu.tongji.gohome.admin.service.impl;

import cn.edu.tongji.gohome.admin.dto.ReturnExamineStayItem;
import cn.edu.tongji.gohome.admin.dto.ReturnReportStay;
import cn.edu.tongji.gohome.admin.model.*;
import cn.edu.tongji.gohome.admin.repository.*;
import cn.edu.tongji.gohome.admin.service.StayService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;


@Service
public class StayServiceImpl implements StayService {

    @Resource
    private StayEntityRepository stayEntityRepository;

    @Resource
    private VerificationEntityRepository verificationEntityRepository;

    @Resource
    private OrderReportEntityRepository orderReportEntityRepository;

    @Resource
    private OrderStayEntityRepository orderStayEntityRepository;

    @Resource
    private OrderEntityRepository orderEntityRepository;


    @Override
    public Page<ReturnExamineStayItem> getStayExamineList(Integer pageNum) {

        Pageable pageable = PageRequest.of(pageNum, 10);

        Page<VerificationEntity> verifies=verificationEntityRepository.findAllBy(pageable);

        Page<ReturnExamineStayItem> res=verifies.map((VerificationEntity verify)->
        {
            ReturnExamineStayItem returnExamineStayItem=new ReturnExamineStayItem();
            StayEntity stay=stayEntityRepository.findOneByStayId(verify.getStayId());
            returnExamineStayItem.setStayId(stay.getStayId());
            returnExamineStayItem.setStayCity(stay.getDetailedAddress());
            returnExamineStayItem.setHostId(stay.getHostId());
            return returnExamineStayItem;
        });

        return res;
    }

    @Override
    public StayEntity getStayExamineDetail(Long stayId) {

        return stayEntityRepository.findOneByStayId(stayId);
    }

    @Override
    public Page<ReturnReportStay> getStayReportList(Integer pageNum) {

        Pageable pageable = PageRequest.of(pageNum, 10);

        Page<OrderReportEntity> reports=orderReportEntityRepository.findAllBy(pageable);

        Page<ReturnReportStay> res=reports.map((OrderReportEntity report)->
        {
            ReturnReportStay returnReportStay=new ReturnReportStay();
            OrderStayEntity orderStayEntity=orderStayEntityRepository.findOneByOrderId(report.getOrderId());
            OrderEntity orderEntity=orderEntityRepository.findOneByOrderId(report.getOrderId());

            returnReportStay.setReportId(report.getReportId());
            returnReportStay.setReporterId(orderEntity.getCustomerId());
            returnReportStay.setStayId(orderStayEntity.getStayId());
            returnReportStay.setReportTime(report.getReportTime());

            return returnReportStay;
        });
        return res;
    }

    @Override
    public HashMap<String,Object> getStayReportDetail(Long reportId) {
        return orderReportEntityRepository.findOneByReportId(reportId);
    }



}
