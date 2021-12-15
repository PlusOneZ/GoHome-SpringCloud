package cn.edu.tongji.gohome.post.service;

import cn.edu.tongji.gohome.post.dto.UploadedPostDetail;
import cn.edu.tongji.gohome.post.model.PostEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface PostService {

    HashMap<String, Object> searchBriefPostInfo(PostEntity postEntity);

    HashMap<String, Object> searchDefaultPostList(Integer currentPage, Integer pageSize);

    HashMap<String, Object> searchPostListForCustomerId(long customerId,Integer currentPage, Integer pageSize);

    HashMap<String, Object> searchPostDetailForPostId(long postId);

    HashMap<String, Object> searchPostListForKeyWord(String key, int currentPage, int pageSize);

    String addPost(UploadedPostDetail uploadedPostDetail);

    HttpStatus removePost(long postId, long customerId);

    String base64UploadFile(String base64Data, String fileName);

    String uploadImage(Long customerId, String base64Data);

    void addPostReport(Long reportCustomerId, Long reportedCustomerId, String reportReason);

    String getLastReportReason(Long reportCustomerId, Long reportedCustomerId);
}
