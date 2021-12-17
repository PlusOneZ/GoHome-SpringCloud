package cn.edu.tongji.gohome.admin.controller;


import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.gohome.admin.dto.ReturnExamineStayItem;
import cn.edu.tongji.gohome.admin.dto.ReturnLogin;
import cn.edu.tongji.gohome.admin.dto.ReturnReportPost;
import cn.edu.tongji.gohome.admin.dto.ReturnReportStay;
import cn.edu.tongji.gohome.admin.model.OrderReportEntity;
import cn.edu.tongji.gohome.admin.model.StayEntity;
import cn.edu.tongji.gohome.admin.service.CustomerService;
import cn.edu.tongji.gohome.admin.service.LoginService;
import cn.edu.tongji.gohome.admin.service.StayService;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;


@Api(tags="Admin")
@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
    @Resource
    private CustomerService customerService;

    @Resource
    private LoginService loginService;

    @Resource
    private StayService stayService;

//    @RequestMapping(value = "post/report", method = RequestMethod.POST)
//    public ResponseEntity<Boolean> reportPostByReportedCustomerIdAndReason(
//            @RequestBody PostReport postReport
//    ){
//        try {
//            Long customerId = Long.valueOf((String) StpUtil.getLoginId());
//            postService.addPostReport(customerId,postReport.getReportedCustomerId(),
//                    postReport.getReportReason());
//            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
//        }catch (Exception error){
//            error.printStackTrace();
//            return new ResponseEntity<>(Boolean.FALSE,HttpStatus.EXPECTATION_FAILED);
//        }
//    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ResponseEntity<ReturnLogin> getLogin(
            @RequestParam(value = "adminName", defaultValue = "") String adminName,
            @RequestParam(value = "password", defaultValue = "") String password
    ){
        try {
            ReturnLogin res =loginService.getLogin(adminName,password);
            return new ResponseEntity<>(res,HttpStatus.OK);
        }catch (Exception error){
            error.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "examine/stay/list", method = RequestMethod.GET)
    public ResponseEntity<Page<ReturnExamineStayItem>> getStayExamineList(
            @RequestParam Integer pageNum
    ){
        try {
            Page<ReturnExamineStayItem> res =stayService.getStayExamineList(pageNum);
            return new ResponseEntity<>(res,HttpStatus.OK);
        }catch (Exception error){
            error.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "examine/stay", method = RequestMethod.GET)
    public ResponseEntity<StayEntity> getStayExamineDetail(
            @RequestParam Long stayId
    ){
        try {
            StayEntity res =stayService.getStayExamineDetail(stayId);
            return new ResponseEntity<>(res,HttpStatus.OK);
        }catch (Exception error){
            error.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "report/stay/list", method = RequestMethod.GET)
    public ResponseEntity<Page<ReturnReportStay>> getStayReportList(
            @RequestParam Integer pageNum
    ){
        try {
            Page<ReturnReportStay> res =stayService.getStayReportList(pageNum);
            return new ResponseEntity<>(res,HttpStatus.OK);
        }catch (Exception error){
            error.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "report/stay", method = RequestMethod.GET)
    public ResponseEntity<HashMap<String,Object>> getStayReportDetail(
            @RequestParam Long reportId
    ){
        try {
            HashMap<String,Object> res =stayService.getStayReportDetail(reportId);
            return new ResponseEntity<>(res,HttpStatus.OK);
        }catch (Exception error){
            error.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
        }
    }


    @RequestMapping(value = "report/post/list", method = RequestMethod.GET)
    public ResponseEntity<Page<ReturnReportPost>> getPostReportList(
            @RequestParam Integer pageNum
    ){
        try {
            Page<ReturnReportPost> res =customerService.getPostReportList(pageNum);
            return new ResponseEntity<>(res,HttpStatus.OK);
        }catch (Exception error){
            error.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "report/post", method = RequestMethod.GET)
    public ResponseEntity<HashMap<String,Object>> getPostReportDetail(
            @RequestParam Long reporterId,
            @RequestParam Long customerId
    ){
        try {
            HashMap<String,Object> res =customerService.getPostReportDetail(reporterId,customerId);
            return new ResponseEntity<>(res,HttpStatus.OK);
        }catch (Exception error){
            error.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
        }
    }






}
