package ch.bzz.m326_projektarbeit_lma.log;

import ch.bzz.m326_projektarbeit_lma.employees.HRPerson;
import ch.bzz.m326_projektarbeit_lma.employees.Person;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A class for generating Strings for the LogBook
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.05.18
 * @version 1.1
 */
public class UserAction {
    public static int CREATE_PERSON = 0;
    public static int CHANGE_VALUE = 1;
    public static int SET_ASSIGNMENT = 2;
    public static int DELETE_PERSON = 3;
    public static int CHANGED_BASE_DATA = 4;

    private String[] actionDescription = {"created person", "changed Value of", "set assignment to", "deleted person", "changed base data"};
    private String entry;

    /**
     * creates a UserAction and generates the entry string for the logBook
     *
     * @param hrPerson who caused the action
     * @param person on which the action was performed
     * @param action that was made
     */
    public UserAction(HRPerson hrPerson, Person person, int action) {
        entry = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        entry += " : " + hrPerson.getFirstName() + " " + hrPerson.getLastName() + " do";

        if (action >= 0 && action < 4) {
            entry += " " + actionDescription[action];
            entry += " for " + person.getFirstName() + " " + person.getLastName() + ";";
        } else if (action == 4) {
            entry += " " + actionDescription[action];
        } else {
            entry += " unknown action";
        }
    }

    /**
     * gets the entry string
     *
     * @return the entry string
     */
    public String getEntry() {
        return entry;
    }
}