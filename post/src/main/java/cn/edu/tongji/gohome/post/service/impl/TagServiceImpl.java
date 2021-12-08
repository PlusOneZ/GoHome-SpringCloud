package cn.edu.tongji.gohome.post.service.impl;

import cn.edu.tongji.gohome.post.dto.HotTag;
import cn.edu.tongji.gohome.post.model.PostEntity;
import cn.edu.tongji.gohome.post.model.PostTagEntity;
import cn.edu.tongji.gohome.post.repository.PostRepository;
import cn.edu.tongji.gohome.post.repository.PostTagRepository;
import cn.edu.tongji.gohome.post.service.PostService;
import cn.edu.tongji.gohome.post.service.TagService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

        Page<String> tags = postTagRepository.findAllDistinctTag(pageable);

        Page<HotTag> tagList=tags.map((String tag)->{
            HotTag hotTag=new HotTag();
            hotTag.setTag(tag);
            hotTag.setHotness(postTagRepository.findCountPostIdByTag(tag));

            return hotTag;
        });

        results.put("tagList", tagList);
        return results;
    }

    @Override
    public HashMap<String, Object> searchPostListForTag(String tag, int currentPage, int pageSize) {

        HashMap<String, Object> results = new HashMap<>();

        Pageable pageable = PageRequest.of(currentPage, pageSize);


        Page<Long> postIdList = postTagRepository.findAllDistinctPostIdByPostTag(tag,pageable);
        Page<HashMap<String,Object>> postList=postIdList.map(postId->{return postService.searchBriefPostInfo(postRepository.findOneByPostId(postId));});

        results.put("postInfo", postList);
        return results;
    }


    @Override
    public List<String> searchTagListForPostId(long postId){

        List<String> result=postTagRepository.findAllDistinctTagByPostId(postId);

        return result.subList(0,Math.min(3,result.size()));
    }
}
