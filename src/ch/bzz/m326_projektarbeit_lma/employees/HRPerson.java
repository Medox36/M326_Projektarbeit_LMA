package ch.bzz.m326_projektarbeit_lma.employees;

import ch.bzz.m326_projektarbeit_lma.log.LogBook;
import ch.bzz.m326_projektarbeit_lma.log.UserAction;

import java.awt.*;

public class HRPerson extends Person{
    private int modus;
    private String pwd;

    public HRPerson(String firstName, String lastName, Image photo, int modus) {
        super(firstName, lastName, photo);
        setModus(modus);
    }

    public void change(Person person, int modus) {
        // it is unclear to us for what this method is used for
    }

    public void setModus(int modus) {
        this.modus = modus;
    }

    public int getModus() {
        return modus;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }

    public void writeLogEntry(int action, Person person) {
        UserAction ua = new UserAction(this, person, action);
        LogBook log = LogBook.getBookInstance();
        String entry = ua.getEntry();

        log.addEntry(entry);
    }
}