package com.github.carstongowans.cs3230.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

public class Artist{
    @Override
    public String toString() {
        return "Artist{" +
                "external_urls=" + external_urls +
                ", href='" + href + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", uri='" + uri + '\'' +
                ", items=" + Arrays.toString(items) +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public ExternalUrls external_urls;
    public String href;
    public String id;
    public String name;
    public String type;
    public String uri;
    public Item[] items;
}
