package ch.bzz.m326_projektarbeit_lma.gui;

import ch.bzz.m326_projektarbeit_lma.company.Department;
import ch.bzz.m326_projektarbeit_lma.facade.DepartmentFacade;
import ch.bzz.m326_projektarbeit_lma.facade.JobFunctionFacade;

import javax.swing.*;
import java.awt.*;

/**
 * @author Moustafa Hawi
 * @since 21.06.2022
 * @version 1.0
 */
public class AddFunctions extends JFrame {
    private JLabel label = new JLabel("Funktion:");
    private JTextField textField = new JTextField("Text eingeben");
    private JButton abbrechenButton = new JButton("Abbrechen");
    private JButton speichernButton = new JButton("Speichern");

    public AddFunctions(int mode, String function){
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

        switch (mode){
            case 0:
                speichernButton.addActionListener(
                        e -> {JobFunctionFacade.getInstance().addFunction(textField.getText());
                            dispose();
                        });
                break;
            case 1:
                speichernButton.addActionListener(
                        e -> {JobFunctionFacade.getInstance().updateFunction(function, textField.getText());
                            dispose();
                        });
                break;
        }

        abbrechenButton.addActionListener(e -> {
            dispose();
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

}

