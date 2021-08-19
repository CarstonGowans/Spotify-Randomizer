package com.github.carstongowans.cs3230.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Item{
    public Album album;
    public List<Artist> artists;
    public int disc_number;
    public int duration_ms;
    public boolean explicit;
    public ExternalIds external_ids;
    public ExternalUrls external_urls;
    public String href;
    public String id;
    public List<Image> images;
    public boolean is_local;
    public boolean is_playable;
    public String name;
    public int popularity;
    public String preview_url;
    public int track_number;
    public String type;
    public String uri;



    @Override
    public String toString() {
        return "Item{" +
                "album=" + album +
                ", artists=" + artists +
                ", disc_number=" + disc_number +
                ", duration_ms=" + duration_ms +
                ", explicit=" + explicit +
                ", external_ids=" + external_ids +
                ", external_urls=" + external_urls +
                ", href='" + href + '\'' +
                ", id='" + id + '\'' +
                ", is_local=" + is_local +
                ", is_playable=" + is_playable +
                ", name='" + name + '\'' +
                ", popularity=" + popularity +
                ", preview_url='" + preview_url + '\'' +
                ", track_number=" + track_number +
                ", type='" + type + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }
}
