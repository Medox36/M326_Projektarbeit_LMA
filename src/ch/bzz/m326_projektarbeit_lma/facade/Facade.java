package ch.bzz.m326_projektarbeit_lma.facade;

import ch.bzz.m326_projektarbeit_lma.company.Company;
import ch.bzz.m326_projektarbeit_lma.company.Departement;
import ch.bzz.m326_projektarbeit_lma.data.JSONData;
import ch.bzz.m326_projektarbeit_lma.employees.Person;

import java.util.Vector;

public class Facade {
    private static Facade instance;
    private Company company;

    private Facade() {
        company = JSONData.getInstance().getCompany();
    }

    public Vector<Person> getAllPersons() {
        Vector<Person> persons = new Vector<>();
        for (Departement departement : getAllDepartments()) {
            persons.addAll(departement.getAllMembers());
        }
        return persons;
    }

    public Vector<Departement> getAllDepartments() {
        return company.getAllDepartments();
    }

    public Vector<String> getAllDepartmentNames() {
        return company.getDepartmentsName();
    }

    public Departement getDepartmentByName(String name) {
        for (Departement departement : getAllDepartments()) {
            if (departement.getName().equals(name)) {
                return departement;
            }
        }
        return null;
    }

    public void addDepartment(String name) {
        company.addDepartment(new Departement(name));
    }

    public void removeDepartment(String name) {
        company.removeDepartment(getDepartmentByName(name));
    }

    public Vector<String> getAllFunctions() {
        return company.getFunctions().getAllFunctions();
    }

    public void addFunction(String name) {
        company.getFunctions().addJobFunction(name);
    }

    public void removeFunction(String name) {
        company.getFunctions().removeJobFunction(name);
    }

    public Vector<String> getAllTeams() {
        return company.getTeams().getAllTeams();
    }

    public void addTeam(String name) {
        company.getTeams().addTeam(name);
    }

    public void removeTeam(String name) {
        company.getTeams().removeTeam(name);
    }

    public Vector<String> getFunctionsOfPerson(Person person) {
        return person.getParticipation().getAllFunctions();
    }

    public Vector<String> getTeamsOfPerson (Person person) {
        return person.getParticipation().getAllTeams();
    }

    public String getDepartmentNameOfPerson(Person person) {
        return getDepartmentOfPerson(person).getName();
    }

    public Departement getDepartmentOfPerson(Person person) {
        for (Departement departement : company.getAllDepartments()) {
            for (Person person1 : departement.getAllMembers()) {
                if (person1.equals(person)) {
                    return departement;
                }
            }
        }
        return null;
    }

    private void addPersonToDepartment(Person person, String departmentName) {
        getDepartmentByName(departmentName).addMember(person);
    }

    private void removePersonFromDepartment(Person person) {
        getDepartmentOfPerson(person).removeMember(person);
    }

    public void updatePerson(Person person, String fullName, String department) {
        String[] firstAndLastName = fullName.split(" ");
        person.setFirstName(firstAndLastName[0]);
        person.setLastName(firstAndLastName[1]);

        removePersonFromDepartment(person);
        addPersonToDepartment(person, department);
    }

    public static Facade getInstance() {
        if (instance != null) {
            instance = new Facade();
        }
        return instance;
    }
}