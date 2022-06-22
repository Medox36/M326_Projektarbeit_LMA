package ch.bzz.m326_projektarbeit_lma.gui;

import ch.bzz.m326_projektarbeit_lma.company.Department;
import ch.bzz.m326_projektarbeit_lma.employees.Person;
import ch.bzz.m326_projektarbeit_lma.gui.model.DepartmentComboboxModel;
import ch.bzz.m326_projektarbeit_lma.gui.model.JobFunctionsComboboxModel;
import ch.bzz.m326_projektarbeit_lma.gui.model.PersonListModel;
import ch.bzz.m326_projektarbeit_lma.gui.model.TeamComboboxModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * This class creates the "Übersicht" using a single Method -  the createView
 */
public class Uebersicht_View extends JFrame {

    public Uebersicht_View(){
        JPanel mainPanel = new JPanel();

        JLabel uebersicht = new JLabel("Übersicht:");
        JPanel detailPanel = new JPanel();
        JPanel overviewPanel = new JPanel();

        JList<Person> nameList = new JList<>(new PersonListModel());
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

    public JPanel createView() {
        JPanel mainPanel = new JPanel();

        JLabel uebersicht = new JLabel("Übersicht:");
        JPanel detailPanel = new JPanel();
        JPanel uebersichtPanel = new JPanel();

        JList<Person> nameList = new JList<>(new PersonListModel());
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

        JPanel abteilungPanel = new JPanel(new GridLayout(1,2));
        JLabel abteilungLabel1 = new JLabel("Abteilung:");
        JTextField abteilungTextField = new JTextField("Finance");
        abteilungTextField.setEditable(false);
        abteilungPanel.add(abteilungLabel1);
        abteilungPanel.add(abteilungTextField);

        ////////////////////////////////////

        JPanel bottomPanel = new JPanel(new GridLayout(1,2));

        JPanel sortierungPanel = new JPanel();
        TitledBorder title3 = BorderFactory.createTitledBorder("Sortierung:");
        sortierungPanel.setBorder(title3);

        JPanel sortierungAuswahl = new JPanel(new GridLayout(3,2));
        JRadioButton radioButton1 = new JRadioButton();
        JRadioButton radioButton2 = new JRadioButton();
        JRadioButton radioButton3 = new JRadioButton();
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
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
        bottomPanel.add(sortierungPanel);

        radioButton1.addActionListener(e -> {new Uebersicht_View();});
        ///////////////////////////////////////////

        JPanel filterPanel = new JPanel();
        TitledBorder title4 = BorderFactory.createTitledBorder("Filter:");
        filterPanel.setBorder(title4);

        JPanel filterAuswahl = new JPanel(new GridLayout(3,2));
        JLabel abteilungLabel = new JLabel("Abteilung:");
        JLabel funktionLabel = new JLabel("Funktion:");
        JLabel teamLabel = new JLabel("Team:");
        JComboBox<Department> abteilungCombobox = new JComboBox<>(new DepartmentComboboxModel());
        JComboBox<String> funktionCombobox = new JComboBox<>(new JobFunctionsComboboxModel());
        JComboBox<String> teamCombobox = new JComboBox<>(new TeamComboboxModel());
        filterAuswahl.add(abteilungLabel);
        filterAuswahl.add(abteilungCombobox);
        filterAuswahl.add(funktionLabel);
        filterAuswahl.add(funktionCombobox);
        filterAuswahl.add(teamLabel);
        filterAuswahl.add(teamCombobox);

        filterPanel.add(filterAuswahl);
        bottomPanel.add(filterPanel);

        mainPanel.add(detailPanel);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);



        return mainPanel;
    }
}
