package ch.bzz.m326_projektarbeit_lma.gui;

import javax.swing.*;
import java.awt.*;

public class Stammdaten_View extends JFrame {

    String names[] = {
            "Benak Alexander","Giuntini Lorenzo", "Hawi Moustafa",
            "Jadyn Esquivel","Alondra Wren","Tara Richter","Roxanna Jack","Laci Barrera",
            "Karina Matheny","Tyson Stringer","Devontae Lombardo","Kailey Wiles","Adrian Swift"
    };

    public Stammdaten_View(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        getContentPane().setLayout(new GridBagLayout());

        JPanel firmaPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;

        JLabel firmaLabel = new JLabel("Firma:");
        JLabel abteilungLabel = new JLabel("Abteilung:");
        JLabel funktionenLabel = new JLabel("Funktionen:");
        JLabel teamsLabel = new JLabel("Teams:");

        JTextField firmaTextField = new JTextField("Firmenname");
        firmaTextField.setEditable(false);

        JList<String> abteilungList = new JList<>(names);

        JScrollPane scrollPane1 = new JScrollPane(abteilungList);
        JScrollPane scrollPane2 = new JScrollPane(abteilungList);
        JScrollPane scrollPane3 = new JScrollPane(abteilungList);

        JButton button1 = new JButton("X");
        JButton button2 = new JButton("X");
        JButton button3 = new JButton("X");
        JPanel buttonPanel = new JPanel(new GridLayout(1,3));
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        ////////////////////////////////////////////////

        firmaPanel.add(firmaLabel);
        firmaPanel.add(firmaTextField);


        getContentPane().add(firmaPanel);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Stammdaten_View();
    }

}
