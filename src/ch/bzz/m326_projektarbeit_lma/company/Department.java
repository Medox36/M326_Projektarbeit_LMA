package ch.bzz.m326_projektarbeit_lma.company;

import ch.bzz.m326_projektarbeit_lma.employees.Person;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Vector;

/**
 *
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.01
 * @version 1.0
 */
@Getter
@Setter
public class Department {

    private String name;
    private Vector<Person> members;

    /**
     * constructor
     *
     * @param name of the department
     */
    public Department(@JsonProperty("name") String name) {
        this.name = name;
        members = new Vector<>();
    }

    /**
     * gets the name
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * adds a member to the members
     *
     * @param member to be added
     */
    public void addMember(Person member) {
        members.add(member);
    }

    /**
     * gets a member at a given index
     *
     * @param index of the member
     * @return member
     */
    public Person getMember(int index) {
        return members.get(index);
    }

    /**
     * removes a member at a given index
     *
     * @param index of the member
     */
    public void removeMember(int index) {
        members.remove(index);
    }

    /**
     * removes a given member
     *
     * @param member to be removed
     */
    public void removeMember(Person member) {
        members.remove(member);
    }

    /**
     * gets the number of members
     *
     * @return number of members
     */
    @JsonIgnore
    public int getNumberOfMembers() {
        return members.size();
    }

    /**
     * gets all the members
     *
     * @return all members in Vector of type Person
     */
    @JsonIgnore
    public Vector<Person> getAllMembers() {
        return members;
    }
}