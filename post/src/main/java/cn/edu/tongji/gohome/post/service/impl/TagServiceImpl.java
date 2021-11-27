package cn.edu.tongji.gohome.post.service.impl;

import cn.edu.tongji.gohome.post.model.PostEntity;
import cn.edu.tongji.gohome.post.repository.PostRepository;
import cn.edu.tongji.gohome.post.repository.PostTagRepository;
import cn.edu.tongji.gohome.post.service.PostService;
import cn.edu.tongji.gohome.post.service.TagService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Resource
    private PostService postService;

    @Resource
    private PostTagRepository postTagRepository;

    @Resource
    private PostRepository postRepository;

    @Override
    public HashMap<String, Object> searchDefaultTagList(int currentPage, int pageSize) {

        Pageable pageable = PageRequest.of(currentPage, pageSize);

        HashMap<String, Object> results = new HashMap<>();

        Page<String> tagList = postTagRepository.findAllBy(pageable);

        results.put("tagList", tagList);
        return results;
    }

    @Override
    public HashMap<String, Object> searchPostListForTag(String tag, int currentPage, int pageSize) {

        HashMap<String, Object> results = new HashMap<>();

        Pageable pageable = PageRequest.of(currentPage, pageSize);


        Page<PostEntity> postEntityList = postRepository.findAllByPostTag(tag,pageable);
        List<List<String>> tagList=searchTagListForPostList(postEntityList.getContent());

        results.put("postList", postEntityList);
        results.put("tagsInfo",tagList);

        return results;
    }


    @Override
    public List<List<String>> searchTagListForPostList(List<PostEntity> postEntityList) {

        List<List<String>> result=new ArrayList<>();
        for(PostEntity postEntity:postEntityList)
        {
            List<String> tags=postTagRepository.findDistinctByPostId(postEntity.getPostId());

            result.add(tags.subList(0,Math.min(tags.size(),3)));
        }
        return result;
    }
}
