package ch.bzz.m326_projektarbeit_lma.employees;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

/**
 * The Person class represents a member of a company, storing the first and last name
 * as well as a photo and the participation.
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.05.18
 * @version 1.1
 */
@Getter
@Setter
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

    /**
     * constructor
     *
     * @param firstName of the Person
     * @param lastName of the Person
     * @param photo of the Person
     */
    public Person(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("photo") Image photo
    ) {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoto(photo);
        participation = new Participation();
    }

    /**
     * sets the first name
     *
     * @param firstName to be set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * sets the last name
     *
     * @param lastName to be set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * sets the photo
     *
     * @param photo to be set
     */
    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    /**
     * gets the first name
     *
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * gets the last name
     *
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * gets the full name
     *
     * @return full name
     */
    @JsonIgnore
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * gets the photo
     *
     * @return photo
     */
    public Image getPhoto() {
        return photo;
    }

    /**
     * gets the participation
     *
     * @return participation
     */
    public Participation getParticipation() {
        return participation;
    }

    /**
     * overwrites the default toString method
     *
     * @return the full name of the Person
     */
    @Override
    public String toString() {
        return getFullName();
    }
}