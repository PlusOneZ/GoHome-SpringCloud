package cn.edu.tongji.gohome.stayinformation.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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


}
