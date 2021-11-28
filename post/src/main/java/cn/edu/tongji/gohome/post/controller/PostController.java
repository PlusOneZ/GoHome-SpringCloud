package cn.edu.tongji.gohome.post.controller;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("api/v1/")
public class PostController {

    @Resource
    private PostService postService;

    @Resource
    private LikeService likeService;

    @Resource
    private ReplyService replyService;

    @Resource
    private TagService tagService;

    @RequestMapping("posts/getDefaultPostList")
    public ResponseEntity<HashMap<String, Object>> getDefaultPostList(
            @RequestParam(value = "currentPage", defaultValue = "0") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {

        return new ResponseEntity<>(postService.searchDefaultPostList(currentPage, pageSize), HttpStatus.OK);
    }

    @RequestMapping("posts/getDefaultTagList")
    public ResponseEntity<HashMap<String, Object>> getDefaultTagList(
            @RequestParam(value = "currentPage", defaultValue = "0") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {

        return new ResponseEntity<>(tagService.searchDefaultTagList(currentPage, pageSize), HttpStatus.OK);
    }

    @RequestMapping("posts/getPersonalPostList")
    public ResponseEntity<HashMap<String, Object>> getPersonalPostList(
            @RequestParam(value = "customerId", defaultValue = "0") long customerId,
            @RequestParam(value = "currentPage", defaultValue = "0") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {

        return new ResponseEntity<>(postService.searchPostListForCustomerId(customerId,currentPage, pageSize), HttpStatus.OK);
    }


    @RequestMapping("posts/getTagPostList")
    public ResponseEntity<HashMap<String, Object>> getTagPostList(
            @RequestParam(value = "tag", defaultValue = "") String tag,
            @RequestParam(value = "currentPage", defaultValue = "0") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {

        return new ResponseEntity<>(tagService.searchPostListForTag(tag,currentPage, pageSize), HttpStatus.OK);
    }

    @RequestMapping("posts/getKeyWordPostList")
    public ResponseEntity<HashMap<String, Object>> getKeyWordPostList(
            @RequestParam(value = "key", defaultValue = "") String key,
            @RequestParam(value = "currentPage", defaultValue = "0") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {

        return new ResponseEntity<>(postService.searchPostListForKeyWord(key,currentPage, pageSize), HttpStatus.OK);
    }


//    @RequestMapping("posts/getTagSelectedPostList")
//    public ResponseEntity<HashMap<String, Object>> getTagSelectedPostList(
//            @RequestParam(value = "tagIdList") List<Long> tagIdList,
//            @RequestParam(value = "currentPage", defaultValue = "0") int currentPage,
//            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
//
//        return new ResponseEntity<>(tagService.searchPostListForTagList(tagIdList,currentPage, pageSize), HttpStatus.OK);
//    }


    @RequestMapping("posts/getDetailedPost")
    public ResponseEntity<HashMap<String,Object>> getDetailedPost(
            @RequestParam(value="postId", defaultValue ="0") long postId) {
        return new ResponseEntity<>(postService.searchPostDetailForPostId(postId),HttpStatus.OK);
    }


    @RequestMapping(value = "posts/postPost", method = RequestMethod.POST)
    public HttpStatus postDetailPost(
            @RequestBody UploadedPostDetail uploadedPostDetail){
        return postService.addPost(uploadedPostDetail);
    }


    @RequestMapping(value="posts/deletePost", method = RequestMethod.DELETE)
    public HttpStatus deletePersonalPost(
            @RequestParam(value = "postId", defaultValue ="0") long postId,
            @RequestParam(value = "customerId", defaultValue = "0") long customerId) {
        return postService.removePost(postId,customerId);
    }


    @RequestMapping("posts/reply/getPostReplyList")
    public ResponseEntity<HashMap<String, Object>> getPostReplyList(
            @RequestParam(value="postId", defaultValue ="0") long postId,
            @RequestParam(value = "currentPage", defaultValue = "0") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "30") int pageSize) {

        return new ResponseEntity<>(replyService.searchPostReplyListForPostId(postId,currentPage, pageSize), HttpStatus.OK);
    }

    @RequestMapping("posts/reply/getSonReplyList")
    public ResponseEntity<HashMap<String, Object>> getSonReplyList(
            @RequestParam(value="replyId", defaultValue ="0") long replyId,
            @RequestParam(value = "currentPage", defaultValue = "0") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "8") int pageSize) {

        return new ResponseEntity<>(replyService.searchSonReplyListForReplyId(replyId,currentPage, pageSize), HttpStatus.OK);
    }

    @RequestMapping("posts/reply/postReply")
    public HttpStatus postReplyForPost(
            @RequestBody UploadedReply uploadedReply) {
        return replyService.addReply(uploadedReply);
    }


    @RequestMapping("posts/like/getPostLikeStatus")
    public ResponseEntity<HashMap<String, Object>> getPostLikeStatus(
            @RequestParam(value="postId", defaultValue ="0") long postId,
            @RequestParam(value = "customerId", defaultValue = "0") long customerId) {

        return new ResponseEntity<>(likeService.searchPostLikeForPostIdAndCustomerId(postId,customerId), HttpStatus.OK);
    }

    @RequestMapping("posts/like/postPostLike")
    public HttpStatus postLikeForPost(
            @RequestBody UploadedPostLike uploadedPostLike) {
        return likeService.addLikeForPost(uploadedPostLike);
    }

    @RequestMapping(value="posts/like/deletePostLike", method = RequestMethod.DELETE)
    public HttpStatus deleteLikeForPost(
            @RequestParam(value = "postId", defaultValue ="0") long postId,
            @RequestParam(value = "customerId", defaultValue = "0") long customerId) {
        return likeService.removeLikeForPost(postId, customerId);
    }


    @RequestMapping("posts/like/getReplyLikeStatus")
    public ResponseEntity<HashMap<String, Object>> getReplyLikeStatus(
            @RequestParam(value="replyId", defaultValue ="0") long replyId,
            @RequestParam(value = "customerId", defaultValue = "0") long customerId) {
        return new ResponseEntity<>(likeService.searchReplyLikeForReplyIdAndCustomerId(replyId,customerId), HttpStatus.OK);
    }

    @RequestMapping("posts/like/postReplyLike")
    public HttpStatus postLikeForReply(
            @RequestBody UploadedReplyLike uploadedReplyLike) {
        return likeService.addLikeForReply(uploadedReplyLike);
    }

    @RequestMapping(value="posts/like/deleteReplyLike", method = RequestMethod.DELETE)
    public HttpStatus deleteLikeForReply(
            @RequestParam(value = "replyId", defaultValue ="0") long replyId,
            @RequestParam(value = "customerId", defaultValue = "0") long customerId) {
        return likeService.removeLikeForReply(replyId, customerId);
    }

}
