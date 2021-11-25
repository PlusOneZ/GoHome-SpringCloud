package cn.edu.tongji.gohome.statistics.Service.impl;

import cn.edu.tongji.gohome.statistics.Service.StayService;
import cn.edu.tongji.gohome.statistics.model.StayEntity;
import cn.edu.tongji.gohome.statistics.repository.StayRepository;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
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

    @Override
    public List<Long> getHighestScoreStay() {
        Pageable pageable = PageRequest.of(0, 5);

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
}
