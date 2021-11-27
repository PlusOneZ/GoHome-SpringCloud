package cn.edu.tongji.gohome.post.service.impl;

import cn.edu.tongji.gohome.post.model.PostEntity;
import cn.edu.tongji.gohome.post.model.PostReplyEntity;
import cn.edu.tongji.gohome.post.repository.PostReplyRepository;
import cn.edu.tongji.gohome.post.service.PostService;
import cn.edu.tongji.gohome.post.service.ReplyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


@Service
public class ReplyServiceImpl implements ReplyService {

    @Resource
    private PostService postService;

    @Resource
    private PostReplyRepository postReplyRepository;

    @Override
    public HashMap<String, Object> searchPostReplyListForPostId(long postId, int currentPage, int pageSize) {

        Pageable pageable= PageRequest.of(currentPage, pageSize);

        HashMap<String, Object> results = new HashMap<>();

        Page<PostReplyEntity> replyEntityList = postReplyRepository.findAllByPostId(postId,pageable);

        results.put("postInfo", replyEntityList);

        return results;

    }

    @Override
    public HashMap<String, Object> searchSonReplyListForReplyId(long replyId, int currentPage, int pageSize) {
        return null;
    }
}
