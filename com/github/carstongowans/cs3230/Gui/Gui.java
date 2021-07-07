package com.github.carstongowans.cs3230.Gui;

import javax.swing.*;

public class Gui {
    private JPanel panel1;
    private JFormattedTextField enterNumbersFormattedTextField;
    private JButton calculateButton;
    private JTextArea textArea2;
    private JTextArea minTextArea;

    public static void main(String[] args){
        JFrame frame = new JFrame("Cs3230 GUI");
        frame.setContentPane(new Gui().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}

