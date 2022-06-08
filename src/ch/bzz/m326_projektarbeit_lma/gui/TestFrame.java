package ch.bzz.m326_projektarbeit_lma.gui;

import ch.bzz.m326_projektarbeit_lma.employees.Person;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class TestFrame extends JFrame {

    public TestFrame(){

        setTitle("I am looking for");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,700);

        //Panel 1 für die Übersicht
        JPanel panel1 = new JPanel();

        JLabel uebersicht = new JLabel("Übersicht:");
        JPanel detailPanel = new JPanel();
        JPanel overviewPanel = new JPanel();

        String names[] = {
                "Benak Alexander","Giuntini Lorenzo", "Hawi Moustafa",
                "Jadyn Esquivel","Alondra Wren","Tara Richter","Roxanna Jack","Laci Barrera",
                "Karina Matheny","Tyson Stringer","Devontae Lombardo","Kailey Wiles","Adrian Swift"
        };

        JList nameList = new JList(names);
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


        //Panel2 für die Zuordnung
        JPanel panel2 = new JPanel();

        JLabel testLabel = new JLabel("TEXT");
        panel2.add(testLabel);

        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        JTabbedPane navbar = new JTabbedPane();
        navbar.add("Übersicht",panel1);
        navbar.add("Zuordnung",panel2);
        navbar.add("Personen",panel3);
        navbar.add("Stammdaten",panel4);
        navbar.add("Logbuch",panel5);

        getContentPane().add(navbar);

        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new TestFrame();
    }

}
