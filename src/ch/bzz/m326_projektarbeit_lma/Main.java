package ch.bzz.m326_projektarbeit_lma;

import ch.bzz.m326_projektarbeit_lma.employees.HRPerson;
import ch.bzz.m326_projektarbeit_lma.employees.Person;
import ch.bzz.m326_projektarbeit_lma.log.LogBook;
import ch.bzz.m326_projektarbeit_lma.log.UserAction;

public class Main {

    public static void main(String[] args) {
        HRPerson hrPerson = new HRPerson("Alice", "Beats", null, 0);
        Person person = new Person("Bob", "Parker", null);

        hrPerson.writeLogEntry(UserAction.CREATE_PERSON, person);
        hrPerson.writeLogEntry(UserAction.DELETE_PERSON, person);

        LogBook.getBookInstance().logBookClose();
    }
}