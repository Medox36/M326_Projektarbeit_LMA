package ch.bzz.m326_projektarbeit_lma.employees;

import ch.bzz.m326_projektarbeit_lma.log.LogBook;
import ch.bzz.m326_projektarbeit_lma.log.UserAction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

/**
 *
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.05.18
 * @version 1.0
 */
@Getter
@Setter
public class HRPerson extends Person{
    private int modus;
    private String pwd;

    public HRPerson(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("photo") Image photo,
            @JsonProperty("modus") int modus) {
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

    // method according to class diagram
    public void writeLogEntry(int action, Person person) {
        UserAction ua = new UserAction(this, person, action);
        LogBook log = LogBook.getLogBookInstance();
        String entry = ua.getEntry();

        log.addEntry(entry);
    }

    // method to match LogTest.java
    public void writeLogEntry(Person person, int action) {
        UserAction ua = new UserAction(this, person, action);
        LogBook log = LogBook.getLogBookInstance();
        String entry = ua.getEntry();

        log.addEntry(entry);
    }
}