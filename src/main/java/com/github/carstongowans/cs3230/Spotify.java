package com.github.carstongowans.cs3230;

import com.github.carstongowans.cs3230.models.Root;

import java.io.IOException;


public class Spotify {
    public static void main(String[] args) throws IOException {
        String token = "BQBsSgwhHIc6YyIw1Du9ezHmWkmygV5q1jkd27C--IFhvk2Etzr-VrlGORlBqq5YKelB7IfjBMzFwDpHYNnSKhMwquXkKW9q3T_Iye2_GPGyZFT7KxQr1GYadKDGS9Nzl2O5uXqpze4plxshmJhzCI9EQgPPypcoYY7zMqwBEkuOWmfmTBEGfYORECo";
        String tokenString = "Bearer " + token;
        SpotifyHelper.setToken(token);

        Root songRoot = SpotifyHelper.getSong("Tired Rynoka");                                                               // Create root class object from song name
        String artistID = songRoot.tracks.items.get(0).artists.get(0).id;                                                           // Grabs the Artist ID of the searched Song

        Root artistRoot = SpotifyHelper.getArtist(artistID);                                                                          // Creates a root class object from artistID

        String artistGenre1 = artistRoot.genres.get(0);                                                                             // Grabs the first two Genres from the artist of the searched song
        String artistGenre2 = artistRoot.genres.get(1);

        Root root3 = SpotifyHelper.getTracksByGenre(artistGenre1);                                                                    // Grabs the two newly searched songs and albums and creates root class objects
        Root root4 = SpotifyHelper.getTracksByGenre(artistGenre2);
        Root albumRoot1 = SpotifyHelper.getAlbumByGenre(artistGenre1);
        Root albumRoot2 = SpotifyHelper.getAlbumByGenre(artistGenre2);

        String album1Url = albumRoot1.albums.items.get(0).images.get(0).url;
        /*
        Most of the file path Structure for the root class object follow the same pattern
        Tracks
            | Href
            | Items
                | [0]
                    | Album
                    | Artist
                    | etc...
            | Limit
            | Next
            | offset
            | previous
            | total
            | etc...
        In general, Spotify's Json return is very convoluted, however, you can *almost* find any information as the return has a large amount of information.

        String songId = songRoot.tracks.items.get(0).id;                                                                          // Example to find tracks in root
        String imageUrl = songRoot.tracks.items.get(0).album.images.get(songRoot.tracks.items.get(0).album.images.size()-2).url;  // Example to  find image Url of a song in root
        */
    }
}