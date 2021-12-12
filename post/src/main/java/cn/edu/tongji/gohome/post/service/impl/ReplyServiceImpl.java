package cn.edu.tongji.gohome.post.service.impl;

import cn.edu.tongji.gohome.post.dto.PostCustomer;
import cn.edu.tongji.gohome.post.dto.UploadedReply;
import cn.edu.tongji.gohome.post.dto.mapper.PostCustomerMapper;
import cn.edu.tongji.gohome.post.model.PostReplyEntity;
import cn.edu.tongji.gohome.post.repository.CustomerRepository;
import cn.edu.tongji.gohome.post.repository.PostReplyRepository;
import cn.edu.tongji.gohome.post.service.PostService;
import cn.edu.tongji.gohome.post.service.ReplyService;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import java.util.HashMap;


@Service
public class ReplyServiceImpl implements ReplyService {

    @Resource
    private PostService postService;

    @Resource
    private PostReplyRepository postReplyRepository;

    @Resource
    private CustomerRepository customerRepository;

    private Page<HashMap<String,Object>> recursiveSearchComment(Page<PostReplyEntity> replyEntityList)
    {

        if(replyEntityList.isEmpty())
        {
            return null;
        }

        Page<HashMap<String,Object>> replyList=replyEntityList.map(postReplyEntity -> {
            PostCustomer customer= PostCustomerMapper.getInstance().toDto(customerRepository.findOneByCustomerId(postReplyEntity.getCustomerId()));
            HashMap<String,Object> sonReply=searchSonReplyListForReplyId(postReplyEntity.getReplyId(),0,8);
            HashMap<String,Object> result=new HashMap<>();
            result.put("reply",postReplyEntity);
            result.put("customer",customer);
            result.put("sonReply",sonReply);
            return result;
        });

        return replyList;

    }


    @Override
    public HashMap<String, Object> searchPostReplyListForPostId(long postId, int currentPage, int pageSize) {

        Pageable pageable= PageRequest.of(currentPage, pageSize);

        HashMap<String, Object> results = new HashMap<>();

        Page<PostReplyEntity> replyEntityList = postReplyRepository.findAllByPostId(postId,pageable);

        Object obj=recursiveSearchComment(replyEntityList);

        if(obj==null)
        {
            return null;
        }

        results.put("replyInfo", obj);
        return results;
    }

    @Override
    public HashMap<String, Object> searchSonReplyListForReplyId(long replyId, int currentPage, int pageSize) {

        Pageable pageable= PageRequest.of(currentPage, pageSize);

        HashMap<String, Object> results = new HashMap<>();

        Page<PostReplyEntity> replyEntityList = postReplyRepository.findAllByPreReplyId(replyId,pageable);

        Object obj=recursiveSearchComment(replyEntityList);

        if(obj==null)
        {
            return null;
        }

        results.put("replyInfo", obj);
        return results;
    }

    @Override
    public HttpStatus addReply(UploadedReply uploadedReply) {

        PostReplyEntity postReplyEntity=new PostReplyEntity();

        postReplyEntity.setReplyId(YitIdHelper.nextId());
        postReplyEntity.setPostId(uploadedReply.getPostId());
        postReplyEntity.setCustomerId(uploadedReply.getCustomerId());
        postReplyEntity.setReplyContent(uploadedReply.getReplyContent());
        postReplyEntity.setPreReplyId(uploadedReply.getPreReplyId());

        try{
            postReplyRepository.saveAndFlush(postReplyEntity);
        }catch (Exception exception)
        {
            return HttpStatus.CONFLICT;
        }

        return HttpStatus.OK;
    }
}
