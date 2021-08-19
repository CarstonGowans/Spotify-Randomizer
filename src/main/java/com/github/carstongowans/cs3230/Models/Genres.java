package com.github.carstongowans.cs3230.Models;

import java.util.List;
import java.util.Random;

public class Genres {                               // Utility Class for the Json ->Gson-> ArrayList
    private List<String> genres;                    // Variable from Json

    public void setGenres(List<String> genres) {    // Constructor
        this.genres = genres;
    }
    public List<String> getGenres() {               // Getter Function
        return this.genres;
    }

    public String randomGenre() {
        Random random = new Random();
        int randomValue = random.nextInt(genres.size());
        String randomGenre = genres.get(randomValue);
        return randomGenre;
    }




}
