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
 * The base data
 * @Author Alexander Benak, Moustafa Hawi, Lorenzo Giuntini
 * @Since 22.06.2022
 * @Version 1.5
 */
public class Stammdaten_View extends JPanel {
    private JPanel stammDatenPanel;
    SpringLayout springLayout;
    JLabel firma;
    JTextField firmaField;
    JPanel firmaPanel;
    JPanel abteilungsPanel;
    JPanel abteilungsPanelBorder;
    JLabel abteilung;
    JList<?> abteilungsListe;
    JButton addAbteilung;
    JButton editAbteilung;
    JButton deleteAbteilung;
    JPanel buttonPanel;
    JScrollPane scrollPane;

    /**
     * The constructor holding all the components
     */
    public Stammdaten_View() {
        stammDatenPanel = new JPanel();
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
        createComponent("Abteilungen:", 0);
        createComponent("Funktionen:", 1);
        createComponent("Teams:", 2);

        add(stammDatenPanel);
    }

    /**
     * The create component method that creates the scrollpanes and buttons
     * @param name
     * @param modelType
     */
    public void createComponent(String name, int modelType) {
        abteilungsPanel = new JPanel(new GridLayout(1, 1, 0, 500));
        abteilungsPanelBorder = new JPanel(new BorderLayout());
        abteilung = new JLabel(name);

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

        addAbteilung = new JButton("+");
        deleteAbteilung = new JButton("X");
        editAbteilung = new JButton("/");

        buttonPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        scrollPane = new JScrollPane(abteilungsListe, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        buttonPanel.add(addAbteilung);
        buttonPanel.add(deleteAbteilung);
        buttonPanel.add(editAbteilung);

        abteilungsPanel.add(abteilung);
        abteilungsPanel.add(abteilungsPanelBorder);

        abteilungsPanelBorder.add(scrollPane, BorderLayout.CENTER);
        abteilungsPanelBorder.add(buttonPanel, BorderLayout.SOUTH);

        stammDatenPanel.add(abteilungsPanel);

        switch (modelType) {
            case 0:
                addAbteilung.addActionListener(e -> {new AddDepartment(0, (Department) abteilungsListe.getSelectedValue());});
                break;
            case 1:
                addAbteilung.addActionListener(e -> {new AddFunctions(0, (String) abteilungsListe.getSelectedValue());});
                break;
            case 2:
                addAbteilung.addActionListener(e -> {new AddTeam(0, (String) abteilungsListe.getSelectedValue());});
                break;
            default:
                // default should never occur
                addAbteilung.addActionListener(e -> {new Stammdaten_View();});
        }
        switch (modelType) {
            case 0:
                editAbteilung.addActionListener(e -> {new AddDepartment(1, (Department) abteilungsListe.getSelectedValue());});
                break;
            case 1:
                editAbteilung.addActionListener(e -> {new AddFunctions(1, (String) abteilungsListe.getSelectedValue());});
                break;
            case 2:
                editAbteilung.addActionListener(e -> {new AddTeam(1, (String) abteilungsListe.getSelectedValue());});
                break;
            default:
                // default should never occur
                editAbteilung.addActionListener(e -> {new Stammdaten_View();});
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
