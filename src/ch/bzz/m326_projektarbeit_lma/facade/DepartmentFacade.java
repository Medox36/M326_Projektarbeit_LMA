package ch.bzz.m326_projektarbeit_lma.facade;

import ch.bzz.m326_projektarbeit_lma.company.Company;
import ch.bzz.m326_projektarbeit_lma.company.Department;
import ch.bzz.m326_projektarbeit_lma.data.JSONData;

import java.util.Vector;

public class DepartmentFacade {
    private static DepartmentFacade instance;
    private Company company;

    private DepartmentFacade() {
        company = JSONData.getInstance().getCompany();
    }

    public Vector<Department> getAllDepartments() {
        return company.getAllDepartments();
    }

    public Vector<String> getAllDepartmentNames() {
        return company.getDepartmentsName();
    }

    public Department getDepartment(int index) {
        return company.getDepartment(index);
    }

    public void addDepartment(String name) {
        company.addDepartment(new Department(name));
    }

    public void removeDepartment(Department department) {
        company.removeDepartment(department);
    }

    public Vector<Department> searchDepartments(String filter) {
        Vector<Department> departments = new Vector<>();
        for (Department department : getAllDepartments()) {
            if (department.getName().contains(filter)) {
                departments.add(department);
            }
        }
        return departments;
    }

    public static DepartmentFacade getInstance() {
        if (instance != null) {
            instance = new DepartmentFacade();
        }
        return instance;
    }
}