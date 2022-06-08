package ch.bzz.m326_projektarbeit_lma.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LoginGUI extends JFrame {
    JLabel nameLabel = new JLabel("Name:");
    JLabel codeLabel = new JLabel("Code:");
    String comboBoxListe[] = {"Person wählen","Muster Max", "Trulli Theo", "Arpagaus Carla", "Rodriguez Joe", "Radic Illia", "Moro Valeria", "Müller Petra","Grifith Malcom", "Marchese Luigi", "Bolgar Beda", "Rast Anna" };
    JComboBox nameCombox = new JComboBox(comboBoxListe);
    JTextField codeField = new JTextField("Code eingeben");
    JButton abbrechenButton = new JButton("Abbrchen");
    JButton weiterButton = new JButton("Weiter");

    //Konstruktor
    public LoginGUI(){
        //frame einstellen
        setTitle("Authentifizierung");
        setSize(350, 170);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(5,5));
        //Panels erstelln inkl. Layouts
        JPanel loginPanel = new JPanel(new GridLayout(2,2,5,5));
        JPanel downPanel = new JPanel(new GridLayout(1,2,5,5));
        JPanel mainPanel = new JPanel(new BorderLayout(5,5));
        //zusammenbauen
        loginPanel.add(nameLabel);
        loginPanel.add(nameCombox);
        loginPanel.add(codeLabel);
        loginPanel.add(codeField);
        downPanel.add(abbrechenButton);
        downPanel.add(weiterButton);
        mainPanel.add(loginPanel, BorderLayout.NORTH);
        mainPanel.add(downPanel, BorderLayout.SOUTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        //Sichtbarkeit
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginGUI();
    }
}
