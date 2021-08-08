package com.github.carstongowans.cs3230.Gui;

import com.github.carstongowans.cs3230.Helper;
import com.github.carstongowans.cs3230.SpotifyHelper;
import com.github.carstongowans.cs3230.models.Root;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Gui {
    private JPanel panel1;
    private JTabbedPane tabs;
    private JFormattedTextField inputValues;
    private JTextArea minDisplay;
    private JButton calculateMax;
    private JButton calculateEvens;
    private JButton calculateOdds;
    private JButton calculateSum;
    private JButton calculateSTD;
    private JButton calculateFNS;
    private JButton calculateMin;
    private JTextArea maxDisplay;
    private JTextArea evensDisplay;
    private JTextArea oddsDisplay;
    private JTextArea sumDisplay;
    private JTextArea stdDisplay;
    private JTextArea fnsDisplay;
    private JPanel NumberPanel;
    private JPanel Spotify;
    private JFormattedTextField InputSongField;
    private JButton SearchButton;
    private JTextArea Album1Text;
    private JTextArea Album2Text;
    private JLabel Artwork1;
    private JLabel Artwork2;
    private JFormattedTextField InputTokenField;
    private JTextArea Song1Text;
    private JLabel SongArtwork1;
    private JTextArea Song2Text;
    private JLabel SongArtwork2;
    private JButton Random;

    public Gui() {
        calculateMin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int[] ints = Helper.inputToArray(inputValues.getText());
                minDisplay.setText(Helper.minStringBuilder(ints));
            }
        });

        calculateMax.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int[] ints = Helper.inputToArray(inputValues.getText());
                maxDisplay.setText(Helper.maxStringBuilder(ints));
            }
        });

        calculateEvens.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int[] ints = Helper.inputToArray(inputValues.getText());
                evensDisplay.setText(Helper.evensStringBuilder(ints));
            }
        });
        calculateOdds.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int[] ints = Helper.inputToArray(inputValues.getText());
                oddsDisplay.setText(Helper.oddsStringBuilder(ints));
            }
        });

        calculateSum.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int[] ints = Helper.inputToArray(inputValues.getText());
                sumDisplay.setText(Helper.sumStringBuilder(ints));
            }
        });
        calculateSTD.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int[] ints = Helper.inputToArray(inputValues.getText());
                stdDisplay.setText(Helper.stdStringBuilder(ints));
            }
        });

        calculateFNS.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int[] ints = Helper.inputToArray(inputValues.getText());
                fnsDisplay.setText(Helper.fnsStringBuilder(ints));

            }
        });
        SearchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                    String inputToken = InputTokenField.getText();
                    String inputSong = "\"" + InputSongField.getText() + "\"";
                try {
                    setTexts(inputSong, inputToken);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (IndexOutOfBoundsException f) {
                    InputSongField.setText("Invalid Song / Album");
                } catch (Exception g) {
                    InputSongField.setText("Invalid Song / Album");
                }

            }
        });
        Random.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                String inputToken = InputTokenField.getText();
                String inputSong = " ";

                try {
                    String randomSong = SpotifyHelper.getRandomSong(inputToken);
                    setTexts(randomSong, inputToken);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    InputSongField.setText("Invalid Song / Album Name");
                }
            }
        });
    }

    public void setTexts(String songName, String inputToken) throws IOException {
        SpotifyHelper.setToken(inputToken);
        boolean success = false;
        String artistGenre1 = " ";
        String artistGenre2 = " ";

        while(!success) {
            Root songRoot = SpotifyHelper.getSong(songName);                                                                             // Create root class object from song name
            String artistID = songRoot.tracks.items.get(0).artists.get(0).id;                                                           // Grabs the Artist ID of the searched Song
            String backupArtistID = songRoot.tracks.items.get(0).artists.get(0).name;

            Root artistRoot = SpotifyHelper.getArtist(artistID);                                                                        // Creates a root class object from artistID

            try {
                artistGenre1 = artistRoot.genres.get(0);                                                                         // Grabs the first and a random Genres from the artist of the searched song
                artistGenre2 = artistRoot.genres.get(artistRoot.genres.size()-1);
                success = true;
            } catch (IndexOutOfBoundsException e) {
                songName = SpotifyHelper.getRandomSong(inputToken);
            } catch (Exception e) {
                songName = SpotifyHelper.getRandomSong(inputToken);
            }
        }



        Root trackRoot1 = SpotifyHelper.getTracksByGenre(artistGenre1);                                                             // Grabs the two newly searched songs and albums and creates root class objects
        Root trackRoot2 = SpotifyHelper.getTracksByGenre(artistGenre2);
        Root albumRoot1 = SpotifyHelper.getAlbumByGenre(artistGenre1);
        Root albumRoot2 = SpotifyHelper.getAlbumByGenre(artistGenre2);

        String album1Url = albumRoot1.albums.items.get(0).images.get(0).url;                                                        // Finds the newly searched album's Image urls and Names
        String album2Url = albumRoot2.albums.items.get(0).images.get(0).url;
        String album1Name = "Album: " + albumRoot1.albums.items.get(0).name;
        String album2Name = "Album: " + albumRoot2.albums.items.get(0).name;

        int randomNumber1 = SpotifyHelper.randomNumber(trackRoot1.tracks.items.size()-1);                                       // Random number generator for random songs
        int randomNumber2 = SpotifyHelper.randomNumber(trackRoot2.tracks.items.size()-1);

        String track1ImageUrl = trackRoot1.tracks.items.get(randomNumber1).album.images.get(0).url;                                 // Finds the newly searched song's Image Urls and Names
        String track1Name = "Song: " + trackRoot1.tracks.items.get(randomNumber1).name;
        String track2ImageUrl = trackRoot2.tracks.items.get(randomNumber1).album.images.get(0).url;
        String track2Name = "Song: " + trackRoot2.tracks.items.get(randomNumber1).name;

        Artwork1.setIcon(SpotifyHelper.urlToImageResized(album1Url));                                                               // Sets Information gathered from above calls to GUI
        Album1Text.setText(album1Name);

        Artwork2.setIcon(SpotifyHelper.urlToImageResized(album2Url));
        Album2Text.setText(album2Name);

        SongArtwork1.setIcon(SpotifyHelper.urlToImageResized(track1ImageUrl));
        Song1Text.setText(track1Name);

        SongArtwork2.setIcon(SpotifyHelper.urlToImageResized(track2ImageUrl));
        Song2Text.setText(track2Name);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cs3230 GUI");
        frame.setContentPane(new Gui().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1200, 900));
        frame.pack();
        frame.setVisible(true);

    }
}

