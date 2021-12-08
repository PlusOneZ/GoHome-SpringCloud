package cn.edu.tongji.gohome.post.service.impl;

import cn.edu.tongji.gohome.post.dto.UploadedPostLike;
import cn.edu.tongji.gohome.post.dto.UploadedReplyLike;
import cn.edu.tongji.gohome.post.model.PostEntity;
import cn.edu.tongji.gohome.post.model.PostLikeEntity;
import cn.edu.tongji.gohome.post.model.PostReplyLikeEntity;
import cn.edu.tongji.gohome.post.repository.PostLikeRepository;
import cn.edu.tongji.gohome.post.repository.PostReplyLikeRepository;
import cn.edu.tongji.gohome.post.service.LikeService;
import cn.edu.tongji.gohome.post.service.PostService;
import cn.edu.tongji.gohome.post.service.ReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.swing.text.html.parser.Entity;
import java.util.HashMap;

@Service
public class LikeServiceImpl implements LikeService {

    @Resource
    private ReplyService replyService;

    @Resource
    private PostService postService;

    @Resource
    private PostLikeRepository postLikeRepository;

    @Resource
    private PostReplyLikeRepository postReplyLikeRepository;

    @Override
    public HashMap<String, Object> searchPostLikeForPostIdAndCustomerId(long postId, long customerId) {

        HashMap<String,Object> result=new HashMap<>();
        Boolean exist=false;

        PostLikeEntity like=postLikeRepository.findOneByPostIdAndCustomerId(postId,customerId);
        exist=(like!=null);
        result.put("exist",exist);
        return result;
    }

    @Override
    public HashMap<String, Object> searchReplyLikeForReplyIdAndCustomerId(long replyId, long customerId) {
        HashMap<String,Object> result=new HashMap<>();
        Boolean exist=false;

        PostReplyLikeEntity like=postReplyLikeRepository.findOneByReplyIdAndCustomerId(replyId,customerId);
        exist=(like!=null);
        result.put("exist",exist);
        return result;
    }

    @Override
    public HttpStatus addLikeForPost(UploadedPostLike uploadedPostLike) {

        PostLikeEntity postLikeEntity=new PostLikeEntity();

        postLikeEntity.setPostId(uploadedPostLike.getPostId());
        postLikeEntity.setCustomerId(uploadedPostLike.getCustomerId());

        try{
            postLikeRepository.saveAndFlush(postLikeEntity);
        }catch (Exception exception) {
            return HttpStatus.CONFLICT;
        }
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus addLikeForReply(UploadedReplyLike uploadedReplyLike) {

        PostReplyLikeEntity postReplyLikeEntity=new PostReplyLikeEntity();

        postReplyLikeEntity.setReplyId(uploadedReplyLike.getReplyId());
        postReplyLikeEntity.setCustomerId(uploadedReplyLike.getCustomerId());

        try{
            postReplyLikeRepository.saveAndFlush(postReplyLikeEntity);
        }catch (Exception exception) {
            return HttpStatus.CONFLICT;
        }
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus removeLikeForReply(long replyId, long customerId) {

        Boolean isExist=postReplyLikeRepository.existsByReplyIdAndCustomerId(replyId,customerId);

        if(isExist) {
            try {
                postReplyLikeRepository.deleteByReplyIdAndCustomerId(replyId,customerId);
            }catch (Exception exception)
            {
                return HttpStatus.NOT_MODIFIED;
            }

            return HttpStatus.OK;
        }
        else
        {
            return HttpStatus.FORBIDDEN;
        }
    }

    @Override
    public HttpStatus removeLikeForPost(long postId, long customerId) {

        Boolean isExist=postLikeRepository.existsByPostIdAndCustomerId(postId,customerId);

        if(isExist) {
            try {
                postLikeRepository.deleteByPostIdAndCustomerId(postId,customerId);
            }catch (Exception exception)
            {
                System.out.println(exception.toString());
                return HttpStatus.NOT_MODIFIED;
            }

            return HttpStatus.OK;
        }
        else
        {
            return HttpStatus.FORBIDDEN;
        }
    }
}
