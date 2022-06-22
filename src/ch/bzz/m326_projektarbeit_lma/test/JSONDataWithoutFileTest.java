package ch.bzz.m326_projektarbeit_lma.test;

import ch.bzz.m326_projektarbeit_lma.data.JSONData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Test class to test the JSONData class when the data.json file doesn't exist
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.22
 * @version 1.0
 */
public class JSONDataWithoutFileTest {

    private JSONData jsonData;
    private byte[] originalFileContents;
    private boolean existed;
    private Path path;

    /**
     * reads the old values of the file and stores them in a byte[] if there exists a data.json file
     * and deletes the file for testing purposes
     *
     * @throws IOException if an I/O error occurs
     */
    @Before
    public void init() throws IOException {
        path = Paths.get("data.json");
        if (Files.exists(path)) {
            existed = true;
            originalFileContents = Files.readAllBytes(path);
            Files.delete(path);
        }
        jsonData = JSONData.getInstance();
    }

    /**
     * recreates the file if there existed a file before starting the tests
     *
     * @throws IOException if an I/O error occurs
     */
    @After
    public void finish() throws IOException {
        if (existed) {
            Files.createFile(path);
            Files.write(path, originalFileContents);
        }
    }

    /**
     * testing if the JSONData class recognised there is no data.json file
     * in which case it should create a Company wth the name "default"
     */
    @Test
    public void testCreationOfDefaultCompany() {
        assertEquals("default", jsonData.getCompany().getCompanyName());
    }

}