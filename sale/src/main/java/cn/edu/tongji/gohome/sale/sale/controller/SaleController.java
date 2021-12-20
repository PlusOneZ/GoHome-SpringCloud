package
        cn.edu.tongji.gohome.sale.sale.controller;/**
 * @author 梁乔 2021/11/24
 **/

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.gohome.sale.sale.dto.CouponIdDto;
import cn.edu.tongji.gohome.sale.sale.dto.CouponTypeIdDto;
import cn.edu.tongji.gohome.sale.sale.dto.CouponTypeInfoDto;
import cn.edu.tongji.gohome.sale.sale.service.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.HashMap;

/**
 * 此处写SaleController类的描述
 * @author 梁乔
 * @since 2021/11/24 21:23 
 */
@RestController
@RequestMapping(value = "api/v1/sale/")
public class SaleController {

    @Resource
    SaleService saleService;

    /**
    * 获取指定房源房间内的价格和用户可以使用的礼券
     * @param stayId : 房源id
     * @param roomId : 房间Id
     * @param startDate : 入住开始时间
     * @param endDate : 入住结束时间
     * @param couponId : 礼券Id,可选
     * @return : org.springframework.http.ResponseEntity<java.util.HashMap<java.lang.String,java.lang.Object>>
    * @author 梁乔
    * @since 21:53 2021-11-24
    */
    @RequestMapping(value = "RoomPrice",method = RequestMethod.GET)
    public ResponseEntity<HashMap<String,Object>> getRoomPrice(
            @RequestParam(value = "stayId") String stayId,
            @RequestParam(value = "roomId") int roomId,
            @RequestParam(value = "startDate") String startDate,
            @RequestParam(value = "endDate") String endDate,
            @RequestParam(value = "couponId",defaultValue = "0") String couponId
     ) throws ParseException {
        return new ResponseEntity<>(saleService.getRoomPriceInfo(stayId, roomId, startDate, endDate, couponId), HttpStatus.OK);
    }


    /**
    * 获取用户拥有的礼券信息
     * @return : org.springframework.http.ResponseEntity<java.util.HashMap<java.lang.String,java.lang.Object>>
    * @author
    * @since 21:34 2021-11-30
    */
    @RequestMapping(value = "customer/coupon",method = RequestMethod.GET)
    public ResponseEntity<HashMap<String,Object>> getCustomerCouponInfo(){
        Long customerId = Long.parseLong((String) StpUtil.getLoginId());
        return new ResponseEntity<>(saleService.getCouponInfoByCustomerId(customerId),HttpStatus.OK);
    }


    /**
    * 使用一张礼券
     * @param couponIdDto : 输入的礼券id，使用dto传递参数
     * @return : org.springframework.http.ResponseEntity<java.lang.Boolean>
    * @author 梁乔
    * @since 11:01 2021-12-01
    */
    @RequestMapping(value = "coupon/usage",method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> useACoupon(
            @RequestBody CouponIdDto couponIdDto
            ){
        try{
            saleService.useCouponByCouponId(couponIdDto.getCouponId());
            return new ResponseEntity<>(true,HttpStatus.OK);
        }catch (Exception error){
            return new ResponseEntity<>(false,HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
    * 添加一个礼券类型
     * @param couponTypeInfoDto : 传入的参数，使用Dto转换
     * @return : org.springframework.http.ResponseEntity<java.lang.Boolean>
    * @author 梁乔
    * @since 11:06 2021-12-01
    */
    @RequestMapping(value = "coupontype/addition", method = RequestMethod.POST)
    public ResponseEntity<Boolean> addCouponType(
            @RequestBody CouponTypeInfoDto couponTypeInfoDto
    ){
        try {
            BigDecimal couponAmount = BigDecimal.valueOf(couponTypeInfoDto.getCouponAmount());
            BigDecimal couponLimit = BigDecimal.valueOf(couponTypeInfoDto.getCouponLimit());
            saleService.addCouponType(couponAmount,couponLimit,couponTypeInfoDto.getCouponName());
            return new ResponseEntity<>(true, HttpStatus.OK);
        }catch (Exception error){
            return new ResponseEntity<>(false, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
    * 删除某一礼券类型
     * @param couponTypeIdDto : 传入的礼券类型id
     * @return : org.springframework.http.ResponseEntity<java.lang.Boolean>
    * @author 梁乔
    * @since 11:21 2021-12-01
    */
    @RequestMapping(value = "couponType/deletion", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteCouponType(
            @RequestBody CouponTypeIdDto couponTypeIdDto
    ){
        try {
            saleService.deleteCouponType(couponTypeIdDto.getCouponTypeId());
            return new ResponseEntity<>(true, HttpStatus.OK);
        }catch (Exception error){
            return new ResponseEntity<>(false, HttpStatus.EXPECTATION_FAILED);
        }
    }

}