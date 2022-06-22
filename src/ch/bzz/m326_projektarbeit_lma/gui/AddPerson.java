package ch.bzz.m326_projektarbeit_lma.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Moustafa Hawi
 * @since 21.06.2022
 * @version 1.0
 */
public class AddPerson extends JDialog {
    private JLabel labelName = new JLabel("Name:");
    private JTextField textFieldName = new JTextField("Vorname Nachname");
    private JLabel labelFoto = new JLabel("Foto:");
    private JLabel labelHRMitarbeiter = new JLabel("HR-Mitarbeiter:");
    private JLabel labelAdministrator = new JLabel("Administrotor:");
    private CheckboxGroup checkboxGroup = new CheckboxGroup();
    private Checkbox hrMitarbeiter = new Checkbox();
    private Checkbox administrator = new Checkbox();
    private ImageIcon icon = new ImageIcon("img.png");
    private JButton abbrechenButton = new JButton("Abbrechen");
    private JButton speichernButton = new JButton("Speichern");

    public AddPerson (){
        setTitle("Person erfassen");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true);
        setSize(250,200);

        checkboxGroup.setSelectedCheckbox(hrMitarbeiter);
        checkboxGroup.setSelectedCheckbox(administrator);

        JPanel obenGridPanel = new JPanel(new GridLayout(1,2,5,5));
        obenGridPanel.add(labelName);
        obenGridPanel.add(textFieldName);
        JPanel mitteGridPanel = new JPanel(new GridLayout(4,2,5,5));
        mitteGridPanel.add(labelFoto);
        mitteGridPanel.add(new JLabel(icon));
        mitteGridPanel.add(labelHRMitarbeiter);
        mitteGridPanel.add(hrMitarbeiter);
        mitteGridPanel.add(labelAdministrator);
        mitteGridPanel.add(administrator);
        JPanel untenGridPanel = new JPanel(new GridLayout(1,2,5,5));
        untenGridPanel.add(abbrechenButton);
        untenGridPanel.add(speichernButton);
        JPanel mainPanel = new JPanel(new BorderLayout(5,5));
        mainPanel.add(obenGridPanel, BorderLayout.NORTH);
        mainPanel.add(mitteGridPanel, BorderLayout.CENTER);
        mainPanel.add(untenGridPanel, BorderLayout.SOUTH);
        JPanel bigPanel = new JPanel(new BorderLayout(5,5));
        bigPanel.add(mainPanel, BorderLayout.CENTER);

        getContentPane().add(bigPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
