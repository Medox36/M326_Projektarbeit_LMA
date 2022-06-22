package ch.bzz.m326_projektarbeit_lma.gui;

import javax.swing.*;
import java.awt.*;

public class AddPerson extends JDialog {
    private JLabel labelName = new JLabel("Name:");
    private JLabel labelFoto = new JLabel("Foto:");
    private JLabel labelHRMitarbeiter = new JLabel("HR-Mitarbeiter:");
    private JLabel labelAdministrator = new JLabel("Administrotor:");
    private CheckboxGroup checkboxGroup = new CheckboxGroup();
    private Checkbox hrMitarbeiter = new Checkbox();
    private Checkbox administrator = new Checkbox();

    public AddPerson (){

    }
}
