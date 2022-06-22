package ch.bzz.m326_projektarbeit_lma.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * The company has a name and multiple departments. It also stores all the JobFunctions and Teams
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.01
 * @version 1.1
 */
@Getter
@Setter
public class Company {

    private String name;
    private Vector<Department> departments;
    private JobFunctions functions;
    private Teams teams;

    /**
     * constructor
     *
     * @param name of the company
     */
    public Company(@JsonProperty("name") String name) {
        this.name = name;
        departments = new Vector<>();
        functions = new JobFunctions();
        teams = new Teams();
    }

    /**
     * gets the name
     *
     * @return the name
     */
    @JsonIgnore
    public String getCompanyName() {
        return name;
    }

    /**
     * sets the name
     *
     * @param name to set
     */
    @JsonIgnore
    public void setCompanyName(String name) {
        this.name = name;
    }

    /**
     * adds a given department
     *
     * @param department to be added
     */
    public void addDepartment(Department department) {
        departments.add(department);
    }

    /**
     * gets all departments
     *
     * @return all departments in Vector type Department
     */
    @JsonIgnore
    public Vector<Department> getAllDepartments() {
        return departments;
    }

    /**
     * gets a department at a given index
     *
     * @param index of the department
     * @return the department
     */
    public Department getDepartment(int index) {
        return departments.get(index);
    }

    /**
     * gets the dame of a department at a given index
     *
     * @param index of the department
     * @return the name of the department
     */
    @JsonIgnore
    public String getDepartmentName(int index) {
        return departments.get(index).getName();
    }

    /**
     * gets all names of all departments
     *
     * @return all names of all departments in Vector of type String
     */
    @JsonIgnore
    public Vector<String> getDepartmentsName() {
        Vector<String> names = new Vector<>();

        Iterator<Department> it = departments.iterator();
        if (! it.hasNext()) {
            return names;
        }

        for (;;) {
            Department d = it.next();
            names.add(d.getName());
            if (!it.hasNext()) {
                return names;
            }
        }
    }

    /**
     * gets all the names of all departments
     *
     * @return all the names of all departments in Vector of type String
     */
    @JsonIgnore
    public List<Department> getDepartmentsNameList() {
        return new ArrayList<>(departments);
    }

    /**
     * removes a department at a given index
     *
     * @param index of the department
     */
    public void removeDepartment(int index) {
        departments.remove(index);
    }

    /**
     * removes the given department
     *
     * @param department to be removed
     */
    public void removeDepartment(Department department) {
        departments.remove(department);
    }

    /**
     * gets the number of departments
     *
     * @return number of departments
     */
    @JsonIgnore
    public int getNumberOfDepartments() {
        return departments.size();
    }

    /**
     * gets the job functions
     *
     * @return job functions
     */
    public JobFunctions getFunctions() {
        return functions;
    }

    /**
     * gets the teams
     *
     * @return teams
     */
    public Teams getTeams() {
        return teams;
    }
}