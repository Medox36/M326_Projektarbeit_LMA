package ch.bzz.m326_projektarbeit_lma.gui;

import javax.swing.*;

public class TestFrame extends JFrame {

    public TestFrame(){

        setTitle("I am looking for");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,700);

        JTabbedPane navbar = new JTabbedPane();

        setVisible(true);

    }

    public static void main(String[] args) {
        new TestFrame();
    }

}
