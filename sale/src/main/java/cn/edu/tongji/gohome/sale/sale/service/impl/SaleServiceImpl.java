package
        cn.edu.tongji.gohome.sale.sale.service.impl;/**
 * @author 梁乔 2021/11/24
 **/

import cn.edu.tongji.gohome.sale.sale.dto.CouponInfoDto;
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
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        CouponTypeEntity couponTypeEntity = new CouponTypeEntity();
        if(couponEntity != null){
            couponTypeEntity = couponTypeRepository.findByCouponTypeId(couponEntity.getCouponTypeId());
            //判断当前时间礼券是否过期
            long dateNow = new Date().getTime();//当前日期的毫秒数
            long couponStartDate = couponEntity.getCouponStartDate().getTime();
            long couponEndDate = couponEntity.getCouponEndDate().getTime();
            if(dateNow >=couponStartDate && dateNow <= couponEndDate){
                //在有效期内且满足最低消费要求
                couponAvailable = couponTypeEntity.getCouponLimit().floatValue() <= price * dateCount;
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
    * 获取用户的礼券信息
     * @param customerId : 传入的用户id
     * @return : java.util.HashMap<java.lang.String,java.lang.Object>
    * @author 梁乔
    * @since 15:40 2021-11-30
    */
    @Override
    public HashMap<String, Object> getCouponInfoByCustomerId(long customerId) {
        HashMap<String, Object> result = new HashMap<>();
        List<CouponInfoDto> couponInfoDtoList = new ArrayList<>();
        List<CouponEntity> couponEntityList = couponRepository.findAllByCustomerId(customerId);
        for(CouponEntity couponEntity:couponEntityList){
            CouponTypeEntity couponTypeEntity = couponTypeRepository.findByCouponTypeId(couponEntity.getCouponTypeId());
            CouponInfoDto couponInfoDto = new CouponInfoDto();
            couponInfoDto.setCouponName(couponTypeEntity.getCouponName());
            couponInfoDto.setCouponAmount(couponTypeEntity.getCouponLimit().floatValue());
            couponInfoDto.setCouponStartDate(couponEntity.getCouponStartDate());
            couponInfoDto.setCouponEndDate(couponEntity.getCouponEndDate());
            couponInfoDto.setCouponId(couponEntity.getCouponId());
            couponInfoDtoList.add(couponInfoDto);
        }
        result.put("couponList",couponInfoDtoList);
        return result;
    }

    /**
     * 通过礼券id使用一张礼券，即删除一张礼券
     * @param couponId
     */
    @Override
    public void useCouponByCouponId(long couponId) {
        CouponEntity couponEntity = couponRepository.findByCouponId(couponId);
        couponRepository.delete(couponEntity);
    }

    /**
     * 添加一个礼券类型
     * @param couponAmount 礼券金额
     * @param couponLimit 礼券最低使用限额
     * @param couponName 礼券名称
     */
    @Override
    public void addCouponType(BigDecimal couponAmount, BigDecimal couponLimit, String couponName) {
        CouponTypeEntity couponTypeEntity = new CouponTypeEntity();
        couponTypeEntity.setCouponAmount(couponAmount);
        couponTypeEntity.setCouponLimit(couponLimit);
        couponTypeEntity.setCouponName(couponName);
        couponTypeRepository.save(couponTypeEntity);
    }

    /**
    * 删除某一个礼券类型
     * @param couponId : 传入的礼券id
     * @return : void
    * @author 梁乔
    * @since 11:18 2021-12-01
    */
    @Override
    public void deleteCouponType(int couponId) {
        CouponTypeEntity couponTypeEntity = couponTypeRepository.findByCouponTypeId(couponId);
        couponTypeRepository.delete(couponTypeEntity);
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