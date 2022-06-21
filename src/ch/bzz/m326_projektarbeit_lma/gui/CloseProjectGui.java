package ch.bzz.m326_projektarbeit_lma.gui;

import javax.swing.*;
import java.awt.*;

public class CloseProjectGui extends JDialog {
    private JLabel label = new JLabel("Das Programm wird heruntergefahren...");
    public CloseProjectGui(LoginGUI parent){
        super(parent, true);
        setTitle("Error-Abbruch");
        setSize(300,120);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(10,10));


        JPanel mainPanel = new JPanel(new BorderLayout(10,10));

        mainPanel.add(label, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(0);
        }, "Shutdown-Thread").start();

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
