package ch.bzz.m326_projektarbeit_lma.gui;

import ch.bzz.m326_projektarbeit_lma.facade.PersonFacade;
import ch.bzz.m326_projektarbeit_lma.gui.model.PersonListModel;
import ch.bzz.m326_projektarbeit_lma.employees.Person;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class MainFrame extends JFrame {

    public MainFrame(){

        setTitle("I am looking for");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,700);

        //Panel 1 für die Übersicht
        JPanel panel1 = new JPanel();

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
        panel1.add(overviewPanel);

        TitledBorder title1 = BorderFactory.createTitledBorder("Person:");
        panel1.setBorder(title1);

        TitledBorder title2 = BorderFactory.createTitledBorder("Detail:");
        detailPanel.setBorder(title2);
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameTextField = new JTextField("Benak Alexander");
        nameTextField.setEditable(false);
        detailPanel.add(nameLabel);
        detailPanel.add(nameTextField);
        panel1.add(detailPanel);

        //Panel2 für die Zuordnung
        JPanel panel2 = new JPanel();

        JLabel testLabel = new JLabel("TEXT");
        panel2.add(testLabel);

        JPanel panel3 = new JPanel();
        //TODO

        JPanel panel4 = new JPanel();
        //TODO

        //Panel 5 für das Logbuch
        JPanel panel5 = new JPanel();
        JTextArea logText = new JTextArea(Logbuch_View.testText);
        logText.setLineWrap(true);
        logText.setEditable(false);

        JScrollPane logBookScrollpane = new JScrollPane(logText);
        logBookScrollpane.setPreferredSize(new Dimension(580,6800));
        logBookScrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        panel5.add(logBookScrollpane);

        //Das Menü
        JTabbedPane navbar = new JTabbedPane();
        navbar.add("Übersicht",panel1);
        navbar.add("Zuordnung",panel2);
        navbar.add("Personen",panel3);
        navbar.add("Stammdaten",panel4);
        navbar.add("Logbuch",panel5);

        navbar.addChangeListener(e -> {
            if (!PersonFacade.getInstance().isAHRPersonLoggedIn()) {
                new LoginGUI(this, navbar);
            }
        });

        getContentPane().add(navbar);

        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new MainFrame();
    }

}
