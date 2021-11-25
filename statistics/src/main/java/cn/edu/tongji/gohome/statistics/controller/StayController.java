package cn.edu.tongji.gohome.statistics.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * StayController类
 *
 * @author 汪明杰
 * @date 2021/11/25 18:37
 */

@RestController
@RequestMapping("/api/v1/stay")
public class StayController {
    @RequestMapping("/host")
    public ResponseEntity<HashMap<String, Object>> getHighestScoreStay(){
        HashMap<String, Object> hashMap = new HashMap<>();


        return new ResponseEntity<>(hashMap,
                HttpStatus.OK);
    }
}
