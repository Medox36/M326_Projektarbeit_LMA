package ch.bzz.m326_projektarbeit_lma.log;

import ch.bzz.m326_projektarbeit_lma.employees.HRPerson;
import ch.bzz.m326_projektarbeit_lma.employees.Person;

/**
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.05.18
 * @version 1.0
 */
public class UserAction {
    public static int CREATE_PERSON = 0;
    public static int CHANGE_VALUE = 1;
    public static int SET_ASSIGNMENT = 2;
    public static int DELETE_PERSON = 3;

    private String[] actionDescription = {"created person", "changed Value of", "set assignment to", "deleted person"};
    private String entry;

    /**
     * creates a UserAction and generates the entry string for the logBook
     *
     * @param hrPerson who caused the action
     * @param person on which the action was performed
     * @param action that was made
     */
    public UserAction(HRPerson hrPerson, Person person, int action) {
        entry = "HRPerson: " + hrPerson.getFirstName() + " " + hrPerson.getLastName();

        if (action >= 0 && action < actionDescription.length) {
            entry += " " + actionDescription[action];
            entry += " on Person: " + person.getFirstName() + " " + person.getLastName();
        } else {
            entry += " made action: unknown action";
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