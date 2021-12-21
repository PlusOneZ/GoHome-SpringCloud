package cn.edu.tongji.gohome.admin.service.impl;

import cn.edu.tongji.gohome.admin.dto.*;
import cn.edu.tongji.gohome.admin.model.*;
import cn.edu.tongji.gohome.admin.repository.*;
import cn.edu.tongji.gohome.admin.service.StayService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.stream.Collectors;


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

    @Resource
    private RoomBedEntityRepository roomBedEntityRepository;

    @Resource
    private RoomEntityRepository roomEntityRepository;

    @Resource
    private RoomPhotoEntityRepository roomPhotoEntityRepository;

    @Resource
    private HostEntityRepository hostEntityRepository;

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
    public ReturnDetailExamine getStayExamineDetail(Long stayId) {
        StayEntity stay=stayEntityRepository.findOneByStayId(stayId);
        ArrayList<RoomEntity> rooms=roomEntityRepository.findAllByStayId(stay.getStayId());
        ArrayList<ReturnDetailRoom> returnRooms=new ArrayList<ReturnDetailRoom>(rooms.stream().map((RoomEntity room)->
        {
            ReturnDetailRoom ret=new ReturnDetailRoom();
            ret.setBathroomNum(room.getBathroomAmount());
            ret.setRoomId(room.getRoomId());
            ret.setBedNum(roomBedEntityRepository.countAllByRoomId(room.getRoomId()));
            return ret;
        }).collect(Collectors.toList()));

        ArrayList<String> pics=roomPhotoEntityRepository.findAllByStayId(stay.getStayId());

        ReturnDetailExamine res=new ReturnDetailExamine();

        res.setDetailedAddress(stay.getDetailedAddress());
        res.setHasBarrierFree(stay.getNonBarrierFacility().intValue()==0);
        res.setPublicBath(stay.getPublicBathroom());
        res.setStayCapability(stay.getStayCapacity());
        res.setStayType(stay.getStayTypeName());
        res.setPublicToliet(stay.getPublicToilet());
        res.setRoomList(returnRooms);
        res.setStayPicList(pics);
        return res;
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

            returnReportStay.setReportId(report.getOrderId());
            returnReportStay.setReporterId(orderEntity.getCustomerId());
            returnReportStay.setStayId(orderStayEntity.getStayId());
            returnReportStay.setReportTime(report.getReportTime());

            return returnReportStay;
        });
        return res;
    }

    @Override
    public ReturnDetailStayReport getStayReportDetail(Long orderId) {
        OrderReportEntity report=orderReportEntityRepository.findOneByOrderId(orderId);
        OrderStayEntity stay=orderStayEntityRepository.findOneByOrderId(orderId);
        StayEntity house=stayEntityRepository.findOneByStayId(stay.getStayId());
        HostEntity host=hostEntityRepository.findOneByHostId(house.getHostId());
        ReturnDetailStayReport ret=new ReturnDetailStayReport();

        ret.setReportReason(report.getReportReason());
        ret.setReportTime(report.getReportTime());
        ret.setStayId(stay.getStayId());
        ret.setHostId(host.getHostId());
        ret.setHostCredit(host.getHostScore());

        return ret;
    }

    @Override
    public HttpStatus postStayExamine(UploadedExamine ask) {

        VerificationEntity verify=verificationEntityRepository.findOneByStayId(ask.getStayId());
        StayEntity stay=stayEntityRepository.findOneByStayId(verify.getStayId());
        verify.setVerificationResult(true);
        verify.setVerificationReply(ask.getMsg());
        if(ask.getIsPass().intValue()==1)
        {

            stay.setStayStatus(BigInteger.TWO);
        }
        else
        {
            stay.setStayStatus(BigInteger.valueOf(3));
        }

        verificationEntityRepository.saveAndFlush(verify);
        stayEntityRepository.saveAndFlush(stay);
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus postStayReport(UploadedStayReport ask) {
        OrderReportEntity report=orderReportEntityRepository.findOneByOrderId(ask.getOrderId());
        OrderStayEntity order=orderStayEntityRepository.findOneByOrderId(ask.getOrderId());
        StayEntity stay=stayEntityRepository.findOneByStayId(order.getStayId());
        report.setIsDealt(1);
        if(ask.isBan())
        {
            stay.setStayStatus(BigInteger.valueOf(3));
            report.setReplyFlag(0);
        }
        else{
            stay.setStayStatus(BigInteger.valueOf(2));
            report.setReplyFlag(1);
        }
        stayEntityRepository.saveAndFlush(stay);
        orderReportEntityRepository.saveAndFlush(report);
        return HttpStatus.OK;
    }


}
