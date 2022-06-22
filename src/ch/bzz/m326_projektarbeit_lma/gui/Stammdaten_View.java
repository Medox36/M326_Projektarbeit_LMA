package ch.bzz.m326_projektarbeit_lma.gui;

import ch.bzz.m326_projektarbeit_lma.company.Department;
import ch.bzz.m326_projektarbeit_lma.company.JobFunctions;
import ch.bzz.m326_projektarbeit_lma.facade.DepartmentFacade;
import ch.bzz.m326_projektarbeit_lma.facade.JobFunctionFacade;
import ch.bzz.m326_projektarbeit_lma.facade.TeamFacade;
import ch.bzz.m326_projektarbeit_lma.gui.model.DepartmentListModel;
import ch.bzz.m326_projektarbeit_lma.gui.model.JobFunctionsListModel;
import ch.bzz.m326_projektarbeit_lma.gui.model.TeamListModel;

import javax.swing.*;
import java.awt.*;

/**
 * Unsere Stammdaten-GUI für das Programm
 */
public class Stammdaten_View extends JPanel {

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
        createComponent("Abteilungen:", 0);
        createComponent("Funktionen:", 1);
        createComponent("Teams:", 2);

        add(stammDatenPanel);
    }

    public void createComponent(String name, int modelType) {
        JPanel abteilungsPanel = new JPanel(new GridLayout(1, 1, 0, 500));
        JPanel abteilungsPanelBorder = new JPanel(new BorderLayout());
        JLabel abteilung = new JLabel(name);
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

        switch (modelType) {
            case 0:
                addAbteilung.addActionListener(e -> {new AddDepartment();});
                break;
            case 1:
                addAbteilung.addActionListener(e -> {new AddFunctions();});
                break;
            case 2:
                addAbteilung.addActionListener(e -> {new AddTeam();});
                break;
            default:
                // default should never occur
                addAbteilung.addActionListener(e -> {new Stammdaten_View();});
        }
        switch (modelType) {
            case 0:
                abteilungBearbeiten.addActionListener(e -> {new AddDepartment();});
                break;
            case 1:
                abteilungBearbeiten.addActionListener(e -> {new AddFunctions();});
                break;
            case 2:
                abteilungBearbeiten.addActionListener(e -> {new AddTeam();});
                break;
            default:
                // default should never occur
                abteilungBearbeiten.addActionListener(e -> {new Stammdaten_View();});
        }
        switch (modelType) {
            case 0:
                deleteAbteilung.addActionListener(e -> {
                    DepartmentFacade.getInstance().removeDepartment((Department) abteilungsListe.getSelectedValue());
                });
                break;
            case 1:
                JobFunctionFacade.getInstance().removeFunction((String) abteilungsListe.getSelectedValue());
                break;
            case 2:
                TeamFacade.getInstance().removeTeam((String) abteilungsListe.getSelectedValue());
                break;
            default:
                // default should never occur
                addAbteilung.addActionListener(e -> {new Stammdaten_View();});
        }
    }
}
