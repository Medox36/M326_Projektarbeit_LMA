package ch.bzz.m326_projektarbeit_lma.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Person_bearbeiten extends JFrame {

    String names[] = {
            "Benak Alexander","Giuntini Lorenzo", "Hawi Moustafa",
            "Jadyn Esquivel","Alondra Wren","Tara Richter","Roxanna Jack","Laci Barrera",
            "Karina Matheny","Tyson Stringer","Devontae Lombardo","Kailey Wiles","Adrian Swift"
    };

    public Person_bearbeiten(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);

        JPanel mainPanel = new JPanel(new GridLayout(2,2));
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new BoxLayout(subPanel,BoxLayout.PAGE_AXIS));

        JPanel uebersichtPanel = new JPanel(new GridLayout(2,1));

        TitledBorder title1 = BorderFactory.createTitledBorder("Personen bearbeiten:");
        mainPanel.setBorder(title1);
        TitledBorder title2 = BorderFactory.createTitledBorder("Detail:");
        subPanel.setBorder(title2);

        JList nameList = new JList(names);
        nameList.setLayoutOrientation(JList.VERTICAL);
        JScrollPane scrollPane = new JScrollPane(nameList);
        scrollPane.setPreferredSize(new Dimension(150,200));
        scrollPane.setVerticalScrollBarPolicy(22); //Always on
        scrollPane.setHorizontalScrollBarPolicy(31); //Never

        JLabel uebersichtLabel = new JLabel("Übersicht:");
        uebersichtPanel.add(uebersichtLabel);
        uebersichtPanel.add(scrollPane);

        mainPanel.add(uebersichtPanel, BorderLayout.WEST);

        ///////////////////////////////////////

        JPanel namePanel = new JPanel(new GridLayout(1,2));
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameTextField = new JTextField();
        //nameTextField.setPreferredSize(new Dimension(100,20));
        namePanel.add(nameLabel);
        namePanel.add(nameTextField);
        subPanel.add(namePanel, BorderLayout.NORTH);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("img.png"));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        JLabel imageLabel = new JLabel(imageIcon);

        subPanel.add(imageLabel);
        mainPanel.add(subPanel, BorderLayout.CENTER);

        /////////////////////////////////////////////

        JPanel auswahlPanel = new JPanel(new GridLayout(2,2));
        JLabel hrMitarbeiter = new JLabel("HR-Mitarbeiter:");
        JLabel administration = new JLabel("Administration:");
        JCheckBox checkBox1 = new JCheckBox();
        JCheckBox checkBox2 = new JCheckBox();
        auswahlPanel.add(hrMitarbeiter);
        auswahlPanel.add(checkBox1);
        auswahlPanel.add(administration);
        auswahlPanel.add(checkBox2);
        subPanel.add(auswahlPanel);

        /////////////////////////////////////////////

        JButton button1 = new JButton("+");
        JButton button2 = new JButton("X");
        JButton button3 = new JButton("/");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        mainPanel.add(buttonPanel, BorderLayout.WEST);
        

        getContentPane().add(mainPanel);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Person_bearbeiten();
    }

    public JPanel createView(){

        JPanel mainPanel = new JPanel(new GridLayout(2,2));
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new BoxLayout(subPanel,BoxLayout.PAGE_AXIS));

        JPanel uebersichtPanel = new JPanel(new GridLayout(2,1));

        TitledBorder title1 = BorderFactory.createTitledBorder("Personen bearbeiten:");
        mainPanel.setBorder(title1);
        TitledBorder title2 = BorderFactory.createTitledBorder("Detail:");
        subPanel.setBorder(title2);

        JList nameList = new JList(names);
        nameList.setLayoutOrientation(JList.VERTICAL);
        JScrollPane scrollPane = new JScrollPane(nameList);
        scrollPane.setPreferredSize(new Dimension(150,200));
        scrollPane.setVerticalScrollBarPolicy(22); //Always on
        scrollPane.setHorizontalScrollBarPolicy(31); //Never

        JLabel uebersichtLabel = new JLabel("Übersicht:");
        uebersichtPanel.add(uebersichtLabel);
        uebersichtPanel.add(scrollPane);

        mainPanel.add(uebersichtPanel, BorderLayout.WEST);

        ///////////////////////////////////////

        JPanel namePanel = new JPanel(new GridLayout(1,2));
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameTextField = new JTextField();
        //nameTextField.setPreferredSize(new Dimension(100,20));
        namePanel.add(nameLabel);
        namePanel.add(nameTextField);
        subPanel.add(namePanel, BorderLayout.NORTH);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("img.png"));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        JLabel imageLabel = new JLabel(imageIcon);

        subPanel.add(imageLabel);
        mainPanel.add(subPanel, BorderLayout.CENTER);

        /////////////////////////////////////////////

        JPanel auswahlPanel = new JPanel(new GridLayout(2,2));
        JLabel hrMitarbeiter = new JLabel("HR-Mitarbeiter:");
        JLabel administration = new JLabel("Administration:");
        JCheckBox checkBox1 = new JCheckBox();
        JCheckBox checkBox2 = new JCheckBox();
        auswahlPanel.add(hrMitarbeiter);
        auswahlPanel.add(checkBox1);
        auswahlPanel.add(administration);
        auswahlPanel.add(checkBox2);
        subPanel.add(auswahlPanel);

        /////////////////////////////////////////////

        JButton button1 = new JButton("+");
        JButton button2 = new JButton("X");
        JButton button3 = new JButton("/");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        mainPanel.add(buttonPanel, BorderLayout.WEST);

        return mainPanel;

    }

}
