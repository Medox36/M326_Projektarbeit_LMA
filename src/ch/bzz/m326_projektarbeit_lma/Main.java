package ch.bzz.m326_projektarbeit_lma;

import ch.bzz.m326_projektarbeit_lma.data.JSONData;
import ch.bzz.m326_projektarbeit_lma.gui.MainFrame;

/**
 * This class is the main class, it loads the data and creates the GUI
 * @Author Lorenzo Giuntini, Moustafa Hawi
 * @Since 21.06.2022
 * @Version 1.0
 */
public class Main {

    /**
     * The main method that creates the GUI
     * @param args
     */
    public static void main(String[] args) {
        // automatically load the Data
        JSONData.getInstance();
        new MainFrame();
    }
}