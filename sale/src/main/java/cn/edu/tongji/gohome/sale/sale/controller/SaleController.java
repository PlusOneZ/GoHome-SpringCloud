package
        cn.edu.tongji.gohome.sale.sale.controller;/**
 * @author 梁乔 2021/11/24
 **/

import cn.edu.tongji.gohome.sale.sale.service.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

    
    @RequestMapping(value = "customer/coupon",method = RequestMethod.GET)
    public ResponseEntity<HashMap<String,Object>> getCustomerCouponInfo(){
        Long customerId = 1L;
        return new ResponseEntity<>(saleService.getCouponInfoByCustomerId(customerId),HttpStatus.OK);
    }
}