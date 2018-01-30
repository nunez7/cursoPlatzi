package mx.nunez.platzigram.model;

/**
 * Created by nunez-pc on 29/01/2018.
 */

public class Picture {
    private String picture;
    private String username;
    private String time;
    private String likeNumber ="0 días";

    public Picture(String picture, String username, String time, String likeNumber) {
        this.picture = picture;
        this.username = username;
        this.time = time;
        this.likeNumber = likeNumber;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(String likeNumber) {
        this.likeNumber = likeNumber;
    }
}
