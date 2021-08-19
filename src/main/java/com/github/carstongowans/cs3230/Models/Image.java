package com.github.carstongowans.cs3230.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Image{
    @Override
    public String toString() {
        return "Image{" +
                "height=" + height +
                ", url='" + url + '\'' +
                ", width=" + width +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public int height;
    public String url;
    public int width;
}
