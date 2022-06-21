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
import java.util.Objects;
import java.util.Vector;

/**
 * This Facade contains all the functionalities for managing Persons and HRPersons
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

    /**
     * constructor
     */
    private PersonFacade() {
        company = JSONData.getInstance().getCompany();
        personListModels = new Vector<>();
        personFunctionComboboxModels = new Vector<>();
        personTeamComboboxModels = new Vector<>();
        hrPersonComboboxModels = new Vector<>();
    }

    /**
     * adds a given PersonListModel, so it is updated when the data changes
     *
     * @param personListModel to be added
     */
    public void addPersonListModel(PersonListModel personListModel) {
        personListModels.add(personListModel);
    }

    /**
     * removes a given PersonListModel, so it won't get update notification on changes
     *
     * @param personListModel to be removed
     */
    public void removePersonListModel(PersonListModel personListModel) {
        personListModels.remove(personListModel);
    }

    /**
     * adds a given PersonFunctionModel, so it is updated when the data changes
     *
     * @param personFunctionComboboxModel to be added
     */
    public void addPersonFunctionComboboxModel(PersonFunctionComboboxModel personFunctionComboboxModel) {
        personFunctionComboboxModels.add(personFunctionComboboxModel);
    }

    /**
     * removes a given PersonFunctionComboboxModel, so it won't get update notification on changes
     *
     * @param personFunctionComboboxModel to be removed
     */
    public void removePersonFunctionComboboxModel(PersonFunctionComboboxModel personFunctionComboboxModel) {
        personFunctionComboboxModels.remove(personFunctionComboboxModel);
    }

    /**
     * adds a given PersonTeamComboboxModel, so it is updated when the data changes
     *
     * @param personTeamComboboxModel to be added
     */
    public void addPersonTeamComboboxModel(PersonTeamComboboxModel personTeamComboboxModel) {
        personTeamComboboxModels.add(personTeamComboboxModel);
    }

    /**
     * removes a given PersonTeamComboboxModel, so it won't get update notification on changes
     *
     * @param personTeamComboboxModel to be removed
     */
    public void removePersonTeamComboboxModel(PersonTeamComboboxModel personTeamComboboxModel) {
        personTeamComboboxModels.remove(personTeamComboboxModel);
    }

    /**
     * adds a given HRPersonComboboxModel, so it is updated when the data changes
     *
     * @param hrPersonComboboxModel to be added
     */
    public void addHRPersonComboboxModel(HRPersonComboboxModel hrPersonComboboxModel) {
        hrPersonComboboxModels.add(hrPersonComboboxModel);
    }

    /**
     * removes a given HRPersonComboboxModel, so it won't get update notification on changes
     *
     * @param hrPersonComboboxModel to be removed
     */
    public void removeHRPersonComboboxModel(HRPersonComboboxModel hrPersonComboboxModel) {
        hrPersonComboboxModels.remove(hrPersonComboboxModel);
    }

    /**
     * gets all the Persons (HRPersons included)
     *
     * @return all the Persons (HRPersons included)
     */
    public Vector<Person> getAllPersons() {
        Vector<Person> persons = new Vector<>();
        for (Department department : DepartmentFacade.getInstance().getAllDepartments()) {
            persons.addAll(department.getAllMembers());
        }
        return persons;
    }

    /**
     * gets the number of Persons (HRPersons included)
     *
     * @return number of Persons (HRPersons included)
     */
    public int getNumberOfPersons() {
        return getAllPersons().size();
    }

    /**
     * gets a Person from all perons at a given index
     *
     * @param index of the person to get
     * @return person from perons at the given index
     */
    public Person getPersonAt(int index) {
        return getAllPersons().get(index);
    }

    /**
     * gets all the HRPersons
     *
     * @return all the HRPersons
     */
    public Vector<HRPerson> getAllHRPersons() {
        Vector<HRPerson> hrPersons = new Vector<>();
        for (Person person : getAllPersons()) {
            if (isHRPerson(person)) {
                hrPersons.add((HRPerson) person);
            }
        }
        return hrPersons;
    }

    /**
     * gets all Persons filtered by given filters of the name of the department, the function and the team
     *
     * if a parameter is an empty String that means the filter is set to all
     *
     * @param departmentName filter
     * @param function filter
     * @param team filter
     * @return Vector of type Person with Persons who match the given filters
     */
    public Vector<Person> getAllPersonWithFilter(String departmentName, String function, String team) {
        Vector<Person> persons = getAllPersons();
        if (!Objects.equals(departmentName, "")) {
            persons.removeIf(person -> getDepartmentNameOfPerson(person).equals(departmentName));
        }
        if (!Objects.equals(function, "")) {
            persons.removeIf(person -> !getFunctionsOfPerson(person).contains(function));
        }
        if (!Objects.equals(team, "")) {
            persons.removeIf(person -> !getTeamsOfPerson(person).contains(team));
        }
        return persons;
    }

    /**
     * gets the number of hrPersons
     *
     * @return number of HRPersons
     */
    public int getNumberOfHRPersons() {
        return getAllHRPersons().size();
    }

    /**
     * gets a HRPerson from all HRPersons at a given index
     *
     * @param index of the hrPerson
     * @return HRPerson from all HRPersons at the given index
     */
    public HRPerson getHRPersonAt(int index) {
        return getAllHRPersons().get(index);
    }

    /**
     * adds a new Person
     *
     * @param fullName of the person
     * @param department of the person
     * @param image of the person
     */
    public void addNewPerson(String fullName, Department department, Image image) {
        String[] firstAndLastName = fullName.split(" ");
        Person person = new Person(firstAndLastName[0], firstAndLastName[1], image);
        department.addMember(person);

        loggedInHRPerson.writeLogEntry(person, UserAction.CREATE_PERSON);
        fireChangesOnAllPersonListModels();
    }

    /**
     * adds a new Person
     *
     * @param firstName of the person
     * @param lastName of the person
     * @param department of the person
     * @param image of the person
     */
    public void addNewPerson(String firstName, String lastName, Department department, Image image) {
        Person person = new Person(firstName, lastName, image);
        department.addMember(person);

        loggedInHRPerson.writeLogEntry(person, UserAction.CREATE_PERSON);
        fireChangesOnAllPersonListModels();
    }

    /**
     * adds a new HRPerson
     *
     * @param fullName of the hrPerson
     * @param department of the hrPerson
     * @param image of the hrPerson
     * @param modus of the hrPerson
     * @param pwd of the hrPerson
     */
    public void addNewHRPerson(String fullName, Department department, Image image, int modus, String pwd) {
        String[] firstAndLastName = fullName.split(" ");
        HRPerson hrPerson = new HRPerson(firstAndLastName[0], firstAndLastName[1], image, modus);
        hrPerson.setPwd(pwd);

        department.addMember(hrPerson);
        loggedInHRPerson.writeLogEntry(hrPerson, UserAction.CREATE_PERSON);
        fireChangesOnAllPersonListModels();
        fireChangesOnAllHRPersonComboboxModels();
    }

    /**
     * adds a new HRPerson
     *
     * @param firstName of the hrPerson
     * @param lastName of the hrPerson
     * @param department of the hrPerson
     * @param image of the hrPerson
     * @param modus of the hrPerson
     * @param pwd of the hrPerson
     */
    public void addNewHRPerson(String firstName, String lastName, Department department, Image image, int modus, String pwd) {
        HRPerson hrPerson = new HRPerson(firstName, lastName, image, modus);
        hrPerson.setPwd(pwd);

        department.addMember(hrPerson);
        loggedInHRPerson.writeLogEntry(hrPerson, UserAction.CREATE_PERSON);
        fireChangesOnAllPersonListModels();
        fireChangesOnAllHRPersonComboboxModels();
    }

    /**
     * checks if a given Person is a HRPerson
     *
     * @param person to check
     * @return true if the given person is a HRPerson
     */
    public boolean isHRPerson(Person person) {
        return person instanceof HRPerson;
    }

    /**
     * checks if a given password matches the password from the given person
     *
     * @param hrPerson to check the password from
     * @param pwd to check
     * @return true if the given password matches the password of the given HRPerson
     */
    private boolean checkPassword(HRPerson hrPerson, String pwd) {
        return hrPerson.getPwd().equals(pwd);
    }

    /**
     * tries to log in a given HRPerson with a given password
     *
     * @param hrPerson to log in
     * @param pwd to authenticate
     * @return true when the login was successful
     */
    public boolean logInHRPerson(HRPerson hrPerson, String pwd) {
        if (checkPassword(hrPerson, pwd)) {
            loggedInHRPerson = hrPerson;
            return true;
        } else {
            return false;
        }
    }

    /**
     * checks if a HRPerson is logged in
     *
     * @return true when a HRPerson is logged in else false
     */
    public boolean isAHRPersonLoggedIn() {
        return getLoggedInHRPerson() != null;
    }

    /**
     * gets the logged in HRPerson
     *
     * @return logged in HRPerson
     */
    public HRPerson getLoggedInHRPerson() {
        return loggedInHRPerson;
    }

    /**
     * get all the functions of a given person
     *
     * @param person to get all the functions of a given person
     * @return all functions of a given person
     */
    public Vector<String> getFunctionsOfPerson(Person person) {
        return person.getParticipation().getAllFunctions();
    }

    /**
     * gets the number of functions of a given person
     *
     * @param person to get the number of functions from
     * @return number of functions of a given person
     */
    public int getNumberOfFunctionsOfPerson(Person person) {
        return person.getParticipation().getNumberOfFunctions();
    }

    /**
     * gets the function at a given index of a given person
     *
     * @param person to get the function at the given index
     * @param index of the function to get from the given person
     * @return function at the given index of the given person
     */
    public String getFunctionOfPerson(Person person, int index) {
        return person.getParticipation().getFunctionName(index);
    }

    /**
     * adds a given function to a given person
     *
     * @param person to which the given function is added
     * @param function to add to the given person
     */
    public void addFunctionToPerson(Person person, String function) {
        person.getParticipation().addFunction(function);
        loggedInHRPerson.writeLogEntry(person, UserAction.SET_ASSIGNMENT);
        fireChangesOnAllPersonFunctionComboboxModels();
    }

    /**
     * remove a given function from a given person
     *
     * @param person to remove the given function from
     * @param function to remove from a given person
     */
    public void removeFunctionOfPerson(Person person, String function) {
        person.getParticipation().removeJobFunction(function);
        loggedInHRPerson.writeLogEntry(person, UserAction.SET_ASSIGNMENT);
        fireChangesOnAllPersonFunctionComboboxModels();
    }

    /**
     * removes a function at a given index of a given person
     *
     * @param person to remove the function at a given index from
     * @param index of the function to remove from the given person
     */
    public void removeFunctionOfPerson(Person person, int index) {
        person.getParticipation().removeJobFunction(index);
        loggedInHRPerson.writeLogEntry(person, UserAction.SET_ASSIGNMENT);
        fireChangesOnAllPersonFunctionComboboxModels();
    }

    /**
     * gets all the teams from a given person
     *
     * @param person to get all the teams from
     * @return all teams from a given person
     */
    public Vector<String> getTeamsOfPerson (Person person) {
        return person.getParticipation().getAllTeams();
    }

    /**
     * gets the number of teams from a given person
     *
     * @param person to get the number of teams from
     * @return number of teams from a given person
     */
    public int getNumberOfTeamsOfPerson(Person person) {
        return person.getParticipation().getNumberOfTeams();
    }

    /**
     * gets the team at a given index of a given person
     *
     * @param person to get the team from
     * @param index of the team
     * @return team at the given index of the given person
     */
    public String getTeamOfPerson(Person person, int index) {
        return person.getParticipation().getTeamName(index);
    }

    /**
     * adds a team to the given person
     *
     * @param person to which the given team will be added
     * @param team to add to the given person
     */
    public void addTeamToPerson(Person person, String team) {
        person.getParticipation().addTeam(team);
        loggedInHRPerson.writeLogEntry(person, UserAction.SET_ASSIGNMENT);
        fireChangesOnAllPersonTeamComboboxModels();
    }

    /**
     * removes a team at the given index of a given person
     *
     * @param person to remove the team from
     * @param index of the team to be removed from the given person
     */
    public void removeTeamOfPerson(Person person, int index) {
        person.getParticipation().removeTeam(index);
        loggedInHRPerson.writeLogEntry(person, UserAction.SET_ASSIGNMENT);
        fireChangesOnAllPersonTeamComboboxModels();
    }

    /**
     * removes a given team from a given person
     *
     * @param person to remove the given team from
     * @param team to remove from the given person
     */
    public void removeTeamOfPerson(Person person, String team) {
        person.getParticipation().removeTeam(team);
        loggedInHRPerson.writeLogEntry(person, UserAction.SET_ASSIGNMENT);
        fireChangesOnAllPersonTeamComboboxModels();
    }

    /**
     * gets the name of the department of a given person
     *
     * @param person to get the name of the department from
     * @return name of the department of the given person
     */
    public String getDepartmentNameOfPerson(Person person) {
        Department department = getDepartmentOfPerson(person);
        if (department == null) {
            return null;
        }
        return department.getName();
    }

    /**
     * gets the department of a given person
     *
     * @param person to get the department from
     * @return department of the given person
     */
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

    /**
     * adds a person to a given department
     *
     * @param person to be added
     * @param departmentName to which the person is added
     */
    private void addPersonToDepartment(Person person, Department departmentName) {
        departmentName.addMember(person);
        fireChangesOnAllPersonListModels();
    }

    /**
     * removes a given person of its department
     *
     * @apiNote when no reference is stored elsewhere calling this method wil result in the person being deleted
     *
     * @param person to be removed
     */
    private void removePersonFromDepartment(Person person) {
        getDepartmentOfPerson(person).removeMember(person);
        fireChangesOnAllPersonListModels();
    }

    /**
     * updates a given Person with the given parameter values
     *
     * @param person to be updated
     * @param newFullName of the person
     * @param newDepartment of the person
     */
    public void updatePerson(Person person, String newFullName, Department newDepartment) {
        String[] firstAndLastName = newFullName.split(" ");
        person.setFirstName(firstAndLastName[0]);
        person.setLastName(firstAndLastName[1]);
        loggedInHRPerson.writeLogEntry(person, UserAction.CHANGE_VALUE);

        removePersonFromDepartment(person);
        addPersonToDepartment(person, newDepartment);
        loggedInHRPerson.writeLogEntry(person, UserAction.SET_ASSIGNMENT);
        fireChangesOnAllPersonListModels();
    }

    /**
     * updates a given Person with the given parameter values
     *
     * @param person to be updated
     * @param newFirstName of the person
     * @param newLastName of the person
     * @param newDepartment of the person
     */
    public void updatePerson(Person person, String newFirstName, String newLastName, Department newDepartment) {
        person.setFirstName(newFirstName);
        person.setLastName(newLastName);
        loggedInHRPerson.writeLogEntry(person, UserAction.CHANGE_VALUE);

        removePersonFromDepartment(person);
        addPersonToDepartment(person, newDepartment);
        loggedInHRPerson.writeLogEntry(person, UserAction.SET_ASSIGNMENT);
        fireChangesOnAllPersonListModels();
    }

    /**
     * updates a given HRPerson with the given parameter values
     *
     * @param hrPerson to be updates
     * @param newFullName of the hrPerson
     * @param newDepartment of the hrPerson
     * @param newModus of the hrPerson
     */
    public void updateHRPerson(
            HRPerson hrPerson,
            String newFullName,
            Department newDepartment,
            int newModus
    ) {
        String[] firstAndLastName = newFullName.split(" ");
        hrPerson.setFirstName(firstAndLastName[0]);
        hrPerson.setLastName(firstAndLastName[1]);
        hrPerson.setModus(newModus);
        loggedInHRPerson.writeLogEntry(hrPerson, UserAction.CHANGE_VALUE);

        removePersonFromDepartment(hrPerson);
        addPersonToDepartment(hrPerson, newDepartment);
        loggedInHRPerson.writeLogEntry(hrPerson, UserAction.SET_ASSIGNMENT);
        fireChangesOnAllPersonListModels();
        fireChangesOnAllHRPersonComboboxModels();
    }

    /**
     * updates a given HRPerson with the given parameter values
     *
     * @param hrPerson to be updated
     * @param newFirstName of the hrPerson
     * @param newLastName of the hrPerson
     * @param newDepartment of the hrPerson
     * @param newModus of the hrPerson
     */
    public void updateHRPerson(
            HRPerson hrPerson,
            String newFirstName,
            String newLastName,
            Department newDepartment,
            int newModus
    ) {
        hrPerson.setFirstName(newFirstName);
        hrPerson.setLastName(newLastName);
        hrPerson.setModus(newModus);
        loggedInHRPerson.writeLogEntry(hrPerson, UserAction.CHANGE_VALUE);

        removePersonFromDepartment(hrPerson);
        addPersonToDepartment(hrPerson, newDepartment);
        loggedInHRPerson.writeLogEntry(hrPerson, UserAction.SET_ASSIGNMENT);
        fireChangesOnAllPersonListModels();
        fireChangesOnAllHRPersonComboboxModels();
    }

    /**
     * notifies all registered PersonListModels of changes
     */
    private void fireChangesOnAllPersonListModels() {
        for (PersonListModel listModel : personListModels) {
            listModel.fireContentsChanged(this, 0, getNumberOfPersons());
        }
    }

    /**
     * notifies all registered PersonTeamComboboxModels of changes
     */
    private void fireChangesOnAllPersonTeamComboboxModels() {
        for (PersonTeamComboboxModel comboboxModel : personTeamComboboxModels) {
            comboboxModel.fireContentsChanged(
                    this,
                    0,
                    getNumberOfFunctionsOfPerson(comboboxModel.getPerson())
            );
        }
    }

    /**
     * notifies all registered PersonFunctionComboboxModels of changes
     */
    private void fireChangesOnAllPersonFunctionComboboxModels() {
        for (PersonFunctionComboboxModel comboboxModel : personFunctionComboboxModels) {
            comboboxModel.fireContentsChanged(
                    this,
                    0,
                    getNumberOfFunctionsOfPerson(comboboxModel.getPerson())
            );
        }
    }

    /**
     * notifies all registered HRPersonComboboxModels of changes
     */
    private void fireChangesOnAllHRPersonComboboxModels() {
        for (HRPersonComboboxModel comboboxModel : hrPersonComboboxModels) {
            comboboxModel.fireContentsChanged(this, 0, getNumberOfHRPersons());
        }
    }

    /**
     * returns the instance of the PersonFacade class according to the singleton pattern
     *
     * @return the instance
     */
    public static PersonFacade getInstance() {
        if (instance == null) {
            instance = new PersonFacade();
        }
        return instance;
    }
}