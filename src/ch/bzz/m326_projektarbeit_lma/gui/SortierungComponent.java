package ch.bzz.m326_projektarbeit_lma.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class SortierungComponent extends JFrame {

    public SortierungComponent(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);

        JPanel sortierungPanel = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Sortierung:");
        sortierungPanel.setBorder(titledBorder);

        sortierungPanel.setLayout(new GridLayout(3,1));

        JRadioButton r1 = new JRadioButton("keine");
        JRadioButton r2 = new JRadioButton("A-Z");
        JRadioButton r3 = new JRadioButton("Z-A");

        sortierungPanel.add(r1);
        sortierungPanel.add(r2);
        sortierungPanel.add(r3);

        getContentPane().add(sortierungPanel);

        setVisible(true);

    }

    public static void main(String[] args) {
        new SortierungComponent();
    }

}
