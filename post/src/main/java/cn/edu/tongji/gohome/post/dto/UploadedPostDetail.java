package cn.edu.tongji.gohome.post.dto;

import java.util.ArrayList;
import java.util.List;

public class UploadedPostDetail {
    private ArrayList<String> tags;

    private ArrayList<Long> stays;

    private ArrayList<String> images;

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

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public UploadedPost getPost() {
        return post;
    }

    public void setPost(UploadedPost post) {
        this.post = post;
    }
}
