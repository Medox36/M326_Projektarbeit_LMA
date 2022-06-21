package ch.bzz.m326_projektarbeit_lma.data;

import ch.bzz.m326_projektarbeit_lma.company.Company;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class is responsible for managing the application data.
 * It writes and reads the storage .json-file.
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.08
 * @version 1.0
 */
public class JSONData {

    private static JSONData instance;

    private Company company;

    private final String PATH = "data.json";

    /**
     * constructor
     *
     * adds a ShutdownHook that assures, the data is being saved when the program is closed
     */
    private JSONData() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::writeCompanyJSON, "Saving Data Shutdown-Thread"));
        checkFile();
    }

    /**
     * checks if the file containing the application data exists.
     * If it doesn't exist it creates a default company so the program can still function
     */
    private void checkFile() {
        try {
            File file = new File(PATH);
            if (!file.createNewFile()) {
                readCompanyJSON();
            } else {
                setCompany(new Company("default"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * reads the data from the file
     */
    public void readCompanyJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(PATH));
            ObjectMapper objectMapper = new ObjectMapper();
            setCompany(objectMapper.readValue(jsonData, Company.class));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * writes the data to the file
     */
    public void writeCompanyJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        FileOutputStream fileOutputStream;
        Writer fileWriter;

        try {
            fileOutputStream = new FileOutputStream(PATH);
            fileWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectWriter.writeValue(fileWriter, getCompany());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * gets the company
     *
     * @return the company
     */
    public Company getCompany() {
        return company;
    }

    /**
     * sets the company
     *
     * @param company to set
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * returns the instance of the JSONData class according to the singleton pattern
     *
     * @return the instance
     */
    public static JSONData getInstance() {
        if (instance == null) {
            instance = new JSONData();
        }
        return instance;
    }
}