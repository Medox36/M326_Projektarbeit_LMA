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
 *
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.08
 * @version 1.0
 */
public class JSONData {
    private static final String PATH = "data.json";
    private static JSONData instance;

    private Company company;

    private JSONData() {
        company = new Company();
        checkFile();
    }


    private void checkFile() {
        try {
            File file = new File(PATH);
            if (!file.createNewFile()) {
                readCompanyJSON();
            } else {
                company = new Company("");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readCompanyJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(PATH));
            ObjectMapper objectMapper = new ObjectMapper();
            company = objectMapper.readValue(jsonData, Company.class);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void writeCompanyJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        FileOutputStream fileOutputStream;
        Writer fileWriter;

        try {
            fileOutputStream = new FileOutputStream(PATH);
            fileWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectWriter.writeValue(fileWriter, company);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private Company getCompany() {
        return company;
    }

    public JSONData getInstance() {
        if (instance == null) {
            instance = new JSONData();
        }
        return instance;
    }
}