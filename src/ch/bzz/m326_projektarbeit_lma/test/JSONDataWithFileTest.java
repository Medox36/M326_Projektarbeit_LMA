package ch.bzz.m326_projektarbeit_lma.test;

import ch.bzz.m326_projektarbeit_lma.company.Department;
import ch.bzz.m326_projektarbeit_lma.data.JSONData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Test class to test the JSONData class when the data.json file already exists
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.22
 * @version 1.0
 */
public class JSONDataWithFileTest {

    private JSONData jsonData;
    private byte[] originalFileContents;

    /**
     * reads the old values of the file and stores them in a byte[]
     *
     * @throws IOException if an I/O error occurs
     */
    @Before
    public void init() throws IOException {
        originalFileContents = Files.readAllBytes(Paths.get("data.json"));
        jsonData = JSONData.getInstance();
    }

    /**
     * writes the old values back into the file so changes from the test won't affect the data for the actual program
     *
     * @throws IOException if an I/O error occurs
     */
    @After
    public void finish() throws IOException {
        Files.write(Paths.get("data.json"), originalFileContents);
    }

    /**
     * testing that the loaded data hasn't created a null value for the company
     */
    @Test
    public void testSuccessfulReadingJSONData() {
        assertNotEquals(null, jsonData.getCompany());
    }

    /**
     * testing if the changes to the company actually get saver
     * or if the JSONData class just writes the old values back into the file
     *
     * @throws IOException if an I/O error occurs (not relevant for the test)
     */
    @Test
    public void testSuccessfulWritingChangesJSONData() throws IOException {
        jsonData.getCompany().addDepartment(new Department("for testing"));
        JSONData.getInstance().writeCompanyJSON();

        byte[] newFileContents = Files.readAllBytes(Paths.get("data.json"));
        assertArrayEquals(originalFileContents, newFileContents);
    }

}