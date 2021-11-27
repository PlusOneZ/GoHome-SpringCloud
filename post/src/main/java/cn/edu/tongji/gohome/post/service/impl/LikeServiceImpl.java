package cn.edu.tongji.gohome.post.service.impl;

import cn.edu.tongji.gohome.post.repository.PostLikeRepository;
import cn.edu.tongji.gohome.post.repository.PostReplyLikeRepository;
import cn.edu.tongji.gohome.post.service.LikeService;
import cn.edu.tongji.gohome.post.service.PostService;
import cn.edu.tongji.gohome.post.service.ReplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        return null;
    }

    @Override
    public HashMap<String, Object> searchReplyLikeForReplyIdAndCustomerId(long replyId, long customerId) {
        return null;
    }
}
