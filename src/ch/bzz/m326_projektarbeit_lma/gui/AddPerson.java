package ch.bzz.m326_projektarbeit_lma.gui;

import javax.swing.*;
import java.awt.*;

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

    public AddPerson (){
        setTitle("Person erfassen");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true);
        setSize(250,120);

        JPanel obenGridPanel = new JPanel(new GridLayout(2,2,5,5));
        obenGridPanel.add(labelName);
        obenGridPanel.add(textFieldName);
        obenGridPanel.add(labelFoto);
        obenGridPanel.add(new JLabel(icon));
        JPanel mitteGridPanel = new JPanel(new GridLayout(2,2,5,5));
        JPanel untenGridPanel = new JPanel(new GridLayout(2,1,5,5));
        JPanel mainPanel = new JPanel(new BorderLayout(5,5));
        JPanel bigPanel = new JPanel(new BorderLayout(5,5));

    }
}
