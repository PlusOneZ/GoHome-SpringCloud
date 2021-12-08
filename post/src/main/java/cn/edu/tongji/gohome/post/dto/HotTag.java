package cn.edu.tongji.gohome.post.dto;

public class HotTag {

    private String tag;
    private int hotness;

    public int getHotness() {
        return hotness;
    }

    public void setHotness(int hotness) {
        this.hotness = hotness;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
