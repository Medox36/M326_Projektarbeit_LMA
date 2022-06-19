package ch.bzz.m326_projektarbeit_lma.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Zuordnung_View extends JFrame {

    String names[] = {
            "Benak Alexander","Giuntini Lorenzo", "Hawi Moustafa",
            "Jadyn Esquivel","Alondra Wren","Tara Richter","Roxanna Jack","Laci Barrera",
            "Karina Matheny","Tyson Stringer","Devontae Lombardo","Kailey Wiles","Adrian Swift"
    };

    String funktionList[] = {
            "Funktion wählen", "HR", "Mitarbeiter", "Praktikant", "Lehrling"
    };

    String teamList[] = {
            "Team wählen", "Innovation Team", "Logistik Team",
    };

    public Zuordnung_View(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550,550);

        JPanel mainPanel = new JPanel(new GridLayout(1,2));
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new BoxLayout(subPanel,BoxLayout.PAGE_AXIS));

        JPanel uebersichtPanel = new JPanel(new GridLayout(2,1));

        TitledBorder title1 = BorderFactory.createTitledBorder("Personen bearbeiten:");
        mainPanel.setBorder(title1);
        TitledBorder title2 = BorderFactory.createTitledBorder("Detail:");
        subPanel.setBorder(title2);

        JList nameList = new JList(names);
        nameList.setLayoutOrientation(JList.VERTICAL);
        JScrollPane scrollPane = new JScrollPane(nameList);
        scrollPane.setPreferredSize(new Dimension(150,200));
        scrollPane.setVerticalScrollBarPolicy(22); //Always on
        scrollPane.setHorizontalScrollBarPolicy(31); //Never

        JLabel uebersichtLabel = new JLabel("Übersicht:");
        uebersichtPanel.add(uebersichtLabel);
        uebersichtPanel.add(scrollPane);

        mainPanel.add(uebersichtPanel, BorderLayout.WEST);

        ///////////////////////////////////////

        JPanel namePanel = new JPanel(new GridLayout(1,2));
        namePanel.setMaximumSize(new Dimension(260,30));
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameTextField = new JTextField();
        namePanel.add(nameLabel);
        namePanel.add(nameTextField);

        subPanel.add(namePanel);
        subPanel.setLayout(new GridLayout(3,1,0,15));

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("img.png"));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        JLabel imageLabel = new JLabel(imageIcon);

        subPanel.add(imageLabel);

        /////////////////////////////////////////////

        JPanel infosPanel = new JPanel(new GridLayout(3,2));

        JLabel abteilung = new JLabel("Abteilung:");
        JLabel funktion = new JLabel("Funktion:");
        JLabel teams = new JLabel("Teams:");
        JTextField abteilungTextField = new JTextField("Finance");
        JComboBox funktionCombo = new JComboBox<>(funktionList);
        JComboBox teamCombo = new JComboBox<>(teamList);

        infosPanel.add(abteilung);
        infosPanel.add(abteilungTextField);
        infosPanel.add(funktion);
        infosPanel.add(funktionCombo);
        infosPanel.add(teams);
        infosPanel.add(teamCombo);

        subPanel.add(infosPanel);

        /////////////////////////////////////////////

        mainPanel.add(subPanel, BorderLayout.CENTER);
        getContentPane().add(mainPanel);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Zuordnung_View();
    }

    public JPanel createView(){

        JPanel mainPanel = new JPanel(new GridLayout(1,2));
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new BoxLayout(subPanel,BoxLayout.PAGE_AXIS));

        JPanel uebersichtPanel = new JPanel(new GridLayout(2,1));

        TitledBorder title1 = BorderFactory.createTitledBorder("Personen bearbeiten:");
        mainPanel.setBorder(title1);
        TitledBorder title2 = BorderFactory.createTitledBorder("Detail:");
        subPanel.setBorder(title2);

        JList nameList = new JList(names);
        nameList.setLayoutOrientation(JList.VERTICAL);
        JScrollPane scrollPane = new JScrollPane(nameList);
        scrollPane.setPreferredSize(new Dimension(150,200));
        scrollPane.setVerticalScrollBarPolicy(22); //Always on
        scrollPane.setHorizontalScrollBarPolicy(31); //Never

        JLabel uebersichtLabel = new JLabel("Übersicht:");
        uebersichtPanel.add(uebersichtLabel);
        uebersichtPanel.add(scrollPane);

        mainPanel.add(uebersichtPanel, BorderLayout.WEST);

        ///////////////////////////////////////

        JPanel namePanel = new JPanel(new GridLayout(1,2));
        namePanel.setMaximumSize(new Dimension(260,30));
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameTextField = new JTextField();
        namePanel.add(nameLabel);
        namePanel.add(nameTextField);

        subPanel.add(namePanel);
        subPanel.setLayout(new GridLayout(3,1,0,15));

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("img.png"));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        JLabel imageLabel = new JLabel(imageIcon);

        subPanel.add(imageLabel);

        /////////////////////////////////////////////

        JPanel infosPanel = new JPanel(new GridLayout(3,2));

        JLabel abteilung = new JLabel("Abteilung:");
        JLabel funktion = new JLabel("Funktion:");
        JLabel teams = new JLabel("Teams:");
        JTextField abteilungTextField = new JTextField("Finance");
        JComboBox funktionCombo = new JComboBox<>(funktionList);
        JComboBox teamCombo = new JComboBox<>(teamList);

        infosPanel.add(abteilung);
        infosPanel.add(abteilungTextField);
        infosPanel.add(funktion);
        infosPanel.add(funktionCombo);
        infosPanel.add(teams);
        infosPanel.add(teamCombo);

        subPanel.add(infosPanel);

        /////////////////////////////////////////////

        mainPanel.add(subPanel, BorderLayout.CENTER);

        return mainPanel;

    }


}




