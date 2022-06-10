package ch.bzz.m326_projektarbeit_lma.employees;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.awt.*;

/**
 *
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.05.18
 * @version 1.0
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = HRPerson.class, name = "HRPerson")})
public class Person {
    private Image photo;
    private String firstName;
    private String lastName;
    private Participation participation;

    // constructor to match LogTest.java
    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        participation = new Participation();
    }

    // constructor according to class diagram
    public Person(String firstName, String lastName, Image photo) {
        this(firstName, lastName);
        setPhoto(photo);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Image getPhoto() {
        return photo;
    }

    public Participation getParticipation() {
        return participation;
    }
}