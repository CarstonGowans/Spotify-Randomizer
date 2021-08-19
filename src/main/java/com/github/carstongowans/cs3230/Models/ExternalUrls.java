package com.github.carstongowans.cs3230.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ExternalUrls{
    @Override
    public String toString() {
        return "ExternalUrls{" +
                "spotify='" + spotify + '\'' +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public String spotify;
}
