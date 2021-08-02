package com.github.carstongowans.cs3230.Gui;

import com.github.carstongowans.cs3230.Helper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private JFormattedTextField SongSearchBar;
    private JButton SearchButton;
    private JPanel Song2Panel;
    private JPanel Song3Panel;
    private JTextArea Album1Text;
    private JTextArea textArea1;
    private JTextArea textArea2;

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
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cs3230 GUI");
        frame.setContentPane(new Gui().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900, 600));
        frame.pack();
        frame.setVisible(true);
    }

}

