package ch.bzz.m326_projektarbeit_lma.gui;

import ch.bzz.m326_projektarbeit_lma.log.LogBook;

import javax.swing.*;
import java.awt.*;

public class Logbuch_View extends JPanel {

    public Logbuch_View() {
        JPanel logPanel = new JPanel(new BorderLayout());

        JTextArea textArea = new JTextArea(LogBook.getLogBookInstance().getEntries());
        textArea.setEditable(false);
        textArea.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(550,550));

        logPanel.add(scrollPane, BorderLayout.CENTER);

        add(logPanel);
    }
}
