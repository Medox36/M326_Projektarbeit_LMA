package ch.bzz.m326_projektarbeit_lma.gui;

import ch.bzz.m326_projektarbeit_lma.company.Department;
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
    JPanel mainPanel;
    JPanel panelBorder;
    JLabel label;
    JList<?> abteilungsListe;
    JButton addButton;
    JButton editButton;
    JButton deleteButton;
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
        mainPanel = new JPanel(new GridLayout(1, 1, 0, 500));
        panelBorder = new JPanel(new BorderLayout());
        label = new JLabel(name);

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

        addButton = new JButton("+");
        deleteButton = new JButton("X");
        editButton = new JButton("/");

        buttonPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        scrollPane = new JScrollPane(abteilungsListe, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);

        mainPanel.add(label);
        mainPanel.add(panelBorder);

        panelBorder.add(scrollPane, BorderLayout.CENTER);
        panelBorder.add(buttonPanel, BorderLayout.SOUTH);

        stammDatenPanel.add(mainPanel);

        switch (modelType) {
            case 0:
                addButton.addActionListener(e -> {new AddDepartment(0, (Department) abteilungsListe.getSelectedValue());});
                break;
            case 1:
                addButton.addActionListener(e -> {new AddFunctions(0, (String) abteilungsListe.getSelectedValue());});
                break;
            case 2:
                addButton.addActionListener(e -> {new AddTeam(0, (String) abteilungsListe.getSelectedValue());});
                break;
            default:
                // default should never occur
                addButton.addActionListener(e -> {new Stammdaten_View();});
        }
        switch (modelType) {
            case 0:
                editButton.addActionListener(e -> {new AddDepartment(1, (Department) abteilungsListe.getSelectedValue());});
                break;
            case 1:
                editButton.addActionListener(e -> {new AddFunctions(1, (String) abteilungsListe.getSelectedValue());});
                break;
            case 2:
                editButton.addActionListener(e -> {new AddTeam(1, (String) abteilungsListe.getSelectedValue());});
                break;
            default:
                // default should never occur
                editButton.addActionListener(e -> {new Stammdaten_View();});
        }
        switch (modelType) {
            case 0:
                deleteButton.addActionListener(e -> {
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
                addButton.addActionListener(e -> {new Stammdaten_View();});
        }
    }
}
