package cn.edu.tongji.gohome.statistics.controller;

import cn.edu.tongji.gohome.statistics.Service.StayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * StayController类
 *
 * @author 汪明杰
 * @date 2021/11/25 18:37
 */

@RestController
@RequestMapping("/api/v1/statistics/stay")
public class StayController {

    @Resource
    StayService stayService;

    @RequestMapping("/score")
    public ResponseEntity<HashMap<String, Object>> getHighestScoreStay(){
        List<Long> stayIdList = stayService.getHighestScoreStay();

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("stayList", stayIdList);

        return new ResponseEntity<>(hashMap,
                HttpStatus.OK);
    }
}