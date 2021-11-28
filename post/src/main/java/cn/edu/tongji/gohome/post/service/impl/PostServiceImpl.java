package cn.edu.tongji.gohome.post.service.impl;
import cn.edu.tongji.gohome.post.dto.PostCustomer;
import cn.edu.tongji.gohome.post.dto.mapper.PostCustomerMapper;
import cn.edu.tongji.gohome.post.service.LikeService;
import cn.edu.tongji.gohome.post.service.PostService;
import cn.edu.tongji.gohome.post.service.ReplyService;
import cn.edu.tongji.gohome.post.service.TagService;
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

    @Resource
    private CustomerRepository customerRepository;

    @Resource
    private PostTagRepository postTagRepository;

    @Resource
    private PostImgRepository postImgRepository;

    @Resource
    private PostStayRepository postStayRepository;

    @Resource
    private TagService tagService;

    @Resource
    private ReplyService replyService;

    @Resource
    private LikeService likeService;


    @Override
    public HashMap<String, Object> searchBriefPostInfo(PostEntity postEntity) {
        List<String> tags=tagService.searchTagListForPostId(postEntity.getPostId());
        PostCustomer author=PostCustomerMapper.getInstance().toDto(customerRepository.findOneByCustomerId(postEntity.getCustomerId()));
        List<String> imgList=postImgRepository.findDistinctByPostId(postEntity.getPostId());

        HashMap<String,Object> result=new HashMap<>();
        result.put("post",postEntity);
        result.put("tags",tags);
        result.put("author",author);
        result.put("images",imgList);
        return result;
    }

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
        Page<HashMap<String,Object>> postList=postEntityList.map(postEntity->{return searchBriefPostInfo(postEntity);});

        results.put("postInfo", postList);
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
        Page<HashMap<String,Object>> postList=postEntityList.map(postEntity->{return searchBriefPostInfo(postEntity);});

        results.put("postInfo", postList);
        return results;
    }

    @Override
    public HashMap<String, Object> searchPostDetailForPostId(long postId) {

        HashMap<String,Object> results=new HashMap<>();

        PostEntity post=postRepository.findOneByPostId(postId);

        results.put("post",post);

        CustomerEntity customer=customerRepository.findOneByCustomerId(post.getCustomerId());
        PostCustomer postCustomer=PostCustomerMapper.getInstance().toDto(customer);
        results.put("author",postCustomer);

        List<PostTagEntity> tagList=postTagRepository.findAllByPostId(post.getPostId());

        results.put("tagsDetail",tagList);

        List<PostImgEntity> imgList=postImgRepository.findAllByPostId(post.getPostId());
        results.put("imagesDetail",imgList);

        List<PostStayEntity> stayList=postStayRepository.findAllByPostId(post.getPostId());
        results.put("stays",stayList);
        return results;
    }


    //ToDo: implement some search algorithms
    @Override
    public HashMap<String, Object> searchPostListForKeyWord(String key, int currentPage, int pageSize) {
        return tagService.searchPostListForTag(key,currentPage,pageSize);
    }



}
