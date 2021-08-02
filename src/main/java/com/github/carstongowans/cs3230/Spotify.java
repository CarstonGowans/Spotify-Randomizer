package com.github.carstongowans.cs3230;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.carstongowans.cs3230.models.Genres;
import com.github.carstongowans.cs3230.models.Root;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;


public class Spotify {
    public static void main(String[] args) throws IOException {
        String token = "Bearer " + "BQBe-82bSNmNYp9pmgvqqrfHB2LTWjd1LJvb8sI5bVE5bZnNET-KoN_2f9H_NhJtUKj6OKJ9PN-DB4Dtsudo020OVe-E8cB6x7sCOWYA5zTSCxVLqMsIrb6a8EZAKlA1MSDTlD06HkeFFZClAI3PU1WqTU9xemDtzUoqXOgLqCwzJhl2QdsYOH9Fx1I";

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/recommendations/available-genre-seeds")
                .method("GET", null)
                .addHeader("Authorization", token)
                .build();
        Response response = client.newCall(request).execute();

        Gson gson = new Gson();                                                             // Gson Parse
        Genres genreList = gson.fromJson(response.body().string(), Genres.class);           // Set new array to Gson parse.
                                                                                            // The class has an array List inside of it, so we're mapping the Json object over to the classes List<String>
        //System.out.println(genreList.getGenres().toString());

        String randomGenre = genreList.randomGenre();
        //System.out.println(randomGenre);
        String urlString = "https://api.spotify.com/v1/search?q=" + randomGenre +"&type=track,artist&market=US&limit=1&offest=5";

        OkHttpClient client1 = new OkHttpClient().newBuilder()                              // Client for building Random Genre of songs
                .build();
        Request request1 = new Request.Builder()
                .url(urlString)
                .method("GET", null)
                .addHeader("Authorization", token)
                .build();
        Response response1 = client.newCall(request1).execute();                            // Response returned in JSOn format from Spotify API

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Root root = om.readValue(response1.body().string(), Root.class);
            //System.out.println(root.toString());

        String songName = "Tired Rynoka";
        songName.replace(" ", "%20");

        String urlSearch = "https://api.spotify.com/v1/search?q=" + songName +"&type=track&market=US&limit=1";
        OkHttpClient client2 = new OkHttpClient().newBuilder()                             // Client for building Song Searches
                .build();
        Request request2 = new Request.Builder()
                .url(urlSearch)
                .method("GET", null)
                .addHeader("Authorization", token)
                .addHeader("Cookie", "sp_t=289d077b9b2295bd6055293680aa3cbd")
                .build();
        Response response2 = client.newCall(request2).execute();
        ObjectMapper om1 = new ObjectMapper();
        om1.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Root root1 = om.readValue(response2.body().string(), Root.class);
        System.out.println(root1.toString());
        String songId = root1.tracks.items.get(0).id;
        System.out.println(songId);
        String imageUrl = root1.tracks.items.get(0).album.images.get(root1.tracks.items.get(0).album.images.size()-2).url;
        System.out.println(imageUrl);


    }
}
