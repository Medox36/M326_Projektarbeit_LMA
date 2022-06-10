package ch.bzz.m326_projektarbeit_lma.data;

import ch.bzz.m326_projektarbeit_lma.company.Company;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

/**
 *
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.08
 * @version 1.0
 */
public class JSONData {
    /*
    private static final URI PATH;

    static {
        try {
            PATH = Objects.requireNonNull(JSONData.class.getResource("../../../../data/json/data.json")).toURI();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
     */

    private static JSONData instance;

    private Company company;

    private JSONData() {
        company = new Company();
        checkFile();
    }


    private void checkFile() {
        try {
            //File file = new File(String.valueOf(JSONData.class.getResource("../../../../data/json/data.json")));
            File file = new File("data.json");
            if (!file.createNewFile()) {
                readCompanyJSON();
            } else {
                company = new Company("");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readCompanyJSON() {
        try {
            /*
            String path = Paths.get(PATH).toString();
            byte[] jsonData = Files.readAllBytes(Paths.get(path));
            */
            byte[] jsonData = Files.readAllBytes(Paths.get("data.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            company = objectMapper.readValue(jsonData, Company.class);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void writeCompanyJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        FileOutputStream fileOutputStream;
        Writer fileWriter;

        try {
            //fileOutputStream = new FileOutputStream(PATH.getPath());
            fileOutputStream = new FileOutputStream("data.json");
            fileWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectWriter.writeValue(fileWriter, company);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public static JSONData getInstance() {
        if (instance == null) {
            instance = new JSONData();
        }
        return instance;
    }
}