package cn.edu.tongji.gohome.statistics.Service.impl;

import cn.edu.tongji.gohome.statistics.Service.StayService;
import cn.edu.tongji.gohome.statistics.model.StayEntity;
import cn.edu.tongji.gohome.statistics.model.ViewStayOrderNumberEntity;
import cn.edu.tongji.gohome.statistics.model.ViewStayRoomPriceEntity;
import cn.edu.tongji.gohome.statistics.repository.StayRepository;
import cn.edu.tongji.gohome.statistics.repository.ViewStayOrderNumberRepository;
import cn.edu.tongji.gohome.statistics.repository.ViewStayRoomPriceRespository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.ArrayList;
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
    ViewStayRoomPriceRespository viewStayRoomPriceRespository;

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
        Page<ViewStayRoomPriceEntity> viewStayRoomPriceEntities
                = viewStayRoomPriceRespository.findAll(pageable);
        List<Long> stayIdList = new ArrayList<>();
        viewStayRoomPriceEntities.forEach((i)-> stayIdList.add(i.getStayId()));
        return stayIdList;
    }
}
