package com.github.carstongowans.cs3230.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class Root{
    @Override
    public String toString() {
        return "Root{" +
                "tracks=" + tracks +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public Tracks tracks;
    public Albums albums;
    public ExternalUrls external_urls;
    public Followers followers;
    public List<String> genres;
    public String href;
    public String id;
    public List<Image> images;
    public String name;
    public int popularity;
    public String type;
    public String uri;
    public Artists artists;
}
