package cn.edu.tongji.gohome.personalinformation.personalinfomartion.controller;

import cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto.Base64Data;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto.CustomerInfoDto;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto.FavoriteIdDto;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto.FavoriteNameDto;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.service.CustomerInfoService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * <b>与获取用户信息有关的api</b>
 * @author 梁乔
 * @date 2021/11/20 21:06 
 */
@RestController
@RequestMapping("api/v1/personinfo/")

public class CustomerController {

    @Resource
    private CustomerInfoService customerInfoService;


    /**
    * 根据SA-Token获取的用户id获取客户信息
     * @return : org.springframework.http.ResponseEntity<java.util.HashMap<java.lang.String,java.lang.Object>>
    * @author 梁乔
    * @since 23:14 2021-11-25
    */
    @RequestMapping(value = "customer/details",method = RequestMethod.GET)
    public ResponseEntity<HashMap<String,Object>> getCustomerInfo(){

        return new ResponseEntity<>(customerInfoService.searchCustomerInfoByCustomerId(1L), HttpStatus.OK);

    }

    /**
    * 更改用户的头像
     * @param base64Data :用户头像的base64字符串
     * @return : org.springframework.http.ResponseEntity<java.lang.Boolean>
    * @author 梁乔
    * @since 23:33 2021-11-25
    */
    @RequestMapping(value = "customer/avatar",method = RequestMethod.PUT)
    public ResponseEntity<Boolean> updateCustomerAvatar(
            @RequestBody Base64Data base64Data){
        //TODO:SA-TOKEN
        Long customerId = 1L;

        try {
            customerInfoService.updateAvatar(customerId, base64Data.getBase64Data());
            return new ResponseEntity<>(true,HttpStatus.OK);
        }catch (Exception error){
            return new ResponseEntity<>(false,HttpStatus.EXPECTATION_FAILED);
        }

    }

    /**
     * 更改用户的基本信息
     * @param customerInfoDto 传入的json，转为用户信息对象dto
     * @return 返回是否更改成功
     */
    @RequestMapping(value = "customer/info", method = RequestMethod.PUT)
    public ResponseEntity<Boolean> updateUserInfo(
            @RequestBody CustomerInfoDto customerInfoDto
            ){
        Long customerId = 1L;
        try {
            customerInfoService.updateUserInfo(customerInfoDto, customerId);
            return new ResponseEntity<>(true,HttpStatus.OK);
        }catch (Exception error){
            return new ResponseEntity<>(false,HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
    * 用户新建一个收藏夹
     * @param favoriteNameDto : 收藏夹名称的DTO
     * @return : org.springframework.http.ResponseEntity<java.util.HashMap<java.lang.String,java.lang.Object>>
    * @author 梁乔
    * @since 10:06 2021-11-29
    */
    @RequestMapping(value = "favorite/addition", method = RequestMethod.POST)
    public ResponseEntity<HashMap<String,Object>> insertNewFavorite(
            @RequestBody FavoriteNameDto favoriteNameDto
            ){
        Long customerId = 1L;

            return new ResponseEntity<>(customerInfoService.insertNewFavorite(favoriteNameDto.getFavoriteName(),customerId),HttpStatus.OK);

    }

    /**
    * 删除指定的收藏夹
     * @param favoriteId : 指定的收藏夹id
     * @return : org.springframework.http.ResponseEntity<java.util.HashMap<java.lang.String,java.lang.Object>>
    * @author 梁乔
    * @since 12:37 2021-11-29
    */
    @RequestMapping(value = "favorite/image",method = RequestMethod.GET)
    public ResponseEntity<HashMap<String,Object>> getFavoriteImage(
            @RequestParam(value = "favoriteId") Integer favoriteId
    ){
        return new ResponseEntity<>(customerInfoService.getFavoriteImage(favoriteId),HttpStatus.OK);
    }

    /**
    * 删除指定的收藏夹
     * @param favoriteIdDto : 要删除的收藏夹idDTO
     * @return : org.springframework.http.ResponseEntity<java.lang.Boolean>
    * @author 梁乔
    * @since 12:47 2021-11-29
    */
    @RequestMapping(value = "favorite/deletion", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteFavorite(
            @RequestBody FavoriteIdDto favoriteIdDto
            ){
        try {
            customerInfoService.deleteFavoriteById(favoriteIdDto.getFavoriteId());
            return new ResponseEntity<>(true,HttpStatus.OK);
        }catch (Exception error){
            return new ResponseEntity<>(false,HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * 获取某一收藏夹的所有房源信息
     * @param favoriteId 收藏夹Id
     * @return hashmap
     */
    @RequestMapping(value = "favorite/stayinfo" ,method = RequestMethod.GET)
    public ResponseEntity<HashMap<String,Object>> getFavoriteStayInfo(
            @RequestParam(value = "favoriteId") Integer favoriteId
    ){
        return new ResponseEntity<>(customerInfoService.getFavoriteStayInfo(favoriteId),HttpStatus.OK);
    }
}