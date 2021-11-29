package cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto;


/**
 * 此处写CustomerInfoDto类的描述
 * @author 梁乔
 * @since 2021/11/26 10:01 
 */
public class CustomerInfoDto {
    private String userNickName;
    private String userSex;
    private String userBirthDate;
    private Integer mood;


    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(String userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public Integer getMood() {
        return mood;
    }

    public void setMood(Integer mood) {
        this.mood = mood;
    }
}