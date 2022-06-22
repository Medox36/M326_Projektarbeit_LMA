package ch.bzz.m326_projektarbeit_lma.gui;

import ch.bzz.m326_projektarbeit_lma.company.Department;
import ch.bzz.m326_projektarbeit_lma.facade.CompanyFacade;
import ch.bzz.m326_projektarbeit_lma.facade.DepartmentFacade;
import ch.bzz.m326_projektarbeit_lma.facade.JobFunctionFacade;
import ch.bzz.m326_projektarbeit_lma.facade.TeamFacade;
import ch.bzz.m326_projektarbeit_lma.gui.model.DepartmentListModel;
import ch.bzz.m326_projektarbeit_lma.gui.model.JobFunctionsListModel;
import ch.bzz.m326_projektarbeit_lma.gui.model.TeamListModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

/**
 * The base data
 *
 * @author  Alexander Benak, Moustafa Hawi, Lorenzo Giuntini (Medox36)
 * @since  22.06.2022
 * @version  1.5
 */
public class Stammdaten_View extends JPanel {
    private JPanel stammDatenPanel;

    /**
     * The constructor holding all the components
     */
    public Stammdaten_View() {
        stammDatenPanel = new JPanel();
        stammDatenPanel.setPreferredSize(new Dimension(550,500));
        stammDatenPanel.setMaximumSize(new Dimension(550,500));
        stammDatenPanel = new JPanel(new GridLayout(4,1, 50,20));
        SpringLayout springLayout = new SpringLayout();
        JLabel firma = new JLabel("Firma:");
        JTextField firmaField = new JTextField(CompanyFacade.getInstance().getCompanyName());
        JPanel firmaPanel = new JPanel();
        firmaPanel.setLayout(springLayout);
        springLayout.putConstraint(SpringLayout.WEST, firma,5, SpringLayout.WEST, firmaPanel);
        springLayout.putConstraint(SpringLayout.NORTH, firma,50, SpringLayout.NORTH, firmaPanel);
        springLayout.putConstraint(SpringLayout.WEST, firmaField, 170, SpringLayout.WEST, firma);
        springLayout.putConstraint(SpringLayout.NORTH, firmaField, 50, SpringLayout.NORTH, firmaPanel);
        firmaField.setColumns(18);
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

        CompanyFacade.getInstance().setCompanyNameField(firmaField);

        firmaField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    CompanyFacade.getInstance().setCompanyName(firmaField.getText());
                    System.out.println("works typed");
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    firmaField.setText(CompanyFacade.getInstance().getCompanyName());
                }
            }
        });

        firmaField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                firmaField.setText(CompanyFacade.getInstance().getCompanyName());
            }
        });
    }

    /**
     * The create component method that creates the scrollpanes and buttons
     *
     * @param name of the label belonging to the JList
     * @param modelType of the component
     */
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
                abteilungBearbeiten.addActionListener(e -> {new AddDepartment(1, (Department) abteilungsListe.getSelectedValue());});
                break;
            case 1:
                abteilungBearbeiten.addActionListener(e -> {new AddFunctions(1, (String) abteilungsListe.getSelectedValue());});
                break;
            case 2:
                abteilungBearbeiten.addActionListener(e -> {new AddTeam(1, (String) abteilungsListe.getSelectedValue());});
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
                deleteAbteilung.addActionListener(e -> {
                    JobFunctionFacade.getInstance().removeFunction((String) abteilungsListe.getSelectedValue());
                });
                break;
            case 2:
                deleteAbteilung.addActionListener(e -> {
                    TeamFacade.getInstance().removeTeam((String) abteilungsListe.getSelectedValue());
                });
                break;
            default:
                // default should never occur
                addAbteilung.addActionListener(e -> {new Stammdaten_View();});
        }
    }
}
