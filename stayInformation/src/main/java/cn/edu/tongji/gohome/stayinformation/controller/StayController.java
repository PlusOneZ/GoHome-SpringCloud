package cn.edu.tongji.gohome.stayinformation.controller;

import cn.edu.tongji.gohome.stayinformation.model.StayEntity;
import cn.edu.tongji.gohome.stayinformation.repository.StayRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 和房源信息查询相关的api
 *
 * @author 汪明杰
 * @date 2021/11/19 18:57
 */

@RestController
@RequestMapping("api/v1/stay")
public class StayController {

    @Resource
    private StayRepository stayRepository;

    @RequestMapping
    public StayEntity getStayById(@RequestParam Long stayId) {
        return stayRepository.getById(stayId);
    }
}
