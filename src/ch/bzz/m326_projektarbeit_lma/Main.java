package ch.bzz.m326_projektarbeit_lma;

import ch.bzz.m326_projektarbeit_lma.data.JSONData;
import ch.bzz.m326_projektarbeit_lma.gui.MainFrame;

public class Main {

    public static void main(String[] args) {
        // automatically load the Data
        JSONData.getInstance();
        new MainFrame();
    }
}