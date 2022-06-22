package ch.bzz.m326_projektarbeit_lma.gui;

import javax.swing.*;
import java.awt.*;

/**
 * JDialog for telling the user the program is closing
 * Closes the program, via a new Thread called Shutdown-Thread
 *
 * @author Moustafa Hawi, Lorenzo Giuntini (Medox36)
 * @since 21.06.2022
 * @version  1.0
 */
public class CloseProjectGui extends JDialog {
    private JLabel label = new JLabel("Das Programm wird heruntergefahren...");

    /**
     * constructor
     *
     * @param parent for JDialog
     */
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
