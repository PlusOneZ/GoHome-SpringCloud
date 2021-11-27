package cn.edu.tongji.gohome.post.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface LikeService {
    HashMap<String, Object> searchPostLikeForPostIdAndCustomerId(long postId, long customerId);

    HashMap<String, Object> searchReplyLikeForReplyIdAndCustomerId(long replyId, long customerId);
}
