package ch.bzz.m326_projektarbeit_lma.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Person_View extends JPanel {

    String names[] = {
            "Benak Alexander","Giuntini Lorenzo", "Hawi Moustafa",
            "Jadyn Esquivel","Alondra Wren","Tara Richter","Roxanna Jack","Laci Barrera",
            "Karina Matheny","Tyson Stringer","Devontae Lombardo","Kailey Wiles","Adrian Swift"
    };

    JPanel mainPanel;
    JPanel subPanel;
    JPanel uebersichtPanel;
    TitledBorder title1;
    TitledBorder title2;
    JList nameList;
    JScrollPane scrollPane;
    JLabel uebersichtLabel;
    JPanel namePanel;
    JLabel nameLabel;
    JTextField nameTextField;
    JLabel imageLabel;
    JPanel auswahlPanel;
    JLabel hrMitarbeiter;
    JLabel administration;
    JCheckBox checkBox1;
    JCheckBox checkBox2;
    JButton button1;
    JButton button2;
    JButton button3;
    JPanel buttonPanel;


    public Person_View() {
        mainPanel = new JPanel(new GridLayout(2,2));
        subPanel = new JPanel();
        subPanel.setLayout(new BoxLayout(subPanel,BoxLayout.PAGE_AXIS));

        uebersichtPanel = new JPanel(new GridLayout(2,1));

        title1 = BorderFactory.createTitledBorder("Personen bearbeiten:");
        mainPanel.setBorder(title1);

        title2 = BorderFactory.createTitledBorder("Detail:");
        subPanel.setBorder(title2);

        nameList = new JList(names);
        nameList.setLayoutOrientation(JList.VERTICAL);
        scrollPane = new JScrollPane(nameList);
        scrollPane.setPreferredSize(new Dimension(150,200));
        scrollPane.setVerticalScrollBarPolicy(22); //Always on
        scrollPane.setHorizontalScrollBarPolicy(31); //Never

        uebersichtLabel = new JLabel("Übersicht:");
        uebersichtPanel.add(uebersichtLabel);
        uebersichtPanel.add(scrollPane);

        mainPanel.add(uebersichtPanel, BorderLayout.WEST);

        ///////////////////////////////////////

        namePanel = new JPanel(new GridLayout(1,2));
        nameLabel = new JLabel("Name:");
        nameTextField = new JTextField();

        namePanel.add(nameLabel);
        namePanel.add(nameTextField);
        subPanel.add(namePanel, BorderLayout.NORTH);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("img.png"));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        imageLabel = new JLabel(imageIcon);

        subPanel.add(imageLabel);
        mainPanel.add(subPanel, BorderLayout.CENTER);

        /////////////////////////////////////////////

        auswahlPanel = new JPanel(new GridLayout(2,2));
        hrMitarbeiter = new JLabel("HR-Mitarbeiter:");
        administration = new JLabel("Administration:");
        checkBox1 = new JCheckBox();
        checkBox2 = new JCheckBox();
        auswahlPanel.add(hrMitarbeiter);
        auswahlPanel.add(checkBox1);
        auswahlPanel.add(administration);
        auswahlPanel.add(checkBox2);
        subPanel.add(auswahlPanel);

        /////////////////////////////////////////////

        button1 = new JButton("+");
        button2 = new JButton("X");
        button3 = new JButton("/");
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        mainPanel.add(buttonPanel, BorderLayout.WEST);

        add(mainPanel);
    }
}
