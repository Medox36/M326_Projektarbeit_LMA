package ch.bzz.m326_projektarbeit_lma.gui;

import ch.bzz.m326_projektarbeit_lma.facade.DepartmentFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFunctions extends JDialog {
    private JLabel label = new JLabel("Abteilung");
    private JTextField textField = new JTextField("Text eingeben");
    private JButton abbrechenButton = new JButton("Abbrechen");
    private JButton speichernButton = new JButton("Speichern");

    public AddFunctions(){
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


        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddFunctions();
    }
    public class ActionAddListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            DepartmentFacade.getInstance().addDepartment();
        }
    }
}
