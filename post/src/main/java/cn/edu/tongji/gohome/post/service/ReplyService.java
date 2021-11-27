package cn.edu.tongji.gohome.post.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface ReplyService {
    HashMap<String, Object> searchPostReplyListForPostId(long postId, int currentPage, int pageSize);

    HashMap<String, Object> searchSonReplyListForReplyId(long replyId, int currentPage, int pageSize);
}
