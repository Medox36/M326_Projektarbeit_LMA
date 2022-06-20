package ch.bzz.m326_projektarbeit_lma.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

/**
 * Unsere Stammdaten-GUI für das Programm
 */
public class StammdatenTest extends JFrame {

    /**
     * Komponenten für das StammdatenPanel
     */
    private JTabbedPane pane;
    private JPanel stammDatenPanel;
    private JPanel firmaPanel;
    private JLabel firma;
    private JTextField firmaField;
    private SpringLayout springLayout;

    private JPanel abteilungsPanel;
    private JPanel abteilungsPanelBorder;
    private JLabel abteilung;
    private JList<String> abteilungsListe;
    private JButton abteilungAdden;
    private JButton abteilungBearbeiten;
    private JButton abteilungLöschen;
    private JScrollPane abteilungScrollPane;
    private ArrayList<String> texts;
    private JPanel abteilungsButton;

    public StammdatenTest(){

        stammDatenPanel = new JPanel(new GridLayout(4,1, 50,20));
        springLayout = new SpringLayout();
        firma = new JLabel("Firma:");
        firmaField = new JTextField("Text eingeben");
        firmaPanel = new JPanel();
        firmaPanel.setLayout(springLayout);

        springLayout.putConstraint(SpringLayout.WEST, firma,5, SpringLayout.WEST, firmaPanel);
        springLayout.putConstraint(SpringLayout.NORTH, firma,50, SpringLayout.NORTH, firmaPanel);
        springLayout.putConstraint(SpringLayout.WEST, firmaField, 250, SpringLayout.EAST, firma);
        springLayout.putConstraint(SpringLayout.NORTH, firmaField, 50, SpringLayout.NORTH, firmaPanel);

        firmaField.setColumns(30);
        firmaPanel.add(firma);
        firmaPanel.add(firmaField);

        firmaPanel.add(new JLabel());
        firmaPanel.add(new JLabel());
        firmaPanel.add(new JLabel());
        firmaPanel.add(new JLabel());

        stammDatenPanel.add(firmaPanel);
        createStammdatenComponent("Abteilungen");
        createStammdatenComponent("Funktionen");
        createStammdatenComponent("Teams");

        getContentPane().add(stammDatenPanel);

        setVisible(true);

    }

    public static void main(String[] args) {
        new StammdatenTest();
    }

    public void createStammdatenComponent(String name){

        abteilungsPanel = new JPanel(new GridLayout(1,1, 0, 500));
        abteilungsPanelBorder = new JPanel(new BorderLayout());
        texts = new ArrayList<>();
        texts.add("text");
        texts.add("text");
        texts.add("text");
        abteilung = new JLabel(name+": ");
        abteilungsListe = new JList(texts.toArray());

        abteilungAdden = new JButton("New");

        abteilungLöschen = new JButton("Delete");

        abteilungBearbeiten = new JButton("Edit");

        abteilungsButton = new JPanel(new GridLayout(1,3,5,5));
        abteilungScrollPane = new JScrollPane(abteilungsListe, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        abteilungsButton.add(abteilungAdden);
        abteilungsButton.add(abteilungLöschen);
        abteilungsButton.add(abteilungBearbeiten);

        abteilungsPanel.add(abteilung);
        abteilungsPanel.add(abteilungsPanelBorder);

        abteilungsPanelBorder.add(abteilungScrollPane, BorderLayout.CENTER);
        abteilungsPanelBorder.add(abteilungsButton, BorderLayout.SOUTH);


        stammDatenPanel.add(abteilungsPanel);

    }
}


