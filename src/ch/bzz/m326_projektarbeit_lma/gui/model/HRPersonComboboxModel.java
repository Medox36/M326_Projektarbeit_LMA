package ch.bzz.m326_projektarbeit_lma.gui.model;

import ch.bzz.m326_projektarbeit_lma.employees.HRPerson;
import ch.bzz.m326_projektarbeit_lma.facade.PersonFacade;

import javax.swing.*;

/**
 *
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.20
 * @version 1.0
 */
public class HRPersonComboboxModel<E> extends AbstractListModel<HRPerson> implements ComboBoxModel<HRPerson> {

    private HRPerson selection = null;

    public HRPersonComboboxModel() {
        PersonFacade.getInstance().addHRPersonComboboxModel(this);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selection = (HRPerson) anItem;
    }

    @Override
    public HRPerson getSelectedItem() {
        return selection;
    }

    @Override
    public int getSize() {
        return PersonFacade.getInstance().getNumberOfHRPersons();
    }

    @Override
    public HRPerson getElementAt(int index) {
        return PersonFacade.getInstance().getHRPersonAt(index);
    }

    @Override
    public void fireContentsChanged(Object source, int index0, int index1) {
        super.fireContentsChanged(source, index0, index1);
    }

    public void remove() {
        PersonFacade.getInstance().removeHRPersonComboboxModel(this);
    }
}