package ch.bzz.m326_projektarbeit_lma.gui;

import ch.bzz.m326_projektarbeit_lma.employees.HRPerson;
import ch.bzz.m326_projektarbeit_lma.facade.PersonFacade;
import ch.bzz.m326_projektarbeit_lma.gui.model.HRPersonComboboxModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LoginGUI extends JDialog {
    private int counter = 0;
    JLabel nameLabel = new JLabel("Name:");
    JLabel codeLabel = new JLabel("Code:");
    JComboBox<HRPerson> nameCombox = new JComboBox<>(new DefaultComboBoxModel<>());
    JTextField codeField = new JTextField("Code eingeben");
    JButton abbrechenButton = new JButton("Abbrechen");
    JButton weiterButton = new JButton("Weiter");

    //Konstruktor
    public LoginGUI(MainFrame mainFrame){
        super(mainFrame);
        //frame einstellen
        setTitle("Authentifizierung");
        setSize(350, 170);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(5,5));
        //Panels erstelln inkl. Layouts
        JPanel loginPanel = new JPanel(new GridLayout(2,2,5,5));
        JPanel downPanel = new JPanel(new GridLayout(1,2,5,5));
        JPanel mainPanel = new JPanel(new BorderLayout(5,5));
        JPanel bigPanel = new JPanel(new BorderLayout(5,5));


        //zusammenbauen
        loginPanel.add(nameLabel);
        loginPanel.add(nameCombox);
        loginPanel.add(codeLabel);
        loginPanel.add(codeField);
        downPanel.add(abbrechenButton);
        downPanel.add(weiterButton);
        mainPanel.add(loginPanel, BorderLayout.NORTH);
        mainPanel.add(downPanel, BorderLayout.SOUTH);
        bigPanel.add(mainPanel, BorderLayout.CENTER);

        //ActionLister adden
        weiterButton.addActionListener(e -> {
            if (counter <= 3) {
                if (PersonFacade.getInstance().logInHRPerson((HRPerson) nameCombox.getSelectedItem())) {
                    dispose();
                } else {
                    counter++;
                    new ErrorGUI();
                }
            } else {
                new CloseProjectGui();
            }
        });

        Border blackline = BorderFactory.createLineBorder(Color.black);
        bigPanel.setBorder(blackline);

        getContentPane().add(bigPanel, BorderLayout.CENTER);
        //Sichtbarkeit
        setVisible(true);
    }

}
