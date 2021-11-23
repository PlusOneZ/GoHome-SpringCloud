package cn.edu.tongji.gohome.stayinformation.dto;

/**
 * BedDto类
 *
 * @author 汪明杰
 * @date 2021/11/22 21:29
 */
public class BedDto{
    private String bedType;
    private int num;

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}