package ch.bzz.m326_projektarbeit_lma.facade;

import ch.bzz.m326_projektarbeit_lma.company.Company;
import ch.bzz.m326_projektarbeit_lma.company.Department;
import ch.bzz.m326_projektarbeit_lma.data.JSONData;
import ch.bzz.m326_projektarbeit_lma.gui.model.DepartmentComboboxModel;

import java.util.Vector;

/**
 *
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.17
 * @version 1.3
 */
public class DepartmentFacade {
    private static DepartmentFacade instance;
    private Company company;
    private Vector<DepartmentComboboxModel> departmentComboboxModels;

    private DepartmentFacade() {
        company = JSONData.getInstance().getCompany();
        departmentComboboxModels = new Vector<>();
    }

    public void addDepartmentComboboxModel(DepartmentComboboxModel departmentComboboxModel) {
        departmentComboboxModels.add(departmentComboboxModel);
    }

    public void removeDepartmentComboboxModel(DepartmentComboboxModel departmentComboboxModel) {
        departmentComboboxModels.remove(departmentComboboxModel);
    }

    public Vector<Department> getAllDepartments() {
        return company.getAllDepartments();
    }

    public int getNumberOfDepartments() {
        return company.getNumberOfDepartments();
    }

    public Vector<String> getAllDepartmentNames() {
        return company.getDepartmentsName();
    }

    public Department getDepartment(int index) {
        return company.getDepartment(index);
    }

    public void addDepartment(String name) {
        company.addDepartment(new Department(name));
        fireChangesOnAllCompanyComboboxModels();
    }

    public void removeDepartment(Department department) {
        company.removeDepartment(department);
        fireChangesOnAllCompanyComboboxModels();
    }

    private void fireChangesOnAllCompanyComboboxModels() {
        for (DepartmentComboboxModel departmentComboboxModel : departmentComboboxModels) {
            departmentComboboxModel.fireContentsChanged(this, 0, getNumberOfDepartments());
        }
    }

    public static DepartmentFacade getInstance() {
        if (instance == null) {
            instance = new DepartmentFacade();
        }
        return instance;
    }
}