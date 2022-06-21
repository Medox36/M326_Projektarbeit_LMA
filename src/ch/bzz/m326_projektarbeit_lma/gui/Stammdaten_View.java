package ch.bzz.m326_projektarbeit_lma.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Unsere Stammdaten-GUI für das Programm
 */
public class Stammdaten_View extends JPanel {

    String sampleList[] = {
            "Beispiel", "Beispiel", "Beispiel", "Beispiel", "Beispiel"
    };

    /**
     * Komponenten für das StammdatenPanel
     */
    private JPanel stammDatenPanel;

    public Stammdaten_View() {
        stammDatenPanel = new JPanel();
        stammDatenPanel.setPreferredSize(new Dimension(550,500));
        stammDatenPanel.setMaximumSize(new Dimension(550,500));

        stammDatenPanel = new JPanel(new GridLayout(4,1, 50,20));
        SpringLayout springLayout = new SpringLayout();
        JLabel firma = new JLabel("Firma:");
        JTextField firmaField = new JTextField("Text eingeben");
        JPanel firmaPanel = new JPanel();
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

        add(stammDatenPanel);
    }

    public void createComponent(String name) {
        JPanel abteilungsPanel = new JPanel(new GridLayout(1, 1, 0, 500));
        JPanel abteilungsPanelBorder = new JPanel(new BorderLayout());
        JLabel abteilung = new JLabel(name);
        JList<String> abteilungsListe = new JList(sampleList);

        JButton addAbteilung = new JButton("+");
        JButton deleteAbteilung = new JButton("X");
        JButton abteilungBearbeiten = new JButton("/");

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        JScrollPane scrollPane = new JScrollPane(abteilungsListe, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        buttonPanel.add(addAbteilung);
        buttonPanel.add(deleteAbteilung);
        buttonPanel.add(abteilungBearbeiten);

        abteilungsPanel.add(abteilung);
        abteilungsPanel.add(abteilungsPanelBorder);

        abteilungsPanelBorder.add(scrollPane, BorderLayout.CENTER);
        abteilungsPanelBorder.add(buttonPanel, BorderLayout.SOUTH);

        stammDatenPanel.add(abteilungsPanel);
    }
}


