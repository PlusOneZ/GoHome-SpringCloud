package cn.edu.tongji.gohome.admin.controller;


import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.gohome.admin.dto.*;
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

    @RequestMapping(value = "examine/stay", method = RequestMethod.POST)
    public HttpStatus postStayExamine(
            @RequestBody UploadedExamine ask
    ){
        try {
            return stayService.postStayExamine(ask);
        }catch (Exception error){
            error.printStackTrace();
            return HttpStatus.EXPECTATION_FAILED;
        }
    }

    @RequestMapping(value = "report/post", method = RequestMethod.POST)
    public HttpStatus postPostReport(
            @RequestBody UploadedPostReport ask
    ){
        System.out.println(ask);
        try {
            return customerService.postPostReport(ask);
        }catch (Exception error){
            error.printStackTrace();
            return HttpStatus.EXPECTATION_FAILED;
        }
    }

    @RequestMapping(value = "report/stay", method = RequestMethod.POST)
    public HttpStatus postStayReport(
            @RequestBody UploadedStayReport ask
    ){
        try {
            return stayService.postStayReport(ask);
        }catch (Exception error){
            error.printStackTrace();
            return HttpStatus.EXPECTATION_FAILED;
        }
    }

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
    public ResponseEntity<ReturnDetailExamine> getStayExamineDetail(
            @RequestParam Long stayId
    ){
        try {
            ReturnDetailExamine res =stayService.getStayExamineDetail(stayId);
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
    public ResponseEntity<ReturnDetailStayReport> getStayReportDetail(
            @RequestParam Long orderId
    ){
        try {
            ReturnDetailStayReport res =stayService.getStayReportDetail(orderId);
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
    public ResponseEntity<ReturnDetailReportPost> getPostReportDetail(
            @RequestParam Long reporterId,
            @RequestParam Long customerId
    ){
        try {
            ReturnDetailReportPost res =customerService.getPostReportDetail(reporterId,customerId);
            return new ResponseEntity<>(res,HttpStatus.OK);
        }catch (Exception error){
            error.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
        }
    }






}
