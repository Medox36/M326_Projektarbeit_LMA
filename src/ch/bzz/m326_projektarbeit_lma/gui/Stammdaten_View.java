package ch.bzz.m326_projektarbeit_lma.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Unsere Stammdaten-GUI für das Programm
 */
public class Stammdaten_View extends JFrame {

    String sampleList[] = {
            "Beispiel", "Beispiel", "Beispiel", "Beispiel", "Beispiel"
    };

    /**
     * Komponenten für das StammdatenPanel
     */
    private JPanel stammDatenPanel;
    private JPanel firmaPanel;
    private JLabel firma;
    private JTextField firmaField;
    private SpringLayout springLayout;

    private JPanel abteilungsPanel;
    private JPanel abteilungsPanelBorder;
    private JLabel abteilung;
    private JList<String> abteilungsListe;
    private JButton addAbteilung;
    private JButton abteilungBearbeiten;
    private JButton deleteAbteilung;
    private JScrollPane scrollPane;
    private JPanel buttonPanel;

    public Stammdaten_View(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(550,500));

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
        createComponent("Abteilungen:");
        createComponent("Funktionen:");
        createComponent("Teams:");

        getContentPane().add(stammDatenPanel);

        setVisible(true);

    }

    public static void main(String[] args) {
        new Stammdaten_View();
    }

    public void createComponent(String name){

        abteilungsPanel = new JPanel(new GridLayout(1,1, 0, 500));
        abteilungsPanelBorder = new JPanel(new BorderLayout());
        abteilung = new JLabel(name);
        abteilungsListe = new JList(sampleList);

        addAbteilung = new JButton("+");
        deleteAbteilung = new JButton("X");
        abteilungBearbeiten = new JButton("/");

        buttonPanel = new JPanel(new GridLayout(1,3,5,5));
        scrollPane = new JScrollPane(abteilungsListe, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        buttonPanel.add(addAbteilung);
        buttonPanel.add(deleteAbteilung);
        buttonPanel.add(abteilungBearbeiten);

        abteilungsPanel.add(abteilung);
        abteilungsPanel.add(abteilungsPanelBorder);

        abteilungsPanelBorder.add(scrollPane, BorderLayout.CENTER);
        abteilungsPanelBorder.add(buttonPanel, BorderLayout.SOUTH);

        stammDatenPanel.add(abteilungsPanel);

    }

    public JPanel createView(){

        stammDatenPanel.setPreferredSize(new Dimension(550,500));
        stammDatenPanel.setMaximumSize(new Dimension(550,500));

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
        createComponent("Abteilungen:");
        createComponent("Funktionen:");
        createComponent("Teams:");

        return stammDatenPanel;

    }
}


