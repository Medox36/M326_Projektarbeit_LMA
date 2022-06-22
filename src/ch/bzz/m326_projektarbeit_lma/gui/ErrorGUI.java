package ch.bzz.m326_projektarbeit_lma.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

/**
 * JDialog for showing the user he has typed the wrong password to the selected HRPerson
 *
 * @author Moustafa Hawi, Lorenzo Giuntini (Medox36)
 * @since 21.06.2022
 * @version 1.0
 */
public class ErrorGUI extends JDialog {
    JLabel label = new JLabel("Passwort nicht gültig");
    JButton wiederholenButton = new JButton("Wiederholen");

    /**
     * constructor
     *
     * @param parent of this JDialog
     */
    public ErrorGUI(LoginGUI parent){
        super(parent, true);
        setTitle("Error-Passwort falsch");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(200,120);
        getContentPane().setLayout(new BorderLayout(5,5));

        JPanel mainPanel = new JPanel(new BorderLayout(5,5));
        JPanel gridPanel = new JPanel(new GridLayout(2,1,5,5));

        gridPanel.add(label);
        gridPanel.add(wiederholenButton);
        mainPanel.add(gridPanel, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        wiederholenButton.addActionListener(
                e -> dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING))
        );

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
