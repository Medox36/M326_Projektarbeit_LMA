package ch.bzz.m326_projektarbeit_lma.gui;

import javax.swing.*;
import java.awt.*;

public class ErrorGUI extends JFrame {
    JLabel label = new JLabel("Passwort nicht gültig");
    JButton wiederholenButton = new JButton("Wiederholen");

    public ErrorGUI(){
        setTitle("Error-Passwort falsch");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(200,120);
        getContentPane().setLayout(new BorderLayout(5,5));

        JPanel mainPanel = new JPanel(new BorderLayout(5,5));
        JPanel gridPanel = new JPanel(new GridLayout(2,1,5,5));

        gridPanel.add(label);
        gridPanel.add(wiederholenButton);
        mainPanel.add(gridPanel, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ErrorGUI();
    }
}
