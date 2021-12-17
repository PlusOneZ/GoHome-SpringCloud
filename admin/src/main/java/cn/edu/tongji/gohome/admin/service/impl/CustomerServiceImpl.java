package cn.edu.tongji.gohome.admin.service.impl;

import cn.edu.tongji.gohome.admin.dto.ReturnReportPost;
import cn.edu.tongji.gohome.admin.model.PostReportEntity;
import cn.edu.tongji.gohome.admin.repository.PostReportEntityRepository;
import cn.edu.tongji.gohome.admin.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    PostReportEntityRepository postReportEntityRepository;


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
    public HashMap<String, Object> getPostReportDetail(Long reporterId,Long customerId) {
        return postReportEntityRepository.findOneBy(reporterId,customerId);
    }
}
