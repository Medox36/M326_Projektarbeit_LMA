package ch.bzz.m326_projektarbeit_lma.gui;

import ch.bzz.m326_projektarbeit_lma.company.Department;
import ch.bzz.m326_projektarbeit_lma.employees.Person;
import ch.bzz.m326_projektarbeit_lma.facade.PersonFacade;
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
 * @Since 22.06.2022
 * @Version 1.4
 */
public class Uebersicht_View extends JFrame {

    JPanel mainPanel;
    JLabel uebersicht;
    JPanel detailPanel;
    JPanel overviewPanel;
    JList<Person> nameList;
    JScrollPane scrollPane;
    TitledBorder title1;
    TitledBorder title2;
    JLabel nameLabel;
    JTextField nameTextField;
    JPanel uebersichtPanel;
    JPanel abteilungPanel;
    JLabel abteilungLabel1;
    JTextField abteilungTextField;
    JPanel bottomPanel;
    JPanel sortierungPanel;
    TitledBorder title3;
    JPanel sortierungAuswahl;
    JRadioButton radioButton1;
    JRadioButton radioButton2;
    JRadioButton radioButton3;
    ButtonGroup group;
    JLabel keine;
    JLabel az;
    JLabel za;
    JPanel filterPanel;
    TitledBorder title4;
    JPanel filterAuswahl;
    JLabel abteilungLabel;
    JLabel funktionLabel;
    JLabel teamLabel;
    JComboBox<Department> abteilungCombobox;
    JComboBox<String> funktionCombobox;
    JComboBox<String> teamCombobox;
    JPanel namePanel;
    JLabel imageLabel;
    JPanel scrollPanel;
    JScrollPane scrollPane2;
    JScrollPane scrollPane3;

    /**
     * An empty constructor
     */
    public Uebersicht_View(){
       //empty
    }

    /**
     * The createView method which holds all the components
     * @return mainPanel
     */
    public JPanel createView() {

        //The main panels used with a JLabel
        mainPanel = new JPanel();
        uebersicht = new JLabel("Übersicht:");
        detailPanel = new JPanel();
        detailPanel.setLayout(new BoxLayout(detailPanel,BoxLayout.PAGE_AXIS));
        uebersichtPanel = new JPanel();

        //Adds data into a list
        nameList = new JList<>(new PersonListModel());
        nameList.setLayoutOrientation(JList.VERTICAL);

        //Creates the scrollpane
        scrollPane = new JScrollPane(nameList);
        scrollPane.setPreferredSize(new Dimension(150,200));
        scrollPane.setVerticalScrollBarPolicy(22); //Always on
        scrollPane.setHorizontalScrollBarPolicy(31); //Never
        uebersichtPanel.add(uebersicht);
        uebersichtPanel.add(scrollPane);
        mainPanel.add(uebersichtPanel);

        //Creates the titled border
        title1 = BorderFactory.createTitledBorder("Person:");
        mainPanel.setBorder(title1);
        title2 = BorderFactory.createTitledBorder("Detail:");
        detailPanel.setBorder(title2);

        //Label and Textfield formatting
        namePanel = new JPanel(new GridLayout(1,2));
        nameLabel = new JLabel("Name:");
        nameTextField = new JTextField("Benak Alexander");
        nameTextField.setEditable(false);
        namePanel.add(nameLabel);
        namePanel.add(nameTextField);
        detailPanel.add(namePanel);

        //Creates the image
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("img.png")));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        imageLabel = new JLabel(imageIcon);
        detailPanel.add(imageLabel);

        //Label and Textfield formatting
        abteilungPanel = new JPanel(new GridLayout(1,2));
        abteilungLabel1 = new JLabel("Abteilung:");
        abteilungTextField = new JTextField("Finance");
        abteilungTextField.setEditable(false);
        abteilungPanel.add(abteilungLabel1);
        abteilungPanel.add(abteilungTextField);
        detailPanel.add(abteilungPanel);

        //The panel for the scrollpanes
        scrollPanel = new JPanel(new GridLayout(1,2));

        //First scrollpane of the  panel
        scrollPane2 = new JScrollPane();
        scrollPane2.setPreferredSize(new Dimension(150,200));
        scrollPane2.setVerticalScrollBarPolicy(22); //Always on
        scrollPane2.setHorizontalScrollBarPolicy(31); //Never

        //Second scrollpane of the panel
        scrollPane3 = new JScrollPane();
        scrollPane3.setPreferredSize(new Dimension(150,200));
        scrollPane3.setVerticalScrollBarPolicy(22); //Always on
        scrollPane2.setHorizontalScrollBarPolicy(31); //Never

        //Merge everything together
        scrollPanel.add(scrollPane2);
        scrollPanel.add(scrollPane3);
        detailPanel.add(scrollPanel);

        //Panel which belongs into the south of the borderlayout
        bottomPanel = new JPanel(new GridLayout(1,2));

        //Panel for the "Sortierung"
        sortierungPanel = new JPanel();
        title3 = BorderFactory.createTitledBorder("Sortierung:");
        sortierungPanel.setBorder(title3);

        //All the components of "Sortierung"
        sortierungAuswahl = new JPanel(new GridLayout(3,2));
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        radioButton3 = new JRadioButton();
        group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
        keine = new JLabel("keine");
        az = new JLabel("A-Z");
        za = new JLabel("Z-A");
        sortierungAuswahl.add(keine);
        sortierungAuswahl.add(radioButton1);
        sortierungAuswahl.add(az);
        sortierungAuswahl.add(radioButton2);
        sortierungAuswahl.add(za);
        sortierungAuswahl.add(radioButton3);

        //Add the components to a panel
        sortierungPanel.add(sortierungAuswahl);
        bottomPanel.add(sortierungPanel);

        radioButton1.addActionListener(e -> {new Uebersicht_View();});

        //Panel for "Filter"
        filterPanel = new JPanel();
        title4 = BorderFactory.createTitledBorder("Filter:");
        filterPanel.setBorder(title4);

        //All the components of "Filter"
        filterAuswahl = new JPanel(new GridLayout(3,2));
        abteilungLabel = new JLabel("Abteilung:");
        funktionLabel = new JLabel("Funktion:");
        teamLabel = new JLabel("Team:");
        abteilungCombobox = new JComboBox<>(new DepartmentComboboxModel());
        funktionCombobox = new JComboBox<>(new JobFunctionsComboboxModel());
        teamCombobox = new JComboBox<>(new TeamComboboxModel());
        filterAuswahl.add(abteilungLabel);
        filterAuswahl.add(abteilungCombobox);
        filterAuswahl.add(funktionLabel);
        filterAuswahl.add(funktionCombobox);
        filterAuswahl.add(teamLabel);
        filterAuswahl.add(teamCombobox);

        //Add the components to a panel
        filterPanel.add(filterAuswahl);
        bottomPanel.add(filterPanel);

        //Merge everything together
        mainPanel.add(detailPanel);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);


        radioButton1.addActionListener(e -> {PersonFacade.getInstance().getAllPersonWithFilter("","","","");});
        radioButton2.addActionListener(e -> {PersonFacade.getInstance().getAllPersonWithFilter("","","","A");});
        radioButton3.addActionListener(e -> {PersonFacade.getInstance().getAllPersonWithFilter("","","","D");});

        abteilungCombobox.addActionListener(e -> {
            if (abteilungCombobox.getSelectedItem() != null) {
                PersonFacade.getInstance().getAllPersonWithFilter(((Department) abteilungCombobox.getSelectedItem()).getName(), "", "", "");
            } else {
                PersonFacade.getInstance().getAllPersonWithFilter("", "", "", "");
            }
        });
        funktionCombobox.addActionListener(e -> {
            if (abteilungCombobox.getSelectedItem() != null) {
                PersonFacade.getInstance().getAllPersonWithFilter("",((String) abteilungCombobox.getSelectedItem()), "", "");
            } else {
                PersonFacade.getInstance().getAllPersonWithFilter("", "", "", "");
            }
        });
        funktionCombobox.addActionListener(e -> {
            if (funktionCombobox.getSelectedItem() != null) {
                PersonFacade.getInstance().getAllPersonWithFilter("",((String) funktionCombobox.getSelectedItem()), "", "");
            } else {
                PersonFacade.getInstance().getAllPersonWithFilter("", "", "", "");
            }
        });
        teamCombobox.addActionListener(e -> {
            if (teamCombobox.getSelectedItem() != null) {
                PersonFacade.getInstance().getAllPersonWithFilter("","", ((String) teamCombobox.getSelectedItem()), "");
            } else {
                PersonFacade.getInstance().getAllPersonWithFilter( "" , "", "","");
            }
        });
        return mainPanel;
    }
}
