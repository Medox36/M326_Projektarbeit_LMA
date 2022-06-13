package ch.bzz.m326_projektarbeit_lma.facade;

import ch.bzz.m326_projektarbeit_lma.company.Company;
import ch.bzz.m326_projektarbeit_lma.company.Department;
import ch.bzz.m326_projektarbeit_lma.data.JSONData;
import ch.bzz.m326_projektarbeit_lma.employees.HRPerson;
import ch.bzz.m326_projektarbeit_lma.employees.Person;

import java.awt.*;
import java.util.Vector;

/**
 *
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.08
 * @version 1.2
 */
public class Facade {
    private static Facade instance;
    private Company company;

    private Facade() {
        company = JSONData.getInstance().getCompany();
    }

    public Vector<Person> getAllPersons() {
        Vector<Person> persons = new Vector<>();
        for (Department department : getAllDepartments()) {
            persons.addAll(department.getAllMembers());
        }
        return persons;
    }

    public void addNewPerson(String fullName, Department department, Image image) {
        String[] firstAndLastName = fullName.split(" ");
        Person person = new Person(firstAndLastName[0], firstAndLastName[1], image);
        department.addMember(person);
    }

    public void addNewHRPerson(String fullName, Department department, Image image, int modus, String pwd) {
        String[] firstAndLastName = fullName.split(" ");
        HRPerson hrPerson = new HRPerson(firstAndLastName[0], firstAndLastName[1], image, modus);
        hrPerson.setPwd(pwd);

        department.addMember(hrPerson);
    }

    public boolean isHRPerson(Person person) {
        return person instanceof HRPerson;
    }

    private boolean checkPassword(Person person, String pwd) {
        if (isHRPerson(person)) {
            HRPerson hrPerson = (HRPerson) person;
            return hrPerson.getPwd().equals(pwd);
        } else {
            return false;
        }
    }

    public Vector<Department> getAllDepartments() {
        return company.getAllDepartments();
    }

    public Vector<String> getAllDepartmentNames() {
        return company.getDepartmentsName();
    }

    public Department getDepartment(int index) {
        return getAllDepartments().get(index);
    }

    public void addDepartment(String name) {
        company.addDepartment(new Department(name));
    }

    public void removeDepartment(Department department) {
        company.removeDepartment(department);
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

    public String getFunction(int index) {
        return company.getFunctions().getJobFunction(index);
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

    public String getTeam(int index) {
        return company.getTeams().getTeam(index);
    }

    public Vector<String> getFunctionsOfPerson(Person person) {
        return person.getParticipation().getAllFunctions();
    }

    public String getFunctionOfPerson(Person person, int index) {
        return person.getParticipation().getFunctionName(index);
    }

    public void addFunctionToPerson(Person person, String function) {
        person.getParticipation().addFunction(function);
    }

    public void removeFunctionOfPerson(Person person, String function) {
        person.getParticipation().removeJobFunction(function);
    }

    public void removeFunctionOfPerson(Person person, int index) {
        person.getParticipation().removeJobFunction(index);
    }

    public Vector<String> getTeamsOfPerson (Person person) {
        return person.getParticipation().getAllTeams();
    }

    public String getTeamOfPerson(Person person, int index) {
        return person.getParticipation().getTeamName(index);
    }

    public void addTeamToPerson(Person person, String team) {
        person.getParticipation().addTeam(team);
    }

    public void removeTeamOfPerson(Person person, int index) {
        person.getParticipation().removeTeam(index);
    }

    public void removeTeamOfPerson(Person person, String team) {
        person.getParticipation().removeTeam(team);
    }

    public String getDepartmentNameOfPerson(Person person) {
        return getDepartmentOfPerson(person).getName();
    }

    public Department getDepartmentOfPerson(Person person) {
        for (Department department : company.getAllDepartments()) {
            for (Person person1 : department.getAllMembers()) {
                if (person1.equals(person)) {
                    return department;
                }
            }
        }
        return null;
    }

    private void addPersonToDepartment(Person person, Department departmentName) {
        departmentName.addMember(person);
    }

    private void removePersonFromDepartment(Person person) {
        getDepartmentOfPerson(person).removeMember(person);
    }

    public void updatePerson(Person person, String newFullName, Department newDepartment) {
        String[] firstAndLastName = newFullName.split(" ");
        person.setFirstName(firstAndLastName[0]);
        person.setLastName(firstAndLastName[1]);

        removePersonFromDepartment(person);
        addPersonToDepartment(person, newDepartment);
    }

    public static Facade getInstance() {
        if (instance != null) {
            instance = new Facade();
        }
        return instance;
    }
}