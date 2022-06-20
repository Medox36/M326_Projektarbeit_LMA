package ch.bzz.m326_projektarbeit_lma.facade;

import ch.bzz.m326_projektarbeit_lma.company.Company;
import ch.bzz.m326_projektarbeit_lma.company.Department;
import ch.bzz.m326_projektarbeit_lma.data.JSONData;
import ch.bzz.m326_projektarbeit_lma.employees.HRPerson;
import ch.bzz.m326_projektarbeit_lma.employees.Person;
import ch.bzz.m326_projektarbeit_lma.gui.model.HRPersonComboboxModel;
import ch.bzz.m326_projektarbeit_lma.gui.model.PersonFunctionComboboxModel;
import ch.bzz.m326_projektarbeit_lma.gui.model.PersonListModel;
import ch.bzz.m326_projektarbeit_lma.gui.model.PersonTeamComboboxModel;
import ch.bzz.m326_projektarbeit_lma.log.UserAction;

import java.awt.*;
import java.util.Vector;

/**
 *
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.08
 * @version 1.3
 */
public class PersonFacade {
    private static PersonFacade instance;
    private Company company;
    private HRPerson loggedInHRPerson = null;

    private Vector<PersonListModel> personListModels;
    private Vector<PersonFunctionComboboxModel> personFunctionComboboxModels;
    private Vector<PersonTeamComboboxModel> personTeamComboboxModels;
    private Vector<HRPersonComboboxModel> hrPersonComboboxModels;

    private PersonFacade() {
        company = JSONData.getInstance().getCompany();
        personListModels = new Vector<>();
        personFunctionComboboxModels = new Vector<>();
        personTeamComboboxModels = new Vector<>();
        hrPersonComboboxModels = new Vector<>();
    }

    public void addPersonListModel(PersonListModel personListModel) {
        personListModels.add(personListModel);
    }

    public void removePersonListModel(PersonListModel personListModel) {
        personListModels.remove(personListModel);
    }

    public void addPersonFunctionComboboxModel(PersonFunctionComboboxModel personFunctionComboboxModel) {
        personFunctionComboboxModels.add(personFunctionComboboxModel);
    }

    public void removePersonFunctionComboboxModel(PersonFunctionComboboxModel personFunctionComboboxModel) {
        personFunctionComboboxModels.remove(personFunctionComboboxModel);
    }

    public void addPersonTeamComboboxModel(PersonTeamComboboxModel personTeamComboboxModel) {
        personTeamComboboxModels.add(personTeamComboboxModel);
    }

    public void removePersonTeamComboboxModel(PersonTeamComboboxModel personTeamComboboxModel) {
        personTeamComboboxModels.remove(personTeamComboboxModel);
    }

    public void addHRPersonComboboxModel(HRPersonComboboxModel hrPersonComboboxModel) {
        hrPersonComboboxModels.add(hrPersonComboboxModel);
    }

    public void removeHRPersonComboboxModel(HRPersonComboboxModel hrPersonComboboxModel) {
        hrPersonComboboxModels.remove(hrPersonComboboxModel);
    }

    public Vector<Person> getAllPersons() {
        Vector<Person> persons = new Vector<>();
        for (Department department : DepartmentFacade.getInstance().getAllDepartments()) {
            persons.addAll(department.getAllMembers());
        }
        return persons;
    }

    public int getNumberOfPersons() {
        return getAllPersons().size();
    }

    public Person getPersonAt(int index) {
        return getAllPersons().get(index);
    }

    public Vector<HRPerson> getAllHRPersons() {
        Vector<HRPerson> hrPersons = new Vector<>();
        for (Person person : getAllPersons()) {
            if (isHRPerson(person)) {
                hrPersons.add((HRPerson) person);
            }
        }
        return hrPersons;
    }

    public int getNumberOfHRPersons() {
        return getAllHRPersons().size();
    }

    public HRPerson getHRPersonAt(int index) {
        return getAllHRPersons().get(index);
    }

    public void addNewPerson(String fullName, Department department, Image image) {
        String[] firstAndLastName = fullName.split(" ");
        Person person = new Person(firstAndLastName[0], firstAndLastName[1], image);
        department.addMember(person);

        loggedInHRPerson.writeLogEntry(person, UserAction.CREATE_PERSON);
        fireChangesOnAllListModels();
    }

    public void addNewPerson(String firstName, String lastName, Department department, Image image) {
        Person person = new Person(firstName, lastName, image);
        department.addMember(person);

        loggedInHRPerson.writeLogEntry(person, UserAction.CREATE_PERSON);
        fireChangesOnAllListModels();
    }

    public void addNewHRPerson(String fullName, Department department, Image image, int modus, String pwd) {
        String[] firstAndLastName = fullName.split(" ");
        HRPerson hrPerson = new HRPerson(firstAndLastName[0], firstAndLastName[1], image, modus);
        hrPerson.setPwd(pwd);

        department.addMember(hrPerson);
        loggedInHRPerson.writeLogEntry(hrPerson, UserAction.CREATE_PERSON);
        fireChangesOnAllListModels();
        fireChangesOnAllHRPersonComboboxModels();
    }

    public void addNewHRPerson(String firstName, String lastName, Department department, Image image, int modus, String pwd) {
        HRPerson hrPerson = new HRPerson(firstName, lastName, image, modus);
        hrPerson.setPwd(pwd);

        department.addMember(hrPerson);
        loggedInHRPerson.writeLogEntry(hrPerson, UserAction.CREATE_PERSON);
        fireChangesOnAllListModels();
        fireChangesOnAllHRPersonComboboxModels();
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

    public boolean logInHRPerson(HRPerson hrPerson) {
        if (checkPassword(hrPerson, hrPerson.getPwd())) {
            loggedInHRPerson = hrPerson;
            return true;
        } else {
            return false;
        }
    }

    public boolean isAHRPersonLoggedIn() {
        return loggedInHRPerson != null;
    }

    public HRPerson getLoggedInHRPerson() {
        return loggedInHRPerson;
    }

    public Vector<String> getFunctionsOfPerson(Person person) {
        return person.getParticipation().getAllFunctions();
    }

    public int getNumberOfFunctionsOfPerson(Person person) {
        return person.getParticipation().getNumberOfFunctions();
    }

    public String getFunctionOfPerson(Person person, int index) {
        return person.getParticipation().getFunctionName(index);
    }

    public void addFunctionToPerson(Person person, String function) {
        person.getParticipation().addFunction(function);
        loggedInHRPerson.writeLogEntry(person, UserAction.SET_ASSIGNMENT);
        fireChangesOnAllFunctionComboboxModels();
    }

    public void removeFunctionOfPerson(Person person, String function) {
        person.getParticipation().removeJobFunction(function);
        loggedInHRPerson.writeLogEntry(person, UserAction.SET_ASSIGNMENT);
        fireChangesOnAllFunctionComboboxModels();
    }

    public void removeFunctionOfPerson(Person person, int index) {
        person.getParticipation().removeJobFunction(index);
        loggedInHRPerson.writeLogEntry(person, UserAction.SET_ASSIGNMENT);
        fireChangesOnAllFunctionComboboxModels();
    }

    public Vector<String> getTeamsOfPerson (Person person) {
        return person.getParticipation().getAllTeams();
    }

    public int getNumberOfTeamsOfPerson(Person person) {
        return person.getParticipation().getNumberOfTeams();
    }

    public String getTeamOfPerson(Person person, int index) {
        return person.getParticipation().getTeamName(index);
    }

    public void addTeamToPerson(Person person, String team) {
        person.getParticipation().addTeam(team);
        loggedInHRPerson.writeLogEntry(person, UserAction.SET_ASSIGNMENT);
        fireChangesOnAllTeamComboboxModels();
    }

    public void removeTeamOfPerson(Person person, int index) {
        person.getParticipation().removeTeam(index);
        loggedInHRPerson.writeLogEntry(person, UserAction.SET_ASSIGNMENT);
        fireChangesOnAllTeamComboboxModels();
    }

    public void removeTeamOfPerson(Person person, String team) {
        person.getParticipation().removeTeam(team);
        loggedInHRPerson.writeLogEntry(person, UserAction.SET_ASSIGNMENT);
        fireChangesOnAllTeamComboboxModels();
    }

    public String getDepartmentNameOfPerson(Person person) {
        Department department = getDepartmentOfPerson(person);
        if (department == null) {
            return null;
        }
        return department.getName();
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
        fireChangesOnAllListModels();
    }

    private void removePersonFromDepartment(Person person) {
        getDepartmentOfPerson(person).removeMember(person);
        fireChangesOnAllListModels();
    }

    public void updatePerson(Person person, String newFullName, Department newDepartment) {
        String[] firstAndLastName = newFullName.split(" ");
        person.setFirstName(firstAndLastName[0]);
        person.setLastName(firstAndLastName[1]);
        loggedInHRPerson.writeLogEntry(person, UserAction.CHANGE_VALUE);

        removePersonFromDepartment(person);
        addPersonToDepartment(person, newDepartment);
        loggedInHRPerson.writeLogEntry(person, UserAction.SET_ASSIGNMENT);
        fireChangesOnAllListModels();
    }

    public void updatePerson(Person person, String newFirstName, String newLastName, Department newDepartment) {
        person.setFirstName(newFirstName);
        person.setLastName(newLastName);
        loggedInHRPerson.writeLogEntry(person, UserAction.CHANGE_VALUE);

        removePersonFromDepartment(person);
        addPersonToDepartment(person, newDepartment);
        loggedInHRPerson.writeLogEntry(person, UserAction.SET_ASSIGNMENT);
        fireChangesOnAllListModels();
    }

    private void fireChangesOnAllListModels() {
        for (PersonListModel listModel : personListModels) {
            listModel.fireContentsChanged(this, 0, getNumberOfPersons());
        }
    }

    private void fireChangesOnAllTeamComboboxModels() {
        for (PersonTeamComboboxModel comboboxModel : personTeamComboboxModels) {
            comboboxModel.fireContentsChanged(
                    this,
                    0,
                    getNumberOfFunctionsOfPerson(comboboxModel.getPerson())
            );
        }
    }

    private void fireChangesOnAllFunctionComboboxModels() {
        for (PersonFunctionComboboxModel comboboxModel : personFunctionComboboxModels) {
            comboboxModel.fireContentsChanged(
                    this,
                    0,
                    getNumberOfFunctionsOfPerson(comboboxModel.getPerson())
            );
        }
    }

    private void fireChangesOnAllHRPersonComboboxModels() {
        for (HRPersonComboboxModel comboboxModel : hrPersonComboboxModels) {
            comboboxModel.fireContentsChanged(this, 0, getNumberOfHRPersons());
        }
    }

    public static PersonFacade getInstance() {
        if (instance != null) {
            instance = new PersonFacade();
        }
        return instance;
    }
}