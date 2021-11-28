package cn.edu.tongji.gohome.post.service;

import cn.edu.tongji.gohome.post.dto.UploadedPostLike;
import cn.edu.tongji.gohome.post.dto.UploadedReplyLike;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface LikeService {
    HashMap<String, Object> searchPostLikeForPostIdAndCustomerId(long postId, long customerId);

    HashMap<String, Object> searchReplyLikeForReplyIdAndCustomerId(long replyId, long customerId);

    HttpStatus addLikeForPost(UploadedPostLike uploadedPostLike);

    HttpStatus addLikeForReply(UploadedReplyLike uploadedReplyLike);

    HttpStatus removeLikeForReply(long replyId, long customerId);

    HttpStatus removeLikeForPost(long postId, long customerId);
}
