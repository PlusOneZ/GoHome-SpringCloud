package cn.edu.tongji.gohome.personalinformation.personalinfomartion.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto.*;
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
    public ResponseEntity<HashMap<String,Object>> getCustomerInfo()throws Exception{

        try {
            Long customerId = (Long) StpUtil.getLoginId();
            return new ResponseEntity<>(customerInfoService.searchCustomerInfoByCustomerId(customerId), HttpStatus.OK);
        }catch (Exception error){
            error.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }

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

        try {
            Long customerId = (Long)StpUtil.getLoginId();
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
        try {
            Long customerId = (Long)StpUtil.getLoginId();
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

            try {
                Long customerId = (Long)StpUtil.getLoginId();
                return new ResponseEntity<>(customerInfoService.insertNewFavorite(favoriteNameDto.getFavoriteName(), customerId), HttpStatus.OK);
            }catch (Exception error){
                error.printStackTrace();
                return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
            }

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


    /**
    * 在某一收藏夹内新增一个房源
     * @param favoriteStayAdditionDto : 传入的数据格式转换对象
     * @return : org.springframework.http.ResponseEntity<java.lang.Boolean>
    * @author 梁乔
    * @since 15:42 2021-11-29
    */
    @RequestMapping(value = "favorite/stay/addition", method = RequestMethod.POST)
    public ResponseEntity<Boolean> addStayInFavorite(
            @RequestBody FavoriteStayAdditionDto favoriteStayAdditionDto
            ){
        try{
            customerInfoService.addStayToFavorite(favoriteStayAdditionDto.getFavoriteId(),favoriteStayAdditionDto.getStayId());
            return new ResponseEntity<>(true, HttpStatus.OK);
        }catch(Exception error){
            return new ResponseEntity<>(false,HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
    * 删除收藏夹内的特定房源
     * @param favoriteStayAdditionDto : 数据传输对象
     * @return : org.springframework.http.ResponseEntity<java.lang.Boolean>
    * @author 梁乔
    * @since 15:51 2021-11-29
    */
    @RequestMapping(value = "favorite/stay/deletion", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteStayInFavorite(
            @RequestBody FavoriteStayAdditionDto favoriteStayAdditionDto
    ){
        try {
            customerInfoService.addStayToFavorite(favoriteStayAdditionDto.getFavoriteId(),favoriteStayAdditionDto.getStayId());
            return new ResponseEntity<>(true, HttpStatus.OK);
        }catch (Exception error){
            return new ResponseEntity<>(false,HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
    * 获取房东的详细个人信息
     * @return : org.springframework.http.ResponseEntity<java.util.HashMap<java.lang.String,java.lang.Object>>
    * @author 梁乔
    * @since 9:30 2021-11-30
    */

    @RequestMapping(value = "host/info", method = RequestMethod.GET)
    public ResponseEntity<HashMap<String,Object>> getHostBasicInfo(){
        try {
            Long customerId =(Long)StpUtil.getLoginId();
            return new ResponseEntity<>(customerInfoService.getHostInfoByCustomerId(customerId), HttpStatus.OK);
        }catch (Exception error){
            return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
        }
    }


    /**
    * 获取详细的房源信息，用于编辑房源
     * @param stayId : 要查询的房源id
     * @return : org.springframework.http.ResponseEntity<java.util.HashMap<java.lang.String,java.lang.Object>>
    * @author 梁乔
    * @since 11:30 2021-11-30
    */
    @RequestMapping(value = "stay/info", method = RequestMethod.GET)
    public ResponseEntity<HashMap<String,Object>> getStayInfoById(
            @RequestParam(value = "stayId") long stayId
    ){
        return new ResponseEntity<>(customerInfoService.getStayInfoByStayId(stayId),HttpStatus.OK);
    }

    /**
     * 修改房东昵称
     * @param hostNickNameDto
     * @return
     */
    @RequestMapping(value = "host/nickName", method = RequestMethod.PUT)
    public ResponseEntity<Boolean> updateHostNickName(
            @RequestBody HostNickNameDto hostNickNameDto
    ){
        try{
            Long customerId = (Long)StpUtil.getLoginId();
            customerInfoService.updateHostNickName(customerId, hostNickNameDto.getHostNickName());
            return new ResponseEntity<>(true,HttpStatus.OK);
        }catch (Exception error)
        {
            return new ResponseEntity<>(false,HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * 修改用户的头像
     * @param base64Data
     * @return
     */
    @RequestMapping(value = "host/avatar", method = RequestMethod.PUT)
    public ResponseEntity<Boolean> updateHostAvatar(
            @RequestBody Base64Data base64Data
    )
    {
        try {
            Long customerId = (Long)StpUtil.getLoginId();
            customerInfoService.updateAvatar(customerId,base64Data.getBase64Data());
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        catch (Exception error){
            return new ResponseEntity<>(false, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
    * 获取用户组信息
     * @return : org.springframework.http.ResponseEntity<java.util.HashMap<java.lang.String,java.lang.Object>>
    * @author 梁乔
    * @since 21:11 2021-11-30
    */
    @RequestMapping(value = "customer/group",method = RequestMethod.GET)
    public ResponseEntity<HashMap<String,Object>> getCustomerGroupInfo(){
            return new ResponseEntity<>(customerInfoService.getCustomerGroupInfo(),HttpStatus.OK);
    }


    @RequestMapping(value = "host/group", method = RequestMethod.GET)
    public ResponseEntity<HashMap<String,Object>> getHostGroupInfo(){
        return new ResponseEntity<>(customerInfoService.getHostGroupInfo(),HttpStatus.OK);
    }
}