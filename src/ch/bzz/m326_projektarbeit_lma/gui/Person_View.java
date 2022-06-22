package ch.bzz.m326_projektarbeit_lma.gui;

import ch.bzz.m326_projektarbeit_lma.employees.Person;
import ch.bzz.m326_projektarbeit_lma.gui.model.PersonListModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * This class adds all the components into a JTabbedPane and formats it
 * @Author Alexander Benak, Lorenzo Giuntini
 * @Since 21.06.2022
 * @Version 1.3
 */
public class Person_View extends JPanel {

    /**
     * The constructor of the PersonView which holds all the components
     */
    public Person_View() {

        //The main panels with their layout
        JPanel mainPanel = new JPanel(new GridLayout(2,2));
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new BoxLayout(subPanel,BoxLayout.PAGE_AXIS));

        JPanel uebersichtPanel = new JPanel(new GridLayout(2,1));

        //Creates the titled borders
        TitledBorder title1 = BorderFactory.createTitledBorder("Personen bearbeiten:");
        mainPanel.setBorder(title1);
        TitledBorder title2 = BorderFactory.createTitledBorder("Detail:");
        subPanel.setBorder(title2);

        //Creates a list and fills the data into a scrollpane
        JList<Person> nameList = new JList<>(new PersonListModel());
        nameList.setLayoutOrientation(JList.VERTICAL);
        JScrollPane scrollPane = new JScrollPane(nameList);
        scrollPane.setPreferredSize(new Dimension(150,200));
        scrollPane.setVerticalScrollBarPolicy(22); //Always on
        scrollPane.setHorizontalScrollBarPolicy(31); //Never

        //Adds a label to the scrollpane
        JLabel uebersichtLabel = new JLabel("Übersicht:");
        uebersichtPanel.add(uebersichtLabel);
        uebersichtPanel.add(scrollPane);

        mainPanel.add(uebersichtPanel, BorderLayout.WEST);

        //The textfield with a label
        JPanel namePanel = new JPanel(new GridLayout(1,2));
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameTextField = new JTextField();
        namePanel.add(nameLabel);
        namePanel.add(nameTextField);
        subPanel.add(namePanel, BorderLayout.NORTH);

        //Creates the image
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("img.png")));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        JLabel imageLabel = new JLabel(imageIcon);

        subPanel.add(imageLabel);
        mainPanel.add(subPanel, BorderLayout.CENTER);

        //Creates the choices in the form of Checkboxes
        JPanel auswahlPanel = new JPanel(new GridLayout(2,2));
        JLabel hrMitarbeiter = new JLabel("HR-Mitarbeiter:");
        JLabel administration = new JLabel("Administration:");
        JCheckBox checkBox1 = new JCheckBox();
        JCheckBox checkBox2 = new JCheckBox();

        //Add some logic to the checkboxes
        if (checkBox1.isSelected()){
            checkBox2.setEnabled(false);
        } else if (checkBox2.isSelected()){
            checkBox1.setEnabled(false);
        }

        //Add everthing to a panel
        auswahlPanel.add(hrMitarbeiter);
        auswahlPanel.add(checkBox1);
        auswahlPanel.add(administration);
        auswahlPanel.add(checkBox2);
        subPanel.add(auswahlPanel);

        //Creates the Buttons and its respective Panel
        JButton button1 = new JButton("+");
        JButton button2 = new JButton("X");
        JButton button3 = new JButton("/");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        mainPanel.add(buttonPanel, BorderLayout.WEST);

        //Actionlistener + button
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddPerson();
            }
        });

        add(mainPanel);
    }
}
