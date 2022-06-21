package ch.bzz.m326_projektarbeit_lma.gui.model;

import ch.bzz.m326_projektarbeit_lma.company.Department;
import ch.bzz.m326_projektarbeit_lma.facade.DepartmentFacade;

import javax.swing.*;

/**
 * A custom ListModel for visualizing Departments
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.21
 * @version 1.0
 */
public class DepartmentListModel extends AbstractListModel<Department> {

    /**
     * constructor
     */
    public DepartmentListModel() {
        DepartmentFacade.getInstance().addDepartmentListModel(this);
    }

    @Override
    public int getSize() {
        return DepartmentFacade.getInstance().getNumberOfDepartments();
    }

    @Override
    public Department getElementAt(int index) {
        return DepartmentFacade.getInstance().getDepartment(index);
    }

    @Override
    public void fireContentsChanged(Object source, int index0, int index1) {
        super.fireContentsChanged(source, index0, index1);
    }

    /**
     * removes this model from the Facade register, so it stops getting fireContentsChanged notifications
     * and can be safely deleted
     *
     * @apiNote this method should be called every time a model isn't used anymore
     */
    public void remove() {
        DepartmentFacade.getInstance().removeDepartmentListModel(this);
    }
}