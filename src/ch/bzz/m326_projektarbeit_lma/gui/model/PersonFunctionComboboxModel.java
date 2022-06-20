package ch.bzz.m326_projektarbeit_lma.gui.model;

import ch.bzz.m326_projektarbeit_lma.employees.Person;
import ch.bzz.m326_projektarbeit_lma.facade.PersonFacade;

import javax.swing.*;

/**
 *
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.20
 * @version 1.0
 */
public class PersonFunctionComboboxModel extends AbstractListModel<String> implements ComboBoxModel<String> {

    private String selection = null;
    private Person person;

    public PersonFunctionComboboxModel(Person person) {
        this.person = person;
        PersonFacade.getInstance().addPersonFunctionComboboxModel(this);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selection = (String) anItem;
    }

    @Override
    public String getSelectedItem() {
        return selection;
    }

    @Override
    public int getSize() {
        return PersonFacade.getInstance().getNumberOfFunctionsOfPerson(person);
    }

    @Override
    public String getElementAt(int index) {
        return PersonFacade.getInstance().getFunctionOfPerson(person, index);
    }

    @Override
    public void fireContentsChanged(Object source, int index0, int index1) {
        super.fireContentsChanged(source, index0, index1);
    }

    public Person getPerson() {
        return person;
    }

    public void remove() {
        PersonFacade.getInstance().removePersonFunctionComboboxModel(this);
    }
}