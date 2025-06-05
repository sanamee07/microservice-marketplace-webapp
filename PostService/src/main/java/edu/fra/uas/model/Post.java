package edu.fra.uas.model;

public class Post {
    private long userId, advertisementId, postId;
    private String platform;
    private String link;

    public Post(long userId, long advertisementId, long postId, String platform, String link) {
        this.userId = userId;
        this.advertisementId = advertisementId;
        this.postId = postId;
        this.platform = platform;
        this.link = link;
    }

    public Post() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(long advertisementId) {
        this.advertisementId = advertisementId;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
