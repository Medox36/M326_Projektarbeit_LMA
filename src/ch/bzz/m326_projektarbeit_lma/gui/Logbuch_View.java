package ch.bzz.m326_projektarbeit_lma.gui;

import ch.bzz.m326_projektarbeit_lma.log.LogBook;

import javax.swing.*;
import java.awt.*;

/**
 * Creates the Logbook
 * @Author Alexander Benak, Lorenzo Giuntini
 * @Since 20.06.2022
 * @Version 1.1
 */
public class Logbuch_View extends JPanel {

    private JTextArea textArea;

    /**
     * The constructor that creates the GUI, with all the components
     */
    public Logbuch_View() {
        JPanel logPanel = new JPanel(new BorderLayout());

        textArea = new JTextArea(LogBook.getLogBookInstance().getEntries());
        textArea.setEditable(false);
        textArea.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(550,550));

        logPanel.add(scrollPane, BorderLayout.CENTER);

        LogBook.getLogBookInstance().setLogbuch_view(this);

        add(logPanel);
    }

    /**
     * Fire changes method to display the text
     */
    public void fireChanges() {
        SwingUtilities.invokeLater(() -> textArea.setText(LogBook.getLogBookInstance().getEntries()));
    }
}
