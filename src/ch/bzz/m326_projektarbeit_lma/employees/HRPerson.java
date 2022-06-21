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
public class HRPerson extends Person {
    private int modus;
    private String pwd;

    /**
     * constructor
     *
     * @param firstName of the HRPerson
     * @param lastName of the HRPerson
     * @param photo of the HRPerson
     * @param modus of the HRPerson
     */
    public HRPerson(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("photo") Image photo,
            @JsonProperty("modus") int modus
    ) {
        super(firstName, lastName, photo);
        setModus(modus);
    }

    /**
     * sets the modus
     *
     * @param modus to be set
     */
    public void setModus(int modus) {
        this.modus = modus;
    }

    /**
     * gets the modus
     *
     * @return modus
     */
    public int getModus() {
        return modus;
    }

    /**
     * sets the password
     *
     * @param pwd password to be set
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * gets the password
     *
     * @return password
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * writes a new log entry
     *
     * @param person on which the action was performed on
     * @param action that was performed
     */
    public void writeLogEntry(Person person, int action) {
        UserAction ua = new UserAction(this, person, action);
        LogBook log = LogBook.getLogBookInstance();
        String entry = ua.getEntry();

        log.addEntry(entry);
    }

    @Override
    public String toString() {
        return getFullName();
    }
}