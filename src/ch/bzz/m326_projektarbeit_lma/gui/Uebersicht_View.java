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
import java.util.Objects;

/**
 * This class creates the "Übersicht" using a single Method -  the createView
 * @Author Alexander Benak, Lorenzo Giuntini
 * @Since 21.06.2022
 * @Version 1.4
 */
public class Uebersicht_View extends JFrame {

    /**
     * An empty constructor
     */
    public Uebersicht_View(){
        //empty
    }

    /**
     * The createView method which holds all the components of the "Übersicht"
     * @return mainPanel
     */
    public JPanel createView() {

        JPanel mainPanel = new JPanel();
        JPanel uebersichtPanel = new JPanel();

        //A label for the scrollpane in the overview
        JLabel uebersicht = new JLabel("Übersicht:");

        //The detailPanel and its layout
        JPanel detailPanel = new JPanel();
        detailPanel.setLayout(new BoxLayout(detailPanel,BoxLayout.PAGE_AXIS));

        //The data for the scrollpane
        JList<Person> nameList = new JList<>(new PersonListModel());
        nameList.setLayoutOrientation(JList.VERTICAL);

        //The scrollpane with formatting
        JScrollPane scrollPane1 = new JScrollPane(nameList);
        scrollPane1.setPreferredSize(new Dimension(150,200));
        scrollPane1.setVerticalScrollBarPolicy(22); //Always on
        scrollPane1.setHorizontalScrollBarPolicy(31); //Never
        uebersichtPanel.add(uebersicht);
        uebersichtPanel.add(scrollPane1);
        mainPanel.add(uebersichtPanel);

        //Creates the titled borders
        TitledBorder title1 = BorderFactory.createTitledBorder("Person:");
        mainPanel.setBorder(title1);
        TitledBorder title2 = BorderFactory.createTitledBorder("Detail:");
        detailPanel.setBorder(title2);

        //The name label with a textfield
        JPanel namePanel = new JPanel(new GridLayout(1,2));
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameTextField = new JTextField("Benak Alexander");
        nameTextField.setEditable(false);
        namePanel.add(nameLabel);
        namePanel.add(nameTextField);
        detailPanel.add(namePanel);

        //Empty image added by formatting
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("img.png")));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        JLabel imageLabel = new JLabel(imageIcon);
        detailPanel.add(imageLabel);

        //Abteilung: A Label and a Textfield
        JPanel abteilungPanel = new JPanel(new GridLayout(1,2));
        JLabel abteilungLabel1 = new JLabel("Abteilung:");
        JTextField abteilungTextField = new JTextField("Finance");
        abteilungTextField.setEditable(false);
        abteilungPanel.add(abteilungLabel1);
        abteilungPanel.add(abteilungTextField);
        detailPanel.add(abteilungPanel);

        JPanel scrollPanel = new JPanel(new GridLayout(1,2));

        //Funktion: A Scrollpane
        JScrollPane scrollPane2 = new JScrollPane(nameList);
        scrollPane2.setPreferredSize(new Dimension(150,200));
        scrollPane2.setVerticalScrollBarPolicy(22); //Always on
        scrollPane2.setHorizontalScrollBarPolicy(31); //Never

        //Teams: A Scrollpane
        JScrollPane scrollPane3 = new JScrollPane(nameList);
        scrollPane3.setPreferredSize(new Dimension(150,200));
        scrollPane3.setVerticalScrollBarPolicy(22); //Always on
        scrollPane3.setHorizontalScrollBarPolicy(31); //Never
        scrollPanel.add(scrollPane2);
        scrollPanel.add(scrollPane3);
        detailPanel.add(scrollPanel);

        //The bottomPanel holds the sortierungPanel and the filterPanel
        JPanel bottomPanel = new JPanel(new GridLayout(1,2));

        //The sortierungPanel where all the Radiobuttons come in
        JPanel sortierungPanel = new JPanel();

        //Creates the titled border
        TitledBorder title3 = BorderFactory.createTitledBorder("Sortierung:");
        sortierungPanel.setBorder(title3);

        //Creates all the choices in the form of Radiobuttons and adds them to a panel
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
        bottomPanel.add(sortierungPanel);

        //The filterPanel where all the dropdowns come in
        JPanel filterPanel = new JPanel();
        TitledBorder title4 = BorderFactory.createTitledBorder("Filter:");
        filterPanel.setBorder(title4);

        //Creates the dropdowns and adds them to a panel
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

        //Merge everything together
        mainPanel.add(detailPanel);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        return mainPanel;
    }
}
