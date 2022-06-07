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
        getContentPane().setLayout(new BorderLayout(0,0));
        //Panels erstelln inkl. Layouts
        JPanel buttonPanelUp = new JPanel(new GridLayout(1,2,0,0));
        JPanel buttonPaneldown = new JPanel(new GridLayout(1,2,0,0));
        JPanel abbWeiterPanel = new JPanel(new GridLayout(1,2,0,0));
        JPanel mainLoginGUI = new JPanel(new BorderLayout(2,2));
        JPanel bigLoginGUI = new JPanel(new BorderLayout(2,2));
        //zusammenbauen
        buttonPanelUp.add(nameLabel);
        buttonPanelUp.add(nameCombox);
        buttonPaneldown.add(codeLabel);
        buttonPaneldown.add(codeField);
        abbWeiterPanel.add(abbrechenButton);
        abbWeiterPanel.add(weiterButton);
        mainLoginGUI.add(buttonPanelUp, BorderLayout.NORTH);
        mainLoginGUI.add(buttonPaneldown, BorderLayout.SOUTH);
        bigLoginGUI.add(mainLoginGUI, BorderLayout.CENTER);
        bigLoginGUI.add(abbWeiterPanel, BorderLayout.SOUTH);
        getContentPane().add(bigLoginGUI, BorderLayout.CENTER);

        //Sichtbarkeit
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginGUI();
    }
}
