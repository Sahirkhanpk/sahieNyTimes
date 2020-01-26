package com.example.nytimesahir.Model;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class News {

    @SerializedName("title")
    @Expose
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    @SerializedName("byline")
    @Expose

    private String  byline;

    @SerializedName("published_date")
    @Expose

    private String  published_date;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @SerializedName("url")
    @Expose

    private String  url;


  public List<media> getMediaMetadata() {
        return mediaMetadata;
    }

    public void setMediaMetadata(List<media> mediaMetadata) {
        this.mediaMetadata = mediaMetadata;
    }

    @SerializedName("media")
    private List<media> mediaMetadata;







}
