package ch.bzz.m326_projektarbeit_lma.gui;

import ch.bzz.m326_projektarbeit_lma.facade.DepartmentFacade;
import ch.bzz.m326_projektarbeit_lma.facade.TeamFacade;

import javax.swing.*;
import java.awt.*;

public class AddTeam extends JFrame {
    private JLabel label = new JLabel("Team");
    private JTextField textField = new JTextField("Text eingeben");
    private JButton abbrechenButton = new JButton("Abbrechen");
    private JButton speichernButton = new JButton("Speichern");

    public AddTeam(){
        setTitle("Funktion erfassen/bearbeiten");
        setSize(200,100);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(5,5));

        JPanel upPanelGrid = new JPanel(new GridLayout(1,2,5,5));
        JPanel downPanelGrid = new JPanel(new GridLayout(1,2,5,5));
        JPanel mainPanel = new JPanel(new BorderLayout(5,5));
        JPanel bigPanel = new JPanel(new BorderLayout(5,5));

        upPanelGrid.add(label);
        upPanelGrid.add(textField);
        downPanelGrid.add(abbrechenButton);
        downPanelGrid.add(speichernButton);
        mainPanel.add(upPanelGrid, BorderLayout.NORTH);
        mainPanel.add(downPanelGrid, BorderLayout.SOUTH);
        bigPanel.add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(bigPanel, BorderLayout.CENTER);

        speichernButton.addActionListener(
                e -> {
                    TeamFacade.getInstance().addTeam(textField.getText());
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                });

        abbrechenButton.addActionListener(e -> {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
