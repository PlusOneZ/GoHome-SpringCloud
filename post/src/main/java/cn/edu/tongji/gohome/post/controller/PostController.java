package cn.edu.tongji.gohome.post.controller;

import cn.edu.tongji.gohome.post.model.CustomerEntity;
import cn.edu.tongji.gohome.post.service.PostService;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Controller that handles order filtering and creation.
 *
 * @className: PostController
 **/

@RestController
@RequestMapping("api/v1/")
public class PostController {

    @Resource
    private PostService postService;

    @RequestMapping("posts/default")
    public ResponseEntity<HashMap<String, Object>> getCustomerOrderList(
            @RequestParam(value = "currentPage", defaultValue = "0") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {

        return new ResponseEntity<>(postService.searchDefaultPostList(currentPage, pageSize), HttpStatus.OK);
    }

    @RequestMapping("posts/person")
    public ResponseEntity<HashMap<String, Object>> getCustomerOrderList(
            @RequestParam(value = "customerId", defaultValue = "0") int customerId,
            @RequestParam(value = "currentPage", defaultValue = "0") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {

        return new ResponseEntity<>(postService.searchPostListForCustomerId(customerId,currentPage, pageSize), HttpStatus.OK);
    }

}
