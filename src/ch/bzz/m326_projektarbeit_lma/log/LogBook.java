package ch.bzz.m326_projektarbeit_lma.log;

import ch.bzz.m326_projektarbeit_lma.gui.Logbuch_View;

import java.io.*;
import java.util.Iterator;
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

    private Logbuch_View logbuch_view;

    /**
     * constructor
     * is private because of singleton pattern
     *
     *  adds a ShutdownHook that assures, the LogBook is being closed when the program is closed
     */
    private LogBook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::logBookClose, "Saving Log-Data Shutdown-Thread"));
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
        logbuch_view.fireChanges();
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
     * gets all entries in one String so they can be shown in the LogBuch_View
     * ,
     * @return all entries in one String
     */
    public String getEntries() {
        StringBuilder sb = new StringBuilder();

        Iterator<String> it = entries.iterator();
        if (!it.hasNext()) {
            return sb.toString();
        }

        for (;;) {
            sb.append(it.next());
            if (!it.hasNext()) {
                return sb.toString();
            } else {
                sb.append("\n");
            }
        }
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

    /**
     * prints out all te log book entries
     */
    public void printLog() {
        for (String str : entries) {
            System.out.println(str);
        }
    }

    /**
     * sets the Logbuch_View soe the logBook can notify the LogBuch_View when changes occur
     *
     * @param logbuch_view to be set
     */
    public void setLogbuch_view(Logbuch_View logbuch_view) {
        this.logbuch_view = logbuch_view;
    }
}