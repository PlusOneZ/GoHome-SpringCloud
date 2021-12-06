package cn.edu.tongji.gohome.stayinformation.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.gohome.stayinformation.dto.HostStay;
import cn.edu.tongji.gohome.stayinformation.dto.HostStayUpdate;
import cn.edu.tongji.gohome.stayinformation.dto.StayCommentInfoDto;
import cn.edu.tongji.gohome.stayinformation.dto.StayInfoDto;
import cn.edu.tongji.gohome.stayinformation.model.LabelEntity;
import cn.edu.tongji.gohome.stayinformation.model.StayLabelEntity;
import cn.edu.tongji.gohome.stayinformation.model.StayTypeEntity;
import cn.edu.tongji.gohome.stayinformation.repository.*;
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

    @Resource
    private StayLabelRepository stayLabelRepository;

    @Resource
    private StayTypeRepository stayTypeRepository;

    @Resource
    private HostRepository hostRepository;

    /**
     * <b>Example: http://localhost:8090/api/v1/stay?stayId=10059</b><br>
     * @param stayId
     * @return
     */
    @RequestMapping
    public ResponseEntity<StayInfoDto> getStayById(@RequestParam Long stayId) {
        StayInfoDto stayInfoDto = stayService.
                searchStayDetailedInfoForStayId(stayId,2);
        return new ResponseEntity<>(stayInfoDto,
                HttpStatus.OK);
    }

    /**
     * <b>Example: http://localhost:8090/api/v1/stay/host/equal?stayId=10059</b><br>
     * @param stayId
     * @return
     */
    @RequestMapping("/host/equal")
    public ResponseEntity<HashMap<String,Boolean>> isHostSameWithCustomer(
            @RequestParam Long stayId
    ){
        long customerId = 1;
        // 获取customerId
        int hostId = stayRepository.findFirstByStayId(stayId).getHostId();
        Boolean isEqual = hostRepository.getById(hostId).getCustomerId()
                == customerId;
        HashMap<String, Boolean> hashMap = new HashMap<>();
        hashMap.put("isEqual", isEqual);
        return new ResponseEntity<>(hashMap,
                HttpStatus.OK);
    }

    /**
     * <b>http://localhost:8090/api/v1/stay/brief?stayId=10144</b>
     * @param stayId
     * @return
     */
    @RequestMapping("/brief")
    public ResponseEntity<HashMap<String, Object>> getStayBriefInfoById
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
     * <b>http://localhost:8090/api/v1/stay/host/brief?stayId=10144</b>
     * @param stayId
     * @return
     */
    @RequestMapping("/host/brief")
    public ResponseEntity<HashMap<String,Object>> getHostStayBriefInfoByStayId(
            @RequestParam Long stayId){

        HashMap<String ,Object> hashMap=stayService.getHostStayBriefInfoByStayId(stayId);

        return new ResponseEntity<>(hashMap,HttpStatus.OK);
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

    @RequestMapping("/type")
    public ResponseEntity<HashMap<String,Object>> getAllStayType(){

        List<StayTypeEntity> labelEntities = stayTypeRepository.findAll();
        List<String> stayTypeList = new ArrayList<>();
        for(int i = 0;i <labelEntities.size();++i){
            stayTypeList.add(labelEntities.get(i).getStayTypeName());
        }

        List<String> stayType = new ArrayList<>();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("typeList", stayTypeList);

        return new ResponseEntity<>(hashMap,
                HttpStatus.OK);
    }

    @RequestMapping("/tag")
    public ResponseEntity<HashMap<String,Object>> getStayTagById
            (@RequestParam Long stayId){
        List<StayLabelEntity> stayLabelEntities = stayLabelRepository.findAllByStayId(
                stayId);
        List<String> stayTypeList = new ArrayList<>();
        for(int i = 0;i <stayLabelEntities.size();++i){
            stayTypeList.add(stayLabelEntities.get(i).getLabelName());
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("typeList", stayTypeList);
        return new ResponseEntity<>(hashMap,
                HttpStatus.OK);
    }

    @RequestMapping("/tag/all")
    public ResponseEntity<HashMap<String,Object>> getAllStayTag(){

        List<LabelEntity> labelEntities = labelRepository.findAll();
        List<String> stayTypeList = new ArrayList<>();
        for(int i = 0;i <labelEntities.size();++i){
            stayTypeList.add(labelEntities.get(i).getLabelName());
        }

        List<String> stayType = new ArrayList<>();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("typeList", stayTypeList);

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



    @RequestMapping("/host")
    public ResponseEntity<HashMap<String, Object>> getStayBriefInfoByHostId
            (){
        HashMap<String, Object> hashMap = new HashMap<>();
        int hostId = 1;
        // 0 代表保存但未提交， 1 表示待审核， 2 表示审核通过
        List<Long> unpublishedList =
                stayService.getAllStayIdByHostIdAndStatus(hostId, BigInteger.valueOf(0));
        List<Long> pendingList =
                stayService.getAllStayIdByHostIdAndStatus(hostId, BigInteger.valueOf(1));
        List<Long> publishedList =
                stayService.getAllStayIdByHostIdAndStatus(hostId, BigInteger.valueOf(2));
        hashMap.put("unpublishedStayInfo",
                unpublishedList);
        hashMap.put("pendingStayInfo",
                pendingList);
        hashMap.put("publishedHouseInfo",
                publishedList);
        hashMap.put("publishedNum",publishedList.size());
        hashMap.put("pendingReviewNum",pendingList.size());
        hashMap.put("unpublishedNum",unpublishedList.size());
        return new ResponseEntity<>(hashMap,
                HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Boolean> createStay(@RequestBody HostStay hostStay){
        try{

            // TODO: 改变hostId
            stayService.insertIntoStay(hostStay, 1);
            return new ResponseEntity<>(true,
                    HttpStatus.OK);
        }
        catch(Exception error){
            return new ResponseEntity<>(false,
                    HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Boolean> updateStay(@RequestBody HostStayUpdate
                                                          hostStayUpdate){
        try{

            // TODO: 改变hostId
            stayService.updateAStay(hostStayUpdate.getUpdateInfo(), hostStayUpdate.getStayId(),1);
            return new ResponseEntity<>(true,
                    HttpStatus.OK);
        }
        catch(Exception error){
            return new ResponseEntity<>(false,
                    HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteStayFromStayId(@RequestParam long stayId){
        try{
            // 删除房源
            stayService.deleteFromStayId(stayId);

            return new ResponseEntity<>(true,
                    HttpStatus.OK);
        }
        catch(Exception error){
            return new ResponseEntity<>(false,
                    HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping("/host/id")
    public ResponseEntity<HashMap<String, String>> getHostId(){
        HashMap<String, String> hashMap = new HashMap<>();

        try{
            String customerId = (String)StpUtil.getLoginId();

            hashMap.put("customerId", customerId);
            return new ResponseEntity<>(hashMap,
                    HttpStatus.OK);
        }
        catch (Exception error){
            return new ResponseEntity<>(hashMap,
                    HttpStatus.EXPECTATION_FAILED);
        }




    }

}
