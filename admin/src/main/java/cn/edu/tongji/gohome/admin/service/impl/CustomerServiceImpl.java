package cn.edu.tongji.gohome.admin.service.impl;

import cn.edu.tongji.gohome.admin.dto.ReturnDetailReportPost;
import cn.edu.tongji.gohome.admin.dto.ReturnReportPost;
import cn.edu.tongji.gohome.admin.dto.UploadedPostReport;
import cn.edu.tongji.gohome.admin.model.*;
import cn.edu.tongji.gohome.admin.repository.CustomerEntityRepository;
import cn.edu.tongji.gohome.admin.repository.PostEntityRepository;
import cn.edu.tongji.gohome.admin.repository.PostReplyEntityRepository;
import cn.edu.tongji.gohome.admin.repository.PostReportEntityRepository;
import cn.edu.tongji.gohome.admin.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    PostReportEntityRepository postReportEntityRepository;

    @Resource
    CustomerEntityRepository customerEntityRepository;

    @Resource
    PostEntityRepository postEntityRepository;

    @Resource
    PostReplyEntityRepository postReplyEntityRepository;


    @Override
    public Page<ReturnReportPost> getPostReportList(Integer pageNum) {
        Pageable pageable = PageRequest.of(pageNum, 10);

        Page<PostReportEntity> reports=postReportEntityRepository.findAllBy(pageable);

        Page<ReturnReportPost> res=reports.map((PostReportEntity report)->
        {
            ReturnReportPost returnReportPost=new ReturnReportPost();

            returnReportPost.setCustomerId(report.getBeReportedCustomerId());
            returnReportPost.setReporterId(report.getReportCustomerId());
            returnReportPost.setReportTime(report.getReportTime());

            return returnReportPost;
        });
        return res;
    }

    @Override
    public ReturnDetailReportPost getPostReportDetail(Long reporterId, Long customerId) {
        PostReportEntity report=postReportEntityRepository.findOneBy(reporterId,customerId);

        ReturnDetailReportPost ret=new ReturnDetailReportPost();
        ret.setReportReason(report.getReportReason());
        ret.setReportTime(report.getReportTime());
        ret.setBeReportedCustomerId(report.getBeReportedCustomerId());
        ret.setReportCustomerId(report.getReportCustomerId());

        return ret;
    }

    @Override
    public HttpStatus postPostReport(UploadedPostReport ask) {

        PostReportEntity report=postReportEntityRepository.findOneBy(ask.getReporterId(),ask.getCustomerId());
        CustomerEntity customer=customerEntityRepository.findOneByCustomerId(ask.getCustomerId());
        report.setIsDealt(Integer.valueOf(1).byteValue());

        if(ask.isBan())
        {
            report.setReplyFlag(0);
            customer.setCustomerState(1);
            postEntityRepository.deleteByCustomerId(customer.getCustomerId());
            postReplyEntityRepository.deleteByCustomerId(customer.getCustomerId());
        }
        else{
            report.setReplyFlag(1);
        }
        postReportEntityRepository.saveAndFlush(report);
        return HttpStatus.OK;
    }
}
