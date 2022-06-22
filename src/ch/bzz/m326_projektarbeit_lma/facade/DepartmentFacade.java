package ch.bzz.m326_projektarbeit_lma.facade;

import ch.bzz.m326_projektarbeit_lma.company.Company;
import ch.bzz.m326_projektarbeit_lma.company.Department;
import ch.bzz.m326_projektarbeit_lma.data.JSONData;
import ch.bzz.m326_projektarbeit_lma.gui.model.DepartmentComboboxModel;
import ch.bzz.m326_projektarbeit_lma.gui.model.DepartmentListModel;

import java.util.Vector;

/**
 * This Facade contains all the functionalities for managing Departments
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.17
 * @version 1.3
 */
public class DepartmentFacade {
    private static DepartmentFacade instance;
    private Company company;
    private Vector<DepartmentComboboxModel> departmentComboboxModels;
    private Vector<DepartmentListModel> departmentListModels;

    /**
     * constructor
     * is private because of singleton pattern
     */
    private DepartmentFacade() {
        company = JSONData.getInstance().getCompany();
        departmentComboboxModels = new Vector<>();
        departmentListModels = new Vector<>();
    }

    /**
     * adds a given DepartmentComboboxModel, so it is updated when the data changes
     *
     * @param departmentComboboxModel to be added
     */
    public void addDepartmentComboboxModel(DepartmentComboboxModel departmentComboboxModel) {
        departmentComboboxModels.add(departmentComboboxModel);
    }

    /**
     * removes a given DepartmentComboboxModel, so it won't get update notification on changes
     *
     * @param departmentComboboxModel to be removed
     */
    public void removeDepartmentComboboxModel(DepartmentComboboxModel departmentComboboxModel) {
        departmentComboboxModels.remove(departmentComboboxModel);
    }

    /**
     * adds a given DepartmentListModel, so it is updated when the data changes
     *
     * @param departmentListModel to be added
     */
    public void addDepartmentListModel(DepartmentListModel departmentListModel) {
        departmentListModels.add(departmentListModel);
    }

    /**
     * removes a given DepartmentComboboxModel, so it won't get update notification on changes
     *
     * @param departmentListModel to be removed
     */
    public void removeDepartmentListModel(DepartmentListModel departmentListModel) {
        departmentListModels.remove(departmentListModel);
    }

    /**
     * gets all departments
     *
     * @return all departments
     */
    public Vector<Department> getAllDepartments() {
        return company.getAllDepartments();
    }

    /**
     * gets the number of departments
     *
     * @return number of departments
     */
    public int getNumberOfDepartments() {
        return company.getNumberOfDepartments();
    }

    /**
     * gets the department at a given index
     *
     * @param index of the department
     * @return department at given index
     */
    public Department getDepartment(int index) {
        return company.getDepartment(index);
    }

    /**
     * adds a new Department
     *
     * @param name of the new department
     */
    public void addDepartment(String name) {
        company.addDepartment(new Department(name));
        fireChangesOnAllDepartmentComboboxModels();
        fireChangesOnAllDepartmentListModels();
    }

    /**
     * removes a given department
     *
     * @param department to be removed
     */
    public void removeDepartment(Department department) {
        company.removeDepartment(department);
        fireChangesOnAllDepartmentComboboxModels();
        fireChangesOnAllDepartmentListModels();
    }

    /**
     * updates the name of the department to the newValue
     *
     * @param department to change the name of
     * @param newValue to set
     */
    public void updateDepartment(Department department, String newValue) {
        department.setName(newValue);
        fireChangesOnAllDepartmentComboboxModels();
        fireChangesOnAllDepartmentListModels();
    }

    /**
     * notifies all registered DepartmentComboboxModels of changes
     */
    private void fireChangesOnAllDepartmentComboboxModels() {
        for (DepartmentComboboxModel departmentComboboxModel : departmentComboboxModels) {
            departmentComboboxModel.fireContentsChanged(this, 0, getNumberOfDepartments());
        }
    }

    /**
     * notifies all registered DepartmentListModels of changes
     */
    private void fireChangesOnAllDepartmentListModels() {
        for (DepartmentListModel listModel : departmentListModels) {
            listModel.fireContentsChanged(this, 0, getNumberOfDepartments());
        }
    }

    /**
     * returns the instance of the DepartmentFacade class according to the singleton pattern
     *
     * @return the instance
     */
    public static DepartmentFacade getInstance() {
        if (instance == null) {
            instance = new DepartmentFacade();
        }
        return instance;
    }
}