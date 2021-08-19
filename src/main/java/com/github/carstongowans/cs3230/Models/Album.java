package com.github.carstongowans.cs3230.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class Album{
    @Override
    public String toString() {
        return "Album{" +
                "album_type='" + album_type + '\'' +
                ", artists=" + artists +
                ", external_urls=" + external_urls +
                ", href='" + href + '\'' +
                ", id='" + id + '\'' +
                ", images=" + images +
                ", name='" + name + '\'' +
                ", release_date='" + release_date + '\'' +
                ", release_date_precision='" + release_date_precision + '\'' +
                ", total_tracks=" + total_tracks +
                ", type='" + type + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public String album_type;
    public List<Artist> artists;
    public ExternalUrls external_urls;
    public String href;
    public String id;
    public List<Image> images;
    public String name;
    public String release_date;
    public String release_date_precision;
    public int total_tracks;
    public String type;
    public String uri;

}
