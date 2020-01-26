package com.example.nytimesahir.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class media {
    public List<picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<picture> pictures) {
        this.pictures = pictures;
    }

    @SerializedName("media-metadata")
    private List<picture> pictures;
}
