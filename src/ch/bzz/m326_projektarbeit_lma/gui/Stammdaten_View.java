package ch.bzz.m326_projektarbeit_lma.gui;

import ch.bzz.m326_projektarbeit_lma.gui.model.DepartmentListModel;
import ch.bzz.m326_projektarbeit_lma.gui.model.JobFunctionsListModel;
import ch.bzz.m326_projektarbeit_lma.gui.model.TeamListModel;

import javax.swing.*;
import java.awt.*;

/**
 * Unsere Stammdaten-GUI für das Programm
 */
public class Stammdaten_View extends JFrame {

    /**
     * Komponenten für das StammdatenPanel
     */
    private JPanel stammDatenPanel;
    private JPanel firmaPanel;
    private JLabel firma;
    private JTextField firmaField;
    private SpringLayout springLayout;
    private JPanel scrollPanePanel;
    private JPanel scrollPaneBorder;
    private JLabel abteilung;
    private JList<String> abteilungsListe;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JScrollPane scrollPane;
    private JPanel buttonPanel;

    public Stammdaten_View() {
        //empty
    }

    public void createComponent(String name, int modelType) {

        //The panels for the scrollpanes
        scrollPanePanel = new JPanel(new GridLayout(1, 1, 0, 500));
        scrollPaneBorder = new JPanel(new BorderLayout());

        //Adds a label before the scrollpane
        abteilung = new JLabel(name);

        //Data for the scrollpanes
        JList<?> abteilungsListe;

        switch (modelType) {
            case 0:
                abteilungsListe = new JList<>(new DepartmentListModel());
                break;
            case 1:
                abteilungsListe = new JList<>(new JobFunctionsListModel());
                break;
            case 2:
                abteilungsListe = new JList<>(new TeamListModel());
                break;
            default:
                // default should never occur
                abteilungsListe = new JList<>(new DefaultListModel<>());
        }

        //The buttons below the scrollpanes
        addButton = new JButton("+");
        deleteButton = new JButton("X");
        editButton = new JButton("/");

        //The buttonPanel and scrollpane
        buttonPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        scrollPane = new JScrollPane(abteilungsListe, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        //Add the buttons to a panel
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);

        //Add things to the scrollPanePanel
        scrollPanePanel.add(abteilung);
        scrollPanePanel.add(scrollPaneBorder);

        //Adding and formatting the scrollPaneBorder
        scrollPaneBorder.add(scrollPane, BorderLayout.CENTER);
        scrollPaneBorder.add(buttonPanel, BorderLayout.SOUTH);

        //Merge everything
        stammDatenPanel.add(scrollPanePanel);
    }

    public JPanel createView(){

        //The main panels
        stammDatenPanel = new JPanel(new GridLayout(4,1, 50,20));
        springLayout = new SpringLayout();

        //A label and its respective textfield
        firma = new JLabel("Firma:");
        firmaField = new JTextField("Text eingeben");

        //A new panel for the label and textfield above
        firmaPanel = new JPanel();
        firmaPanel.setLayout(springLayout);

        //Formatting of the springlayout
        springLayout.putConstraint(SpringLayout.WEST, firma,5, SpringLayout.WEST, firmaPanel);
        springLayout.putConstraint(SpringLayout.NORTH, firma,50, SpringLayout.NORTH, firmaPanel);
        springLayout.putConstraint(SpringLayout.WEST, firmaField, 250, SpringLayout.EAST, firma);
        springLayout.putConstraint(SpringLayout.NORTH, firmaField, 50, SpringLayout.NORTH, firmaPanel);

        //Formatting of the firmaPanel and firmaField
        firmaField.setColumns(30);
        firmaPanel.add(firma);
        firmaPanel.add(firmaField);

        //Adding empty Labels to the firmaPanel for spacing
        firmaPanel.add(new JLabel());
        firmaPanel.add(new JLabel());
        firmaPanel.add(new JLabel());
        firmaPanel.add(new JLabel());

        //Add it to the main Panel
        stammDatenPanel.add(firmaPanel);

        //Call the createComponent method to create 3 scrollpanes
        createComponent("Abteilungen:",0);
        createComponent("Funktionen:",1);
        createComponent("Teams:",2);

        return stammDatenPanel;

    }
}
