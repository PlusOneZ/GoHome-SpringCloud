package cn.edu.tongji.gohome.post.service.impl;
import cn.edu.tongji.gohome.post.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.edu.tongji.gohome.post.model.*;
import cn.edu.tongji.gohome.post.repository.*;

import javax.annotation.Resource;

@Service
public class PostServiceImpl implements PostService{



    @Resource
    private PostRepository postRepository;

    /**
     * returns all the default display posts
     *
     * @param currentPage current page index,which is an index starts from 0
     * @param pageSize the size of single page
     * @return pageable json
     */
    @Override
    public HashMap<String, Object> searchDefaultPostList(Integer currentPage, Integer pageSize) {

        Pageable pageable = PageRequest.of(currentPage, pageSize);

        HashMap<String, Object> results = new HashMap<>();

        Page<PostEntity> postEntityList = postRepository.findAll(pageable);

        if (postEntityList == null) {
            results.put("totalPage", 0);
            results.put("postList", new ArrayList<>());
            return results;
        }

        results.put("totalPage", postEntityList.getTotalPages());
        results.put("postInfo", postEntityList);
        return results;
    }

    /**
     * returns all the posts of a specific customer
     *
     * @param customerId customer id
     * @param currentPage current page index,which is an index starts from 0
     * @param pageSize the size of single page
     * @return pageable json
     */
    @Override
    public HashMap<String, Object> searchPostListForCustomerId(long customerId, Integer currentPage, Integer pageSize) {
        Pageable pageable= PageRequest.of(currentPage, pageSize);

        HashMap<String, Object> results = new HashMap<>();

        Page<PostEntity> postEntityList = postRepository.findAllByCustomerId(customerId,pageable);

        if (postEntityList == null) {
            results.put("totalPage", 0);
            results.put("postList", new ArrayList<>());
        }
        else
        {
            results.put("totalPage", postEntityList.getTotalPages());
            results.put("postInfo", postEntityList);
        }
        return results;
    }
}
