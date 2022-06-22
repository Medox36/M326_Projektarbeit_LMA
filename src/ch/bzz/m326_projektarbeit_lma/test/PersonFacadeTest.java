package ch.bzz.m326_projektarbeit_lma.test;

import ch.bzz.m326_projektarbeit_lma.data.JSONData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

import ch.bzz.m326_projektarbeit_lma.employees.HRPerson;
import ch.bzz.m326_projektarbeit_lma.employees.Person;
import ch.bzz.m326_projektarbeit_lma.facade.PersonFacade;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonFacadeTest {

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
     * checks if the filter for team in the PersonFacade works
     *
     * @see PersonFacade#getAllPersonWithFilter(String, String, String, String)
     */
    @Test
    public void testGetPersonsWithFilterForTeam() {
        boolean filterFailed = false;
        Vector<Person> persons = PersonFacade.getInstance()
                .getAllPersonWithFilter("", "", "Leiter", "");
        for (Person person : persons) {
            if (!PersonFacade.getInstance().getTeamsOfPerson(person).contains("Leiter")) {
                filterFailed = true;
            }
        }
        assertFalse(filterFailed);
    }

    /**
     * checks if the filter for function in the PersonFacade works
     *
     * @see PersonFacade#getAllPersonWithFilter(String, String, String, String)
     */
    @Test
    public void testGetPersonsWithFilterForJobFunction() {
        boolean filterFailed = false;
        Vector<Person> persons = PersonFacade.getInstance()
                .getAllPersonWithFilter("", "Fahrzeugunterhalt", "", "");
        for (Person person : persons) {
            if (!PersonFacade.getInstance().getFunctionsOfPerson(person).contains("Fahrzeugunterhalt")) {
                filterFailed = true;
            }
        }
        assertFalse(filterFailed);
    }

    /**
     * checks if the filter for the department name in the PersonFacade works
     *
     * @see PersonFacade#getAllPersonWithFilter(String, String, String, String)
     */
    @Test
    public void testGetPersonsWithFilterForDepartment() {
        boolean filterFailed = false;
        Vector<Person> persons = PersonFacade.getInstance()
                .getAllPersonWithFilter("Interne Post", "", "", "");
        for (Person person : persons) {
            if (!PersonFacade.getInstance().getDepartmentNameOfPerson(person).equals("Interne Post")) {
                filterFailed = true;
            }
        }
        assertFalse(filterFailed);
    }

    /**
     * checks if the sorting ascending functionality in the PersonFacade works
     */
    @Test
    public void testGetPersonsSortedAscending() {
        boolean isSortedAscending;
        Vector<Person> persons = PersonFacade.getInstance()
                .getAllPersonWithFilter("", "", "", "A");
        isSortedAscending = emptyOreSize1(persons);

        Comparator<Person> comp = Comparator.comparing(Person::getFullName);

        Iterator<Person> iter = persons.iterator();
        Person current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (comp.compare(current, previous) > 0) {
                isSortedAscending = true;
            } else {
                isSortedAscending = false;
                break;
            }
            previous = current;
        }

        assertTrue(isSortedAscending);
    }

    /**
     * checks if the sorting descending functionality in the PersonFacade works
     */
    @Test
    public void testGetPersonsSortedDescending() {
        boolean isSortedDescending;
        Vector<Person> persons = PersonFacade.getInstance()
                .getAllPersonWithFilter("", "", "", "D");
        isSortedDescending = emptyOreSize1(persons);

        Comparator<Person> comp = Comparator.comparing(Person::getFullName);

        Iterator<Person> iter = persons.iterator();
        Person current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (comp.compare(current, previous) < 0) {
                isSortedDescending = true;
            } else {
                isSortedDescending = false;
                break;
            }
            previous = current;
        }

        assertTrue(isSortedDescending);
    }

    /**
     * checks if the given Vector is empty or of size 1
     *
     * @param vector to chack
     * @return true if given vector is empty or of size 1 otherwise false;
     */
    private boolean emptyOreSize1(Vector<Person> vector) {
        return vector.isEmpty() || vector.size() == 1;
    }

    /**
     * test if the PersonFacade method to get all HRPersons really only returns HRPersons
     *
     * @see PersonFacade#getAllHRPersons()
     */
    @Test
    public void testGettingAllHRPersonsAreOnlyHRPersons() {
        boolean allPersonsAreHRPersons = false;
        Vector<HRPerson> hrPeople = PersonFacade.getInstance().getAllHRPersons();
        for (HRPerson hrPerson : hrPeople) {
            if (PersonFacade.getInstance().isHRPerson(hrPerson)) {
                allPersonsAreHRPersons = true;
            } else {
                allPersonsAreHRPersons = false;
                break;
            }
        }
        assertTrue(allPersonsAreHRPersons);
    }

    /**
     * test if the PersonFacade method to get all HRPersons returns all HRPersons and doesn't forget any
     */
    @Test
    public void testGettingAllHRPersons() {
        assertEquals(
                PersonFacade.getInstance().getNumberOfHRPersons(),
                PersonFacade.getInstance().getAllHRPersons().size()
        );
    }

}