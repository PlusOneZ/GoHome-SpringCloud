package cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto.mapper;

import cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto.FavoriteStayInfoDto;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.*;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.repository.ViewStayRoomPriceRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * 将stay,host,favorite_directory等多张表映射为FavoriteStayInfoDto
 * @author 梁乔
 * @since 2021/11/29 13:08 
 */
public class FavoriteStayInfoDtoMapper {
    private static final FavoriteStayInfoDtoMapper favoriteStayInfoDtoMapper = new FavoriteStayInfoDtoMapper();

    private FavoriteStayInfoDtoMapper(){}

    public static FavoriteStayInfoDtoMapper getInstance(){return favoriteStayInfoDtoMapper;}

    public FavoriteStayInfoDto toDto(StayEntity stayEntity, List<RoomPhotoEntity> roomPhotoEntityList, ViewStayRoomPriceEntity viewStayRoomPriceEntity,CustomerEntity customerEntity){
        FavoriteStayInfoDto favoriteStayInfoDto = new FavoriteStayInfoDto();
        favoriteStayInfoDto.setStayID(stayEntity.getStayId());
        favoriteStayInfoDto.setStayName(stayEntity.getStayName());
        favoriteStayInfoDto.setStayCharacteristic(stayEntity.getCharacteristic());
        favoriteStayInfoDto.setStayHasPath(stayEntity.getPublicBathroom()!=0);
        favoriteStayInfoDto.setStayHasWashRoom(stayEntity.getPublicToilet()!=0);
        favoriteStayInfoDto.setStayHasFacility(stayEntity.getNonBarrierFacility()!=0);
        favoriteStayInfoDto.setStayRate(stayEntity.getCommentScore());
        //set stay min price
        favoriteStayInfoDto.setStayMinPrice(viewStayRoomPriceEntity.getMinPrice());
        List<String> stayPhotoList = new ArrayList<>();
        for(RoomPhotoEntity roomPhotoEntity:roomPhotoEntityList){
            stayPhotoList.add(roomPhotoEntity.getRoomPhotoLink());
        }
        favoriteStayInfoDto.setStayPhotoList(stayPhotoList);
        favoriteStayInfoDto.setCommentNum(stayEntity.getCommentAmount());
        favoriteStayInfoDto.setHostAvatar(customerEntity.getCustomerAvatarLink());
        return favoriteStayInfoDto;
    }
}