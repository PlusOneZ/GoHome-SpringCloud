package cn.edu.tongji.gohome.statistics.service.impl;

import cn.edu.tongji.gohome.statistics.service.StayService;
import cn.edu.tongji.gohome.statistics.model.*;
import cn.edu.tongji.gohome.statistics.repository.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * StayServiceImpl类
 *
 * @author 汪明杰
 * @date 2021/11/22 21:47
 */
@Service
public class StayServiceImpl implements StayService {

    @Resource
    StayRepository stayRepository;

    @Resource
    ViewStayOrderNumberRepository viewStayOrderNumberRepository;

    @Resource
    ViewStayRoomPriceRepository viewStayRoomPriceRepository;

    @Resource
    ViewStayRoomPriceStatusRepository viewStayRoomPriceStatusRepository;

    @Resource
    ViewStayCustomerGenderAgeRepository viewStayCustomerGenderAgeRepository;

    @Resource
    ViewStayMonthOrderCommentScoreRepository viewStayMonthOrderCommentScoreRepository;

    @Override
    public List<Long> getHighestScoreStay() {
        Pageable pageable = PageRequest.of(0, 8);

        List<StayEntity> stayEntityList =
                stayRepository.findByStayStatusOrderByCommentScoreDesc(
                        BigInteger.valueOf(2), pageable
                );

        List<Long> stayIdList = new ArrayList<>();
        for(StayEntity stayEntity: stayEntityList){
            stayIdList.add(stayEntity.getStayId());
        }

        return stayIdList;
    }

    @Override
    public List<Long> getMostOrdersStay(){
        Pageable pageable = PageRequest.of(0, 8);
        Page<ViewStayOrderNumberEntity> viewStayOrderNumberEntities
                = viewStayOrderNumberRepository.findAll(pageable);
        List<Long> stayIdList = new ArrayList<>();
        viewStayOrderNumberEntities.forEach((i)-> stayIdList.add(i.getStayId()));
        return stayIdList;
    }

    @Override
    public List<Long> getMinPriceStay(){
        Pageable pageable = PageRequest.of(0,8);
        Page<ViewStayRoomPriceStatusEntity> viewStayRoomPriceEntities
                = viewStayRoomPriceStatusRepository.findAll(pageable);
        List<Long> stayIdList = new ArrayList<>();
        viewStayRoomPriceEntities.forEach((i)-> stayIdList.add(i.getStayId()));
        return stayIdList;
    }

    @Override
    public HashMap<String, Integer> getStayCustomerAgeByStayId(long stayId){
        List<ViewStayCustomerGenderAgeEntity> viewStayCustomerGenderAgeEntities=
        viewStayCustomerGenderAgeRepository.findAllByStayId(stayId);

        HashMap<String, Integer> result = new HashMap<>();

        int age18=0;
        int age30=0;
        int age40=0;
        int age50=0;
        int age100=0;
        int unknown=0;

        for(ViewStayCustomerGenderAgeEntity item:
        viewStayCustomerGenderAgeEntities){
            if(item.getAge()==null){
                unknown+=1;
            }
            else if (item.getAge()<=18){
                age18+=1;
            }
            else if (item.getAge()<=30){
                age30+=1;
            }
            else if (item.getAge()<=40){
                age40+=1;
            }
            else if (item.getAge()<=50){
                age50+=1;
            }
            else{
                age100+=1;
            }
        }
        result.put("age18",age18);
        result.put("age30",age30);
        result.put("age40",age40);
        result.put("age50",age50);
        result.put("age100",age100);
        result.put("unknown",unknown);

        return result;

    }

    @Override
    public HashMap<String, Integer> getStayCustomerGenderByStayId(long stayId){
        List<ViewStayCustomerGenderAgeEntity> viewStayCustomerGenderAgeEntities=
                viewStayCustomerGenderAgeRepository.findAllByStayId(stayId);

        HashMap<String, Integer> result = new HashMap<>();

        int male=0;
        int female=0;
        int unknown=0;

        for(ViewStayCustomerGenderAgeEntity item:
                viewStayCustomerGenderAgeEntities){
            if(item.getGender()==null){
                unknown+=1;
            }
            else if (item.getGender().equals("m")){
                male+=1;
            }
            else{
                female+=1;
            }
        }
        result.put("male",male);
        result.put("female",female);
        result.put("unknown",unknown);

        return result;

    }

    @Override
    public List<HashMap<String,Object>> getStayMonthOrderAndCommentScore(long stayId){
        List<HashMap<String, Object>> result = new ArrayList<>();

        List<ViewStayMonthOrderCommentScoreEntity> viewStayMonthOrderCommentScoreEntities=
            viewStayMonthOrderCommentScoreRepository.findAllByStayId(stayId);
        for(ViewStayMonthOrderCommentScoreEntity item: viewStayMonthOrderCommentScoreEntities){

            HashMap<String, Object> hashMap = new HashMap<>();
            String mapKey = item.getOrderYear().toString()+"-"+item.getOrderMonth().toString();

            hashMap.put("date",mapKey);
            hashMap.put("orderNum",item.getOrderNumber());
            hashMap.put("commentNum",item.getCommentNumber());
            hashMap.put("commentScore",item.getAvgScore());

            result.add(hashMap);
        }
        return result;
    }
}
