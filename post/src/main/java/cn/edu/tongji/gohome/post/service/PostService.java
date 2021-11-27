package cn.edu.tongji.gohome.post.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface PostService {

    HashMap<String, Object> searchDefaultPostList(Integer currentPage, Integer pageSize);

    HashMap<String, Object> searchPostListForCustomerId(long customerId,Integer currentPage, Integer pageSize);

    HashMap<String, Object> searchPostDetailForPostId(long postId);

    HashMap<String, Object> searchPostListForKeyWord(String key, int currentPage, int pageSize);

}
