package ch.bzz.m326_projektarbeit_lma.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Zuordnung_View extends JFrame {

    String names[] = {
            "Benak Alexander","Giuntini Lorenzo", "Hawi Moustafa",
            "Jadyn Esquivel","Alondra Wren","Tara Richter","Roxanna Jack","Laci Barrera",
            "Karina Matheny","Tyson Stringer","Devontae Lombardo","Kailey Wiles","Adrian Swift"
    };

    public Zuordnung_View(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        JPanel uebersichtPanel = new JPanel(new GridLayout(2,1));

        TitledBorder title1 = BorderFactory.createTitledBorder("Personen bearbeiten:");
        panel1.setBorder(title1);
        TitledBorder title2 = BorderFactory.createTitledBorder("Detail:");
        panel2.setBorder(title2);

        JList nameList = new JList(names);
        nameList.setLayoutOrientation(JList.VERTICAL);
        JScrollPane scrollPane = new JScrollPane(nameList);
        scrollPane.setPreferredSize(new Dimension(150,200));
        scrollPane.setVerticalScrollBarPolicy(22); //Always on
        scrollPane.setHorizontalScrollBarPolicy(31); //Never

        JLabel uebersichtLabel = new JLabel("Übersicht:");
        uebersichtPanel.add(uebersichtLabel);
        uebersichtPanel.add(scrollPane);

        JButton button1 = new JButton("X");
        JButton button2 = new JButton("X");
        JButton button3 = new JButton("X");
        JPanel buttonPanel = new JPanel(new GridLayout(1,3));
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        panel1.add(uebersichtPanel, BorderLayout.WEST);

        ///////////////////////////////////////

        JPanel namePanel = new JPanel(new GridLayout(1,2));
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameTextField = new JTextField();
        namePanel.add(nameLabel);
        namePanel.add(nameTextField);
        panel2.add(namePanel, BorderLayout.NORTH);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("img.png"));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        JLabel imageLabel = new JLabel(imageIcon);

        panel2.add(imageLabel);
        panel1.add(panel2, BorderLayout.CENTER);

        getContentPane().add(panel1);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Zuordnung_View();
    }

}
