package cn.edu.tongji.gohome.post.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.gohome.post.dto.UploadedPostDetail;
import cn.edu.tongji.gohome.post.dto.UploadedPostLike;
import cn.edu.tongji.gohome.post.dto.UploadedReply;
import cn.edu.tongji.gohome.post.dto.UploadedReplyLike;
import cn.edu.tongji.gohome.post.model.CustomerEntity;
import cn.edu.tongji.gohome.post.service.LikeService;
import cn.edu.tongji.gohome.post.service.PostService;
import cn.edu.tongji.gohome.post.service.ReplyService;
import cn.edu.tongji.gohome.post.service.TagService;
import com.github.yitter.idgen.YitIdHelper;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


@Api(tags="Post")
@RestController
@RequestMapping("api/v1/posts/")
public class PostController {

    @Resource
    private PostService postService;

    @Resource
    private LikeService likeService;

    @Resource
    private ReplyService replyService;

    @Resource
    private TagService tagService;

    @RequestMapping("post/list/default")
    public ResponseEntity<HashMap<String, Object>> getDefaultPostList(
            @RequestParam(value = "currentPage", defaultValue = "0") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {

        return new ResponseEntity<>(postService.searchDefaultPostList(currentPage, pageSize), HttpStatus.OK);
    }

    @RequestMapping("tag/list/default")
    public ResponseEntity<HashMap<String, Object>> getDefaultTagList(
            @RequestParam(value = "currentPage", defaultValue = "0") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {

        return new ResponseEntity<>(tagService.searchDefaultTagList(currentPage, pageSize), HttpStatus.OK);
    }

    @RequestMapping("post/list/personal")
    public ResponseEntity<HashMap<String, Object>> getPersonalPostList(
            @RequestParam(value = "customerId", defaultValue = "0") Long customerId,
            @RequestParam(value = "currentPage", defaultValue = "0") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        // 如果customerId 为 0，则从token中获取
        if (customerId == null || customerId == 0){
            customerId = Long.valueOf((String) StpUtil.getLoginId());
        }
        return new ResponseEntity<>(postService.searchPostListForCustomerId(customerId,currentPage, pageSize), HttpStatus.OK);
    }


    @RequestMapping("post/list/tag")
    public ResponseEntity<HashMap<String, Object>> getTagPostList(
            @RequestParam(value = "tag", defaultValue = "") String tag,
            @RequestParam(value = "currentPage", defaultValue = "0") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {

        return new ResponseEntity<>(tagService.searchPostListForTag(tag,currentPage, pageSize), HttpStatus.OK);
    }

    @RequestMapping("post/list/keyWord")
    public ResponseEntity<HashMap<String, Object>> getKeyWordPostList(
            @RequestParam(value = "key", defaultValue = "") String key,
            @RequestParam(value = "currentPage", defaultValue = "0") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {

        return new ResponseEntity<>(postService.searchPostListForKeyWord(key,currentPage, pageSize), HttpStatus.OK);
    }


    @RequestMapping("post/detail")
    public ResponseEntity<HashMap<String,Object>> getDetailedPost(
            @RequestParam(value="postId", defaultValue ="0") long postId) {
        return new ResponseEntity<>(postService.searchPostDetailForPostId(postId),HttpStatus.OK);
    }


    @RequestMapping(value = "post", method = RequestMethod.POST)
    public HttpStatus postDetailPost(
            @RequestBody UploadedPostDetail uploadedPostDetail){
        uploadedPostDetail.getPost().setCustomerId(Long.valueOf((String) StpUtil.getLoginId()));
        return postService.addPost(uploadedPostDetail);
    }


    @RequestMapping(value="post", method = RequestMethod.DELETE)
    public HttpStatus deletePersonalPost(
            @RequestParam(value = "postId", defaultValue ="0") long postId) {
        long customerId=Long.valueOf((String) StpUtil.getLoginId());
        return postService.removePost(postId,customerId);
    }


    @RequestMapping("reply/list")
    public ResponseEntity<HashMap<String, Object>> getPostReplyList(
            @RequestParam(value="postId", defaultValue ="0") long postId,
            @RequestParam(value = "currentPage", defaultValue = "0") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "30") int pageSize) {

        return new ResponseEntity<>(replyService.searchPostReplyListForPostId(postId,currentPage, pageSize), HttpStatus.OK);
    }

    @RequestMapping("reply/sonReply/list")
    public ResponseEntity<HashMap<String, Object>> getSonReplyList(
            @RequestParam(value="replyId", defaultValue ="0") long replyId,
            @RequestParam(value = "currentPage", defaultValue = "0") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "8") int pageSize) {

        return new ResponseEntity<>(replyService.searchSonReplyListForReplyId(replyId,currentPage, pageSize), HttpStatus.OK);
    }

    @RequestMapping(value="reply",method = RequestMethod.POST)
    public HttpStatus postReplyForPost(
            @RequestBody UploadedReply uploadedReply) {
        uploadedReply.setCustomerId(Long.valueOf((String) StpUtil.getLoginId()));
        return replyService.addReply(uploadedReply);
    }


    @RequestMapping("like/post/status")
    public ResponseEntity<HashMap<String, Object>> getPostLikeStatus(
            @RequestParam(value="postId", defaultValue ="0") long postId) {
        try{
            long customerId=Long.valueOf((String) StpUtil.getLoginId());
            return new ResponseEntity<>(likeService.searchPostLikeForPostIdAndCustomerId(postId,customerId), HttpStatus.OK);
        }
        catch (Exception error){
            // 未登录情况下也能查看点赞情况
            HashMap<String, Object> res = new HashMap<>();
            res.put("exist",false);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }

    }

    @RequestMapping(value="like/post",method = RequestMethod.POST)
    public HttpStatus postLikeForPost(
            @RequestBody UploadedPostLike uploadedPostLike) {
        uploadedPostLike.setCustomerId(Long.valueOf((String) StpUtil.getLoginId()));
        return likeService.addLikeForPost(uploadedPostLike);
    }

    @RequestMapping(value="like/post", method = RequestMethod.DELETE)
    public HttpStatus deleteLikeForPost(
            @RequestParam(value = "postId", defaultValue ="0") long postId) {
        long customerId=Long.valueOf((String) StpUtil.getLoginId());
        return likeService.removeLikeForPost(postId, customerId);
    }


    @RequestMapping("like/reply/status")
    public ResponseEntity<HashMap<String, Object>> getReplyLikeStatus(
            @RequestParam(value="replyId", defaultValue ="0") long replyId) {
        try{
            Long customerId=Long.valueOf((String) StpUtil.getLoginId());
            return new ResponseEntity<>(
                    likeService.searchReplyLikeForReplyIdAndCustomerId(replyId,customerId), HttpStatus.OK);
        }
        catch (Exception error){
            // 未登录情况下也能查看点赞情况
            HashMap<String, Object> res = new HashMap<>();
            res.put("exist",false);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }



    }

    @RequestMapping(value="like/reply",method = RequestMethod.POST)
    public HttpStatus postLikeForReply(
            @RequestBody UploadedReplyLike uploadedReplyLike) {
        uploadedReplyLike.setCustomerId(Long.valueOf((String) StpUtil.getLoginId()));
        return likeService.addLikeForReply(uploadedReplyLike);
    }

    @RequestMapping(value="like/reply", method = RequestMethod.DELETE)
    public HttpStatus deleteLikeForReply(
            @RequestParam(value = "replyId", defaultValue ="0") long replyId) {
        long customerId=Long.valueOf((String) StpUtil.getLoginId());
        return likeService.removeLikeForReply(replyId, customerId);
    }

}
