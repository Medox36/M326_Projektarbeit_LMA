package ch.bzz.m326_projektarbeit_lma.gui;

import ch.bzz.m326_projektarbeit_lma.facade.PersonFacade;
import ch.bzz.m326_projektarbeit_lma.gui.model.PersonListModel;
import ch.bzz.m326_projektarbeit_lma.employees.Person;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MainFrame extends JFrame {

    Uebersicht_View uebersichtView = new Uebersicht_View();
    Zuordnung_View zuordnungView = new Zuordnung_View();
    Person_View personView = new Person_View();
    Stammdaten_View stammdatenView = new Stammdaten_View();
    Logbuch_View logbuchView = new Logbuch_View();

    public MainFrame(){

        uebersichtView.setVisible(false);
        zuordnungView.setVisible(false);
        personView.setVisible(false);
        stammdatenView.setVisible(false);
        logbuchView.setVisible(false);

        setTitle("I am looking for");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,700);

        //Das Menü
        JTabbedPane navbar = new JTabbedPane();
        navbar.add("Übersicht",uebersichtView.createView());
        navbar.add("Zuordnung",zuordnungView.createView());
        navbar.add("Personen",personView.createView());
        navbar.add("Stammdaten",stammdatenView.createView());
        navbar.add("Logbuch",logbuchView.createView());

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
