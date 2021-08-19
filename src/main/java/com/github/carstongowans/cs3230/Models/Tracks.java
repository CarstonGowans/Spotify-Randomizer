package com.github.carstongowans.cs3230.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class Tracks{
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String href;
    public List<Item> items;
    public int limit;
    public String next;
    public int offset;

    @Override
    public String toString() {
        return "Tracks{" +
                "href='" + href + '\'' +
                ", items=" + items +
                ", limit=" + limit +
                ", next='" + next + '\'' +
                ", offset=" + offset +
                ", previous=" + previous +
                ", total=" + total +
                '}';
    }

    public Object previous;
    public int total;
}
