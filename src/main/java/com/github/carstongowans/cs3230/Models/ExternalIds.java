package com.github.carstongowans.cs3230.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ExternalIds{
    @Override
    public String toString() {
        return "ExternalIds{" +
                "isrc='" + isrc + '\'' +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public String isrc;
}
