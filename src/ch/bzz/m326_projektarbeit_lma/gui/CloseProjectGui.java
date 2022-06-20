package ch.bzz.m326_projektarbeit_lma.gui;

import javax.swing.*;
import java.awt.*;

public class CloseProjectGui extends JFrame {
    private JLabel label = new JLabel("Das Programm wird heruntergefahren...");
    public CloseProjectGui(){
        setTitle("Error-Abbruch");
        setSize(300,120);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(10,10));


        JPanel mainPanel = new JPanel(new BorderLayout(10,10));

        mainPanel.add(label, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CloseProjectGui();
    }
}
