package com.example.nytimesahir.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class picture {
    @SerializedName("format")
    @Expose
    private String format;

    @SerializedName("width")
    @Expose

    private String width;

    @SerializedName("url")
    @Expose

    private String url;

    @SerializedName("height")
    @Expose

    private String height;

    public String getFormat ()
    {
        return format;
    }

    public void setFormat (String format)
    {
        this.format = format;
    }

    public String getWidth ()
    {
        return width;
    }

    public void setWidth (String width)
    {
        this.width = width;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getHeight ()
    {
        return height;
    }

    public void setHeight (String height)
    {
        this.height = height;
    }


}
