package cn.edu.tongji.gohome.post.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface PostService {

    HashMap<String, Object> searchDefaultPostList(Integer currentPage, Integer pageSize);

    HashMap<String, Object> searchPostListForCustomerId(long customerId,Integer currentPage, Integer pageSize);

//    HashMap<String, Object> searchPostListForPostTheme(String postTheme, Integer currentPage, Integer pageSize);

//    HashMap<String, Object> searchPostDetailForPostId(long postId, Integer currentPage, Integer pageSize);
//
//    HashMap<String, Object> searchPostLikeForPostId(long postId,)
//
//
//
//    HashMap<String, Object> searchPostDetailForPostTheme(String stayId, Integer currentPage, Integer pageSize);
//
//    HashMap<String, Object> searchOrderDetailedInfoForOrderId(long orderId, Integer currentPage, Integer pageSize);
//
//    void addOrderAndDetailedInformation(OrderContent orderContent);

}
