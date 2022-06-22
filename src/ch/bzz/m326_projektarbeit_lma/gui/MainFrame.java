package ch.bzz.m326_projektarbeit_lma.gui;

import ch.bzz.m326_projektarbeit_lma.facade.PersonFacade;

import javax.swing.*;

/**
 * This class adds all the components into a JTabbedPane and formats it
 *
 * @author  Alexander Benak, Moustafa Hawi, Lorenzo Giuntini (Medox36)
 * @since  21.06.2022
 * @version  1.1
 */
public class MainFrame extends JFrame {

    /**
     * constructor
     */
    public MainFrame(){
        setTitle("I am looking for");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,700);

        //Das Menü
        JTabbedPane navbar = new JTabbedPane();
        navbar.add("Übersicht", new Uebersicht_View().createView());
        navbar.add("Zuordnung", new Zuordnung_View());
        navbar.add("Personen", new Person_View());
        navbar.add("Stammdaten", new Stammdaten_View());
        navbar.add("Logbuch", new Logbuch_View());

        navbar.addChangeListener(e -> {
            if (!PersonFacade.getInstance().isAHRPersonLoggedIn()) {
                if (((JTabbedPane) e.getSource()).getSelectedIndex() != 0) {
                    int newTabIndex = navbar.getSelectedIndex();
                    navbar.setSelectedIndex(0);
                    new LoginGUI(this, navbar, newTabIndex);
                }
            }
        });

        getContentPane().add(navbar);

        setLocationRelativeTo(null);
        setVisible(true);

    }

}
