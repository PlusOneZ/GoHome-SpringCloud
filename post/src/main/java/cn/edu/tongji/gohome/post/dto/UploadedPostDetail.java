package cn.edu.tongji.gohome.post.dto;

import java.util.ArrayList;
import java.util.List;

public class UploadedPostDetail {
    private ArrayList<String> tags;

    private ArrayList<Long> stays;

    private ArrayList<String> base64images;

    private UploadedPost post;


    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public ArrayList<Long> getStays() {
        return stays;
    }

    public void setStays(ArrayList<Long> stays) {
        this.stays = stays;
    }


    public UploadedPost getPost() {
        return post;
    }

    public void setPost(UploadedPost post) {
        this.post = post;
    }

    public ArrayList<String> getBase64images() {
        return base64images;
    }

    public void setBase64images(ArrayList<String> base64images) {
        this.base64images = base64images;
    }
}
