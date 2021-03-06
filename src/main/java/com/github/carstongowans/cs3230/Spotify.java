package com.github.carstongowans.cs3230;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.carstongowans.cs3230.Models.Root;
import net.coobird.thumbnailator.Thumbnails;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

public class Spotify {
    public static String token = "";

    public static String getToken() {
        return token;
    }                                       // Getter for Token variable

    public static void setToken(String token) {                                             // Sets the get API token String for HTTP Requests
        String newToken = "Bearer " + token;
        Spotify.token = newToken;
    }

    public static int randomNumber(int max) {                                               // Random Number generator from [0, int max)
        Random random = new Random();
        int randomValue = random.nextInt(max);
        return randomValue;
    }

    public static Icon urlToImageResized(String url) throws IOException {                   // Sets the size of the image from a Spotify Url and returns it as an Icon for Jframes
        URL imageUrl = new URL(url);
        BufferedImage image = ImageIO.read(imageUrl);                                       // Create image
        BufferedImage newImage = Thumbnails.of(image)                                       // Resize Image
                .size(200, 200)
                .asBufferedImage();

        ImageIcon icon = new ImageIcon(newImage);                                           // Set resized image as an Icon and return
        return icon;
    }

    public static Root getSong(String songName) throws IOException {
        String updatedSongName = updateStringChars(songName);                                                               // Update the song string

        String urlSearch = "https://api.spotify.com/v1/search?q=" + updatedSongName +"&type=track&market=US&limit=1";       // Create the Url for the search based on the song name

        OkHttpClient client = new OkHttpClient().newBuilder()                                                               // Create the OkHttpClient request with appropriate parameters
                .build();
        Request request = new Request.Builder()
                .url(urlSearch)
                .method("GET", null)
                .addHeader("Authorization", getToken())
                .addHeader("Cookie", "sp_landing=https%3A%2F%2Fopen.spotify.com%2Fartist%2F15sYSrzP78TY7MSWjrFjuy; sp_t=289d077b9b2295bd6055293680aa3cbd")
                .build();
        Response response = client.newCall(request).execute();                                                              // Grab the JSON response

        ObjectMapper om = new ObjectMapper();                                                                               // Create new class file
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Root root = om.readValue(response.body().string(), Root.class);
        return root;                                                                                                        // Return the new class object
    }

    public static String getRandomSong(String inputToken) throws IOException {
        Spotify.setToken(inputToken);                                                                                       // Update the song string
        OkHttpClient client = new OkHttpClient().newBuilder()                                                               // OkHttp call for random Genre list with appropriate parameters
                .build();
        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/recommendations/available-genre-seeds")
                .method("GET", null)
                .addHeader("Authorization", getToken())
                .addHeader("Cookie", "sp_landing=https%3A%2F%2Fopen.spotify.com%2Fartist%2F15sYSrzP78TY7MSWjrFjuy; sp_t=289d077b9b2295bd6055293680aa3cbd")
                .build();
        Response response = client.newCall(request).execute();                                                              // Grab JSON response

        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Root genreRoot = om.readValue(response.body().string(), Root.class);                                                // Random Genre root class

        String randomGenre = genreRoot.genres.get(Spotify.randomNumber(genreRoot.genres.size()-1));                    // Grab Random genre from the List

        OkHttpClient client1 = new OkHttpClient().newBuilder()                                                              // Create the OkHttpClient request for a random song with the appropriate parameters
                .build();
        Request request1 = new Request.Builder()
                .url("https://api.spotify.com/v1/search?q=" + randomGenre + "&type=track&market=US&limit=10&offest=5")
                .method("GET", null)
                .addHeader("Authorization", getToken())
                .addHeader("Cookie", "sp_landing=https%3A%2F%2Fopen.spotify.com%2Fartist%2F15sYSrzP78TY7MSWjrFjuy; sp_t=289d077b9b2295bd6055293680aa3cbd")
                .build();
        Response response1 = client1.newCall(request1).execute();                                                           // Grab the JSON response
        ObjectMapper om1 = new ObjectMapper();                                                                              // Create new root class object from object wrapper
        om1.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Root songsList = om1.readValue(response1.body().string(), Root.class);

        String randomSongName = songsList.tracks.items.get(songsList.tracks.items.size()-1).name;
        return randomSongName;
    }

    public static Root getTracksByGenre(String genre) throws IOException {
        String newGenreString = updateStringChars(genre);                                                                   // Update the genre String for Http Request
        String genreUrl = "https://api.spotify.com/v1/search?q=" + newGenreString + "&type=track&market=US&limit=10&offest=" + randomNumber(150);
        OkHttpClient client = new OkHttpClient().newBuilder()                                                               // Create the OkHttpClient request for a list of tracks with appropriate parameters
                .build();
        Request request = new Request.Builder()
                .url(genreUrl)
                .method("GET", null)
                .addHeader("Authorization", getToken())
                .addHeader("Cookie", "sp_t=289d077b9b2295bd6055293680aa3cbd")
                .build();
        Response response = client.newCall(request).execute();                                                              // Grab JSON request

        ObjectMapper om = new ObjectMapper();                                                                               // Create Root class object
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Root root = om.readValue(response.body().string(), Root.class);
        return root;
    }

    public static Root getAlbumByGenre(String genre) throws IOException {
        String newGenreString = updateStringChars(genre);                                                                   // Update the genre String for Http Request
        String genreUrl = "https://api.spotify.com/v1/search?q=" + newGenreString + "&type=album&market=US&limit=10&offest=" + randomNumber(150);
        OkHttpClient client = new OkHttpClient().newBuilder()                                                               // Create the OkHttpClient request for a list of tracks with appropriate parameters
                .build();
        Request request = new Request.Builder()
                .url(genreUrl)
                .method("GET", null)
                .addHeader("Authorization", getToken())
                .addHeader("Cookie", "sp_t=289d077b9b2295bd6055293680aa3cbd")
                .build();
        Response response = client.newCall(request).execute();                                                              // Grab JSON request
        ObjectMapper om = new ObjectMapper();                                                                               // Create root class object
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Root root = om.readValue(response.body().string(), Root.class);
        return root;
    }

    public static Root getArtist(String artistID) throws IOException {
        String artistUrl = "https://api.spotify.com/v1/artists/" + artistID;                                                // Update the artist String for Http Request

        OkHttpClient client = new OkHttpClient().newBuilder()                                                               // Create the OkHttpClient request for a list of tracks with appropriate parameters
                .build();
        Request request = new Request.Builder()
                .url(artistUrl)
                .method("GET", null)
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", getToken())
                .addHeader("Cookie", "sp_t=289d077b9b2295bd6055293680aa3cbd")
                .build();
        Response response = client.newCall(request).execute();                                                              // Grab JSON request

        ObjectMapper om = new ObjectMapper();                                                                               // Create JSON request
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Root root = om.readValue(response.body().string(), Root.class);
        return root;
    }

    public static String updateStringChars(String oldSongString) {
        String newSongString = oldSongString.replace(" ", "%20");                                           // Spotify API calls require that spaces are replaced with an Asci value of '%20'
        return newSongString;
    }
}
