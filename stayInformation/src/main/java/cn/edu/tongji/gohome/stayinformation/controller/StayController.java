package cn.edu.tongji.gohome.stayinformation.controller;

import cn.edu.tongji.gohome.stayinformation.dto.HostStay;
import cn.edu.tongji.gohome.stayinformation.dto.StayCommentInfoDto;
import cn.edu.tongji.gohome.stayinformation.dto.StayInfoDto;
import cn.edu.tongji.gohome.stayinformation.model.LabelEntity;
import cn.edu.tongji.gohome.stayinformation.model.StayEntity;
import cn.edu.tongji.gohome.stayinformation.repository.LabelRepository;
import cn.edu.tongji.gohome.stayinformation.repository.StayRepository;
import cn.edu.tongji.gohome.stayinformation.service.StayCommentService;
import cn.edu.tongji.gohome.stayinformation.service.StayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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

    @Resource
    private LabelRepository labelRepository;

    @Resource
    private StayCommentService stayCommentService;

    @Resource
    private StayService stayService;

    /**
     * <b>Example: http://localhost:8090/api/v1/stay?stayId=10059</b><br>
     * @param stayId
     * @return
     */
    @RequestMapping
    public ResponseEntity<StayInfoDto> getStayById(@RequestParam Long stayId) {
        return new ResponseEntity<>(stayService.searchStayDetailedInfoForStayId(stayId),
                HttpStatus.OK);
    }

    /**
     * <b>http://localhost:8090/api/v1/stay/brief?stayId=10144</b>
     * @param stayId
     * @return
     */
    @RequestMapping("/brief")
    public ResponseEntity<HashMap<String, Object>> getStaBriefInfoById
    (@RequestParam Long stayId){
        HashMap<String, Object> hashMap = new HashMap<>();

        //TODO: change to token
        long customerId = 1;

        hashMap.put("stayPositionNum", 1);
        hashMap.put("stayPositionInfo",
                stayService.getStayBriefInfoByStayId(stayId, customerId)
        );
        return new ResponseEntity<>(hashMap,
                HttpStatus.OK);
    }

    /**
     * <b>http://localhost:8090/api/v1/stay/map?stayId=10144</b>
     * @param stayId
     * @return
     */
    @RequestMapping("/map")
    public ResponseEntity<HashMap<String, Object>> getStayMapInfoById
            (@RequestParam Long stayId){
        HashMap<String, Object> hashMap = new HashMap<>();

        //TODO: change to token
        long customerId = 1;

        hashMap.put("stayPositionNum", 1);
        hashMap.put("stayPositionInfo",
                stayService.getStayMapInfoByStayId(stayId, customerId)
                );
        return new ResponseEntity<>(hashMap,
                HttpStatus.OK);
    }

    @RequestMapping("type")
    public ResponseEntity<HashMap<String,Object>> getStayTypeById
            (@RequestParam Long stayId){
        List<String> stayType = stayService.getAllLabelByStayId(stayId);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("typeList", stayType);
        return new ResponseEntity<>(hashMap,
                HttpStatus.OK);
    }

    @RequestMapping("/positions")
    public ResponseEntity<HashMap<String, Object>> getAllPositionsWithinArea(
            @RequestParam double westLng, @RequestParam double southLat,
            @RequestParam double eastLng, @RequestParam double northLat
    ){
        return new ResponseEntity<>(
                stayService.getStayPositionsWithinArea(westLng, southLat, eastLng, northLat),
                HttpStatus.OK);
    }

    @RequestMapping("/comment")
    public ResponseEntity<StayCommentInfoDto> getStayCommentList(@RequestParam Long stayId) {

        return new ResponseEntity<>(stayCommentService.searchCommentInfoForStayId(stayId),
                HttpStatus.OK);
    }

    @RequestMapping("/tag")
    public ResponseEntity<HashMap<String, Object>> getAllTag() {
        List<LabelEntity> labelEntityList = labelRepository.findAll();

        List<String> res = new ArrayList<>();
        for(int i=0;i<labelEntityList.size();++i){
            res.add(labelEntityList.get(i).getLabelName());
        }

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("tagList", res);

        return new ResponseEntity<>(hashMap,
                HttpStatus.OK);
    }

    @RequestMapping("/host")
    public ResponseEntity<HashMap<String, Object>> getStayBriefInfoByHostId
            (@RequestParam int hostId){
        HashMap<String, Object> hashMap = new HashMap<>();

        // 0 代表保存但未提交， 1 表示待审核， 2 表示审核通过

        hashMap.put("unpublishedStayInfo",
                stayService.getAllStayByHostIdAndStatus(hostId, BigInteger.valueOf(0)));
        hashMap.put("pendingStayInfo",
                stayService.getAllStayByHostIdAndStatus(hostId, BigInteger.valueOf(1)));
        hashMap.put("publishedHouseInfo",
                stayService.getAllStayByHostIdAndStatus(hostId, BigInteger.valueOf(2)));

        return new ResponseEntity<>(hashMap,
                HttpStatus.OK);
    }


    //TODO: 最复杂的一个API
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Boolean> createStay(@RequestBody HostStay hostStay){
        System.out.println(hostStay.getStayTags().get(0));
        return null;
    }


}
