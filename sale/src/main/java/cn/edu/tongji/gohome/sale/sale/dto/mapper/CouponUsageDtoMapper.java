package cn.edu.tongji.gohome.sale.sale.dto.mapper;

import cn.edu.tongji.gohome.sale.sale.dto.CouponUsageDto;
import cn.edu.tongji.gohome.sale.sale.model.CouponEntity;
import cn.edu.tongji.gohome.sale.sale.model.CouponTypeEntity;

/**
 * 将表映射为礼券使用情况Dto的映射类
 * @author 梁乔
 * @since 2021/11/24 21:40 
 */
public class CouponUsageDtoMapper {
    private static final CouponUsageDtoMapper mapper = new CouponUsageDtoMapper();

    private CouponUsageDtoMapper(){}

    public static CouponUsageDtoMapper getInstance(){return mapper;}

    /**
    * toDto函数
     * @param couponEntity : 礼券实体
     * @param couponTypeEntity : 礼券类型实体
     * @param couponAvailable : 礼券是否可用
     * @return : cn.edu.tongji.gohome.sale.sale.dto.CouponUsageDto
    * @author 梁乔
    * @since 22:12 2021-11-24
    */
    public CouponUsageDto toDto(CouponEntity couponEntity, CouponTypeEntity couponTypeEntity, boolean couponAvailable)
    {
        CouponUsageDto couponUsageDto = new CouponUsageDto();
        if (couponEntity != null && couponTypeEntity != null) {//否则表示该礼券可以使用，礼券使用判断逻辑在service层完成
            couponUsageDto.setCouponAvailable(couponAvailable);
            couponUsageDto.setCouponId(String.valueOf(couponEntity.getCouponId()));
            couponUsageDto.setCouponName(couponTypeEntity.getCouponName());
            couponUsageDto.setCouponValue(couponTypeEntity.getCouponAmount().floatValue());
        }
        return couponUsageDto;
    }

}