package ch.bzz.m326_projektarbeit_lma.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Uebersicht_View extends JFrame {

    String names[] = {
            "Benak Alexander","Giuntini Lorenzo", "Hawi Moustafa",
            "Jadyn Esquivel","Alondra Wren","Tara Richter","Roxanna Jack","Laci Barrera",
            "Karina Matheny","Tyson Stringer","Devontae Lombardo","Kailey Wiles","Adrian Swift"
    };

    String abteilungList[] = {
            "Logistik", "Transport", "Verwaltung", "Buchhaltung", "IT"
    };

    String funktionList[] = {
            "- alle -", "HR", "Mitarbeiter", "Praktikant", "Lehrling"
    };

    String teamList[] = {
            "Next Facility", "Innovation Team", "Logistik Team",
    };

    public Uebersicht_View(){

        JPanel mainPanel = new JPanel();

        JLabel uebersicht = new JLabel("Übersicht:");
        JPanel detailPanel = new JPanel();
        JPanel overviewPanel = new JPanel();

        JList nameList = new JList(names);
        nameList.setLayoutOrientation(JList.VERTICAL);

        JScrollPane scrollPane = new JScrollPane(nameList);
        scrollPane.setPreferredSize(new Dimension(150,200));
        scrollPane.setVerticalScrollBarPolicy(22); //Always on
        scrollPane.setHorizontalScrollBarPolicy(31); //Never
        overviewPanel.add(uebersicht);
        overviewPanel.add(scrollPane);
        mainPanel.add(overviewPanel);

        TitledBorder title1 = BorderFactory.createTitledBorder("Person:");
        mainPanel.setBorder(title1);

        TitledBorder title2 = BorderFactory.createTitledBorder("Detail:");
        detailPanel.setBorder(title2);
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameTextField = new JTextField("Benak Alexander");
        nameTextField.setEditable(false);
        detailPanel.add(nameLabel);
        detailPanel.add(nameTextField);

    }

    public static void main(String[] args) {
        new Uebersicht_View();
    }

    public JPanel createView(){

        JPanel mainPanel = new JPanel();

        JLabel uebersicht = new JLabel("Übersicht:");
        JPanel detailPanel = new JPanel();
        JPanel uebersichtPanel = new JPanel();

        JList nameList = new JList(names);
        nameList.setLayoutOrientation(JList.VERTICAL);

        JScrollPane scrollPane = new JScrollPane(nameList);
        scrollPane.setPreferredSize(new Dimension(150,200));
        scrollPane.setVerticalScrollBarPolicy(22); //Always on
        scrollPane.setHorizontalScrollBarPolicy(31); //Never
        uebersichtPanel.add(uebersicht);
        uebersichtPanel.add(scrollPane);
        mainPanel.add(uebersichtPanel);

        TitledBorder title1 = BorderFactory.createTitledBorder("Person:");
        mainPanel.setBorder(title1);

        TitledBorder title2 = BorderFactory.createTitledBorder("Detail:");
        detailPanel.setBorder(title2);

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameTextField = new JTextField("Benak Alexander");
        nameTextField.setEditable(false);
        detailPanel.add(nameLabel);
        detailPanel.add(nameTextField);

        ////////////////////////////////////

        JPanel sortierungPanel = new JPanel();
        TitledBorder title3 = BorderFactory.createTitledBorder("Sortierung:");
        sortierungPanel.setBorder(title3);

        JPanel sortierungAuswahl = new JPanel(new GridLayout(3,2));
        JRadioButton radioButton1 = new JRadioButton();
        JRadioButton radioButton2 = new JRadioButton();
        JRadioButton radioButton3 = new JRadioButton();
        JLabel keine = new JLabel("keine");
        JLabel az = new JLabel("A-Z");
        JLabel za = new JLabel("Z-A");
        sortierungAuswahl.add(keine);
        sortierungAuswahl.add(radioButton1);
        sortierungAuswahl.add(az);
        sortierungAuswahl.add(radioButton2);
        sortierungAuswahl.add(za);
        sortierungAuswahl.add(radioButton3);

        sortierungPanel.add(sortierungAuswahl);

        ///////////////////////////////////////////

        JPanel filterPanel = new JPanel();
        TitledBorder title4 = BorderFactory.createTitledBorder("Filter:");
        filterPanel.setBorder(title4);

        JPanel filterAuswahl = new JPanel(new GridLayout(3,2));
        JLabel abteilungLabel = new JLabel("Abteilung:");
        JLabel funktionLabel = new JLabel("Funktion:");
        JLabel teamLabel = new JLabel("Team:");
        JComboBox abteilungCombobox = new JComboBox<>(abteilungList);
        JComboBox funktionCombobox = new JComboBox<>(funktionList);
        JComboBox teamCombobox = new JComboBox<>(teamList);
        filterAuswahl.add(abteilungLabel);
        filterAuswahl.add(abteilungCombobox);
        filterAuswahl.add(funktionLabel);
        filterAuswahl.add(funktionCombobox);
        filterAuswahl.add(teamLabel);
        filterAuswahl.add(teamCombobox);

        filterPanel.add(filterAuswahl);

        mainPanel.add(detailPanel);
        mainPanel.add(sortierungPanel);
        mainPanel.add(filterPanel);


        return mainPanel;

    }

}
