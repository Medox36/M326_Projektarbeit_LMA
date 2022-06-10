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
 *
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

    public Company() {
    }

    public Company(@JsonProperty("name") String name) {
        this.name = name;
        departments = new Vector<>();
        functions = new JobFunctions();
        teams = new Teams();
    }

    @JsonIgnore
    public String getCompanyName() {
        return name;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    @JsonIgnore
    public Vector<Department> getAllDepartments() {
        return departments;
    }

    public Department getDepartement(int index) {
        return departments.get(index);
    }

    @JsonIgnore
    public String getDepartmentName(int index) {
        return departments.get(index).getName();
    }

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

    @JsonIgnore
    public List<Department> getDepartmentsNameList() {
        return new ArrayList<>(departments);
    }

    public void removeDepartment(int index) {
        departments.remove(index);
    }

    public void removeDepartment(Department department) {
        departments.remove(department);
    }

    @JsonIgnore
    public int getNumberOfDepartments() {
        return departments.size();
    }

    public JobFunctions getFunctions() {
        return functions;
    }

    public Teams getTeams() {
        return teams;
    }
}