package ch.bzz.m326_projektarbeit_lma.company;

import ch.bzz.m326_projektarbeit_lma.employees.Person;

import java.util.Vector;

/**
 *
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.01
 * @version 1.0
 */
public class Departement {

    private String name;
    private Vector<Person> members;

    public Departement(String name) {
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

    public int getNumberOfMembers() {
        return members.size();
    }

    public Vector<Person> getAllMembers() {
        return members;
    }
}