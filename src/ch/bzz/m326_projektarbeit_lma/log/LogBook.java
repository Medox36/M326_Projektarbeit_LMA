package ch.bzz.m326_projektarbeit_lma.log;

import java.io.*;
import java.util.Vector;

/**
 * Class for managing the LogBook
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.05.18
 * @version 1.1
 */
public class LogBook {

    private static LogBook instance;

    private Vector<String> entries = new Vector<>();
    private File file;
    private BufferedReader reader;
    private BufferedWriter writer;
    private boolean fileWritingEnabled;

    /**
     * creates a LogBook
     * is private because of singleton pattern
     */
    private LogBook() {
        file = new File("logbook.log");
        try {
            if (!file.createNewFile()) {
                reader = new BufferedReader(new FileReader(file));
                readFile();
                reader.close();
            }
            writer = new BufferedWriter(new FileWriter(file, true));
            fileWritingEnabled = true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * creates an instance of logBook if there isn't already one
     * (singleton pattern)
     *
     * @return instance of the logBook
     */
    public static LogBook getLogBookInstance() {
        if (instance == null) {
            instance = new LogBook();
        }
        return instance;
    }

    /**
     * adds an entry to the logBook
     *
     * @param entry to be added
     */
    public void addEntry(String entry) {
        entries.add(entry);
        if (fileWritingEnabled) {
            writeFile(entry);
        }
    }

    /**
     * gets an entry at a given index
     * returns null if the index is lower than zero or higher than the entries Vector's size
     *
     * @param index of the entry
     * @return the entry at the given index
     */
    public String getEntry(int index) {
        String entry;
        try {
            entry = entries.get(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            entry = null;
        }
        return entry;
    }

    /**
     * gets the size of the entries Vector
     *
     * @return the size of the entries Vector
     */
    public int getSize() {
        return entries.size();
    }

    /**
     * closes the writer so the logBook can be closed safely
     */
    public void logBookClose() {
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * writes the given entry to the file
     *
     * @param entry that has to be written into the file
     */
    private void writeFile(String entry) {
        try {
            writer.append(entry);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * reads all the entries of the log file into the entries Vector
     *
     * @throws IOException if an I/O error occurs
     */
    private void readFile() throws IOException {
        while (reader.ready()) {
            entries.add(reader.readLine());
        }
    }

    // method to match LogTest.java
    public void printLog() {
        for (String str : entries) {
            System.out.println(str);
        }
    }
}