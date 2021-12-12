package cn.edu.tongji.gohome.post.service.impl;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.service.OSS.OSSManageUtils;
import cn.edu.tongji.gohome.post.dto.PostCustomer;
import cn.edu.tongji.gohome.post.dto.UploadedPost;
import cn.edu.tongji.gohome.post.dto.UploadedPostDetail;
import cn.edu.tongji.gohome.post.dto.mapper.PostCustomerMapper;
import cn.edu.tongji.gohome.post.service.PostService;
import cn.edu.tongji.gohome.post.service.TagService;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

import cn.edu.tongji.gohome.post.model.*;
import cn.edu.tongji.gohome.post.repository.*;
import org.springframework.util.Base64Utils;

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
    private AdministratorEntityRepository administratorEntityRepository;

    @Resource
    private TagService tagService;

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

    @Override
    public HttpStatus addPost(UploadedPostDetail uploadedPostDetail) {

        UploadedPost post=uploadedPostDetail.getPost();

        PostEntity postEntity=new PostEntity();
        postEntity.setPostId(YitIdHelper.nextId());
        postEntity.setCustomerId(post.getCustomerId());
        postEntity.setPostContent(post.getPostContent());
        postEntity.setPostTheme(post.getPostTheme());

        long postId=postEntity.getPostId();

        try {
            postRepository.saveAndFlush(postEntity);

            uploadedPostDetail.getTags().forEach((String tag) -> {
                PostTagEntity postTagEntity = new PostTagEntity();
                postTagEntity.setPostTag(tag);
                postTagEntity.setPostId(postId);

                postTagRepository.save(postTagEntity);
            });

            System.out.println("tags uploaded finished");

            uploadedPostDetail.getStays().forEach((Long stayId) -> {
                PostStayEntity postStayEntity = new PostStayEntity();
                postStayEntity.setPostId(postId);
                postStayEntity.setStayId(stayId);

                postStayRepository.save(postStayEntity);
            });

            System.out.println("stays uploaded finished");

            uploadedPostDetail.getBase64images().forEach((String base64image) -> {

                PostImgEntity postImgEntity = new PostImgEntity();
                postImgEntity.setPostId(postId);
                String url=this.uploadImage(post.getCustomerId(),base64image);
                System.out.println(url);
                postImgEntity.setPostImgLink(url);

                postImgRepository.save(postImgEntity);
            });

            System.out.println("Imgs uploaded finished");

        }catch (Exception ex) {
            System.out.println(ex.toString());
            return HttpStatus.CONFLICT;
        }
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus removePost(long postId, long customerId) {

        PostEntity postEntity=postRepository.findOneByPostId(postId);
        Boolean isAdmin=administratorEntityRepository.existsByAdminId(Long.valueOf(customerId).intValue());
        Boolean isAuthor=customerId==postEntity.getCustomerId();

        if(isAdmin||isAuthor) {
            try {
                postRepository.deleteByPostId(postId);
            }catch (Exception exception)
            {
                return HttpStatus.NOT_MODIFIED;
            }

            return HttpStatus.OK;
        }
        else
        {
            return HttpStatus.FORBIDDEN;
        }

    }

    @Override
    public String base64UploadFile(String base64Data, String fileName){
        try {
            //base64,前缀
            String dataPrix = "";
            //base64,后缀
            String data = "";
            if(base64Data == null || "".equals(base64Data)){
                throw new Exception("上传失败，上传图片数据为空");
            }else{
                String [] d = base64Data.split("base64,");
                if(d != null && d.length == 2){
                    dataPrix = d[0];
                    data = d[1];
                }else{
                    throw new Exception("上传失败，数据不合法");
                }
            }
            //文件扩展名
            String suffix = "";
            if("data:image/jpeg;".equalsIgnoreCase(dataPrix)){//data:image/jpeg;base64,base64编码的jpeg图片数据
                suffix = ".jpg";
            } else if("data:image/x-icon;".equalsIgnoreCase(dataPrix)){//data:image/x-icon;base64,base64编码的icon图片数据
                suffix = ".ico";
            } else if("data:image/gif;".equalsIgnoreCase(dataPrix)){//data:image/gif;base64,base64编码的gif图片数据
                suffix = ".gif";
            } else if("data:image/png;".equalsIgnoreCase(dataPrix)){//data:image/png;base64,base64编码的png图片数据
                suffix = ".png";
            }else{
                throw new Exception("上传图片格式不合法");
            }
            //生成的文件名称
            String tempFileName = fileName;
            //因为BASE64Decoder的jar问题，此处使用spring框架提供的工具包
            byte[] bs = Base64Utils.decodeFromString(data);
            try{
                //使用oss文件上传
                return OSSManageUtils.uploadFile(bs,tempFileName);
            }catch(Exception ee){
                throw new RuntimeException("OSS文件上传失败，"+ee.getMessage());
            }
        } catch (Exception ex) {
            return "OSS文件上传失败，"+ex.getMessage();
        }
    }

    @Override
    public String uploadImage(Long customerId, String base64File) {
        return base64UploadFile(base64File,
                "postImg/"+customerId.toString()+"/"+ Long.valueOf(YitIdHelper.nextId()).toString() +".png");
    }


}
