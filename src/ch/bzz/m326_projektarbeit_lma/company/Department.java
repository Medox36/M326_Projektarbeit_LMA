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

    public Department(@JsonProperty("name") String name) {
        this.name = name;
        members = new Vector<>();
    }

    public String getName() {
        return name;
    }

    public void addMember(Person person) {
        members.add(person);
    }
    public Person getMember(int index) {
        return members.get(index);
    }

    public void removeMember(int index) {
        members.remove(index);
    }

    public void removeMember(Person person) {
        members.remove(person);
    }

    @JsonIgnore
    public int getNumberOfMembers() {
        return members.size();
    }

    @JsonIgnore
    public Vector<Person> getAllMembers() {
        return members;
    }
}