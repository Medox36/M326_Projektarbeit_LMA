package ch.bzz.m326_projektarbeit_lma.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class FilterComponent extends JFrame {

    public FilterComponent(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);

        JPanel filterPanel = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Filter:");
        filterPanel.setBorder(titledBorder);

        JLabel abteilung = new JLabel("Abteilung:");
        JLabel funktion = new JLabel("Funktion:");
        JLabel team = new JLabel("Team:");

        String abteilungen[] = {"Logistik", "Tech", "Innovation", "Database", "Serverside"};
        String funktionen[] = {"- alle -","Mitarbeiter", "HR", "PR", "Externe"};
        String teams[] = {"Next Facility", "Team 1", "Team 2", "Team 3"};

        JComboBox abteilungList = new JComboBox<>(abteilungen);
        JComboBox funktionenList = new JComboBox<>(funktionen);
        JComboBox teamsList = new JComboBox<>(teams);

        filterPanel.setLayout(new GridLayout(3,2));
        filterPanel.add(abteilung);
        filterPanel.add(abteilungList);
        filterPanel.add(funktion);
        filterPanel.add(funktionenList);
        filterPanel.add(team);
        filterPanel.add(teamsList);

        getContentPane().add(filterPanel);

        setVisible(true);

    }

    public static void main(String[] args) {
        new FilterComponent();
    }


}
