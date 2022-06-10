package ch.bzz.m326_projektarbeit_lma;

import ch.bzz.m326_projektarbeit_lma.employees.HRPerson;
import ch.bzz.m326_projektarbeit_lma.employees.Person;
import ch.bzz.m326_projektarbeit_lma.log.LogBook;
import ch.bzz.m326_projektarbeit_lma.log.UserAction;

public class LogTest {

    public static void main(String[]args){
        HRPerson hrp = new HRPerson("Max", "Muster", null, 0);
        Person pe = new Person("Maila", "Maurer", null);

        hrp.writeLogEntry(pe, UserAction.CREATE_PERSON);
        hrp.writeLogEntry(pe, UserAction.SET_ASSIGNMENT);
        hrp.writeLogEntry(pe,UserAction.CHANGE_VALUE);
        hrp.writeLogEntry(pe, -1);
        hrp.writeLogEntry(pe, UserAction.DELETE_PERSON);

        LogBook.getLogBookInstance().printLog();
    }
}
