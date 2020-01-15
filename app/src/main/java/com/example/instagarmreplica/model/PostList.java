package com.example.instagarmreplica.model;

public class PostList {
    private String postedby_name;
    private String postedby_image;
    private String sub_info;
    private String post_image;
    private String likes;
    private String description;
    private String comment_img;
    private String view_comments;
    private String time;

    public PostList(String postedby_name, String postedby_image, String sub_info, String post_image, String likes, String description, String comment_img, String view_comments, String time) {
        this.postedby_name = postedby_name;
        this.postedby_image = postedby_image;
        this.sub_info = sub_info;
        this.post_image = post_image;
        this.likes = likes;
        this.description = description;
        this.comment_img = comment_img;
        this.view_comments = view_comments;
        this.time = time;
    }

    public PostList(String postedby_name, String postedby_image, String post_image, String description) {
        this.postedby_name = postedby_name;
        this.postedby_image = postedby_image;
        this.post_image = post_image;
        this.description = description;
    }

    public String getPostedby_name() {
        return postedby_name;
    }

    public void setPostedby_name(String postedby_name) {
        this.postedby_name = postedby_name;
    }

    public String getPostedby_image() {
        return postedby_image;
    }

    public void setPostedby_image(String postedby_image) {
        this.postedby_image = postedby_image;
    }

    public String getSub_info() {
        return sub_info;
    }

    public void setSub_info(String sub_info) {
        this.sub_info = sub_info;
    }

    public String getPost_image() {
        return post_image;
    }

    public void setPost_image(String post_image) {
        this.post_image = post_image;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment_img() {
        return comment_img;
    }

    public void setComment_img(String comment_img) {
        this.comment_img = comment_img;
    }

    public String getView_comments() {
        return view_comments;
    }

    public void setView_comments(String view_comments) {
        this.view_comments = view_comments;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
