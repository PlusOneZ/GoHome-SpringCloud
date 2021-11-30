package cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 此处写FavoriteStayAdditionDto类的描述
 * @author 梁乔
 * @since 2021/11/29 15:26 
 */
public class FavoriteStayAdditionDto {
    private Integer favoriteId;
    private Long stayId;

    public Integer getFavoriteId() {
        return favoriteId;
    }

    public Long getStayId() {
        return stayId;
    }

    public void setStayId(Long stayId) {
        this.stayId = stayId;
    }

    public void setFavoriteId(Integer favoriteId) {
        this.favoriteId = favoriteId;
    }
}