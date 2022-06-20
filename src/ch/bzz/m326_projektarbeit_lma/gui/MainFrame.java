package ch.bzz.m326_projektarbeit_lma.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class MainFrame extends JFrame {

    Person_View personView = new Person_View();
    Zuordnung_View zuordnungView = new Zuordnung_View();
    Logbuch_View logbuchView = new Logbuch_View();
    Uebersicht_View uebersichtView = new Uebersicht_View();
    Stammdaten_View stammdatenView = new Stammdaten_View();

    public MainFrame(){

        personView.setVisible(false);
        zuordnungView.setVisible(false);
        logbuchView.setVisible(false);
        uebersichtView.setVisible(false);
        stammdatenView.setVisible(false);

        setTitle("I am looking for");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550,550);

        //Panel 1 für die Übersicht
        JPanel panel1 = new JPanel();
        panel1.add(uebersichtView.createView());

        //Panel2 für die Zuordnung
        JPanel panel2 = new JPanel();
        panel2.add(zuordnungView.createView());

        JPanel panel3 = new JPanel();
        panel3.add(personView.createView());

        JPanel panel4 = new JPanel();
        panel4.add(stammdatenView.createView());

        //Panel 5 für das Logbuch
        JPanel panel5 = new JPanel();
        panel5.add(logbuchView.createView());

        //Das Menü
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
        new MainFrame();
    }

}
