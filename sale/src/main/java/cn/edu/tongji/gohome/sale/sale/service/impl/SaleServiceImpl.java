package
        cn.edu.tongji.gohome.sale.sale.service.impl;/**
 * @author 梁乔 2021/11/24
 **/

import cn.edu.tongji.gohome.sale.sale.dto.CouponUsageDto;
import cn.edu.tongji.gohome.sale.sale.dto.mapper.CouponUsageDtoMapper;
import cn.edu.tongji.gohome.sale.sale.model.CouponEntity;
import cn.edu.tongji.gohome.sale.sale.model.CouponTypeEntity;
import cn.edu.tongji.gohome.sale.sale.model.RoomEntity;
import cn.edu.tongji.gohome.sale.sale.repository.CouponRepository;
import cn.edu.tongji.gohome.sale.sale.repository.CouponTypeRepository;
import cn.edu.tongji.gohome.sale.sale.repository.RoomRepository;
import cn.edu.tongji.gohome.sale.sale.service.SaleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 礼券微服务Service类的实现
 * @author 梁乔
 * @since 2021/11/24 22:17 
 */
@Service
public class SaleServiceImpl implements SaleService {

    @Resource
    CouponRepository couponRepository;

    @Resource
    RoomRepository roomRepository;

    @Resource
    CouponTypeRepository couponTypeRepository;

    @Override
    public HashMap<String, Object> getRoomPriceInfo(String stayId, int roomId, String startDate, String endDate, String couponId)throws ParseException{

        HashMap<String, Object> result = new HashMap<>();
        boolean couponAvailable = false;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date roomStartDate = sdf.parse(startDate);
        Date roomEndDate = sdf.parse(endDate);
        //获取到对应的房间
        RoomEntity roomEntity = roomRepository.findAllByStayIdAndRoomId(Long.parseLong(stayId), roomId);
        result.put("perPrice", roomEntity.getPrice().floatValue());

        //间隔天数
        int dateCount = daysBetweenTwoDate(roomStartDate, roomEndDate);
        result.put("dateCount", dateCount);

        //总价
        float price = roomEntity.getPrice().floatValue();
        result.put("priceWithoutCoupon",price*dateCount);

        //服务费
        result.put("serviceFee", 0f);

        //判断礼券是否可用
        CouponEntity couponEntity = couponRepository.findByCouponId(Long.parseLong(couponId));
        CouponTypeEntity couponTypeEntity = null;
        if(couponEntity != null){
            couponTypeEntity = couponTypeRepository.findByCouponTypeId(couponEntity.getCouponTypeId());
            //判断当前时间礼券是否过期
            long dateNow = new Date().getTime();//当前日期的毫秒数
            long couponStartDate = couponEntity.getCouponStartDate().getTime();
            long couponEndDate = couponEntity.getCouponEndDate().getTime();
            if(dateNow >=couponStartDate && dateNow <= couponEndDate){
                //在有效期内且满足最低消费要求
                if(couponTypeEntity.getCouponLimit().floatValue() <= price*dateCount){
                    couponAvailable = true;
                }
                couponAvailable = false;
        }
        }
        CouponUsageDto couponUsageDto = CouponUsageDtoMapper.getInstance().toDto(couponEntity, couponTypeEntity, couponAvailable);
        float salePrice = 0f;
        if(couponAvailable){
            salePrice = couponUsageDto.getCouponValue();
        }
        result.put("CouponUsage", couponUsageDto);
        result.put("totalPrice", price*dateCount - salePrice);
        return  result;
    }

    /**
    * 计算两个日期之间相差的天数
     * @param smDate : 较小的时间
     * @param bDate : 较大的时间
     * @return : int
    * @author 梁乔
    * @since 22:50 2021-11-24
    */
    public int daysBetweenTwoDate(Date smDate, Date bDate)throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smDate = sdf.parse(sdf.format(smDate));
        bDate = sdf.parse(sdf.format(bDate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smDate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bDate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }
}