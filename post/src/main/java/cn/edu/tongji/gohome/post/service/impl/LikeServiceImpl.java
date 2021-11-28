package cn.edu.tongji.gohome.post.service.impl;

import cn.edu.tongji.gohome.post.model.PostLikeEntity;
import cn.edu.tongji.gohome.post.repository.PostLikeRepository;
import cn.edu.tongji.gohome.post.repository.PostReplyLikeRepository;
import cn.edu.tongji.gohome.post.service.LikeService;
import cn.edu.tongji.gohome.post.service.PostService;
import cn.edu.tongji.gohome.post.service.ReplyService;
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

        PostLikeEntity like=postReplyLikeRepository.findOneByReplyIdAndCustomerId(replyId,customerId);
        exist=(like!=null);
        result.put("exist",exist);
        return result;
    }
}
