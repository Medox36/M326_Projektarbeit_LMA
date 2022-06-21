package ch.bzz.m326_projektarbeit_lma.gui.model;

import ch.bzz.m326_projektarbeit_lma.employees.Person;
import ch.bzz.m326_projektarbeit_lma.facade.PersonFacade;

import javax.swing.*;

/**
 * A custom ComboboxModel for visualizing Functions of a Person
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.20
 * @version 1.0
 */
public class PersonFunctionComboboxModel extends AbstractListModel<String> implements ComboBoxModel<String> {

    private String selection = null;
    private Person person;

    /**
     * constructor
     *
     * @param person for which the model is for
     */
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

    /**
     * removes this model from the Facade register, so it stops getting fireContentsChanged notifications
     * and can be safely deleted
     *
     * @apiNote this method should be called every time a model isn't used anymore
     */
    public void remove() {
        PersonFacade.getInstance().removePersonFunctionComboboxModel(this);
    }
}