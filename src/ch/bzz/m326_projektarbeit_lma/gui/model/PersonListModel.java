package ch.bzz.m326_projektarbeit_lma.gui.model;

import ch.bzz.m326_projektarbeit_lma.employees.Person;
import ch.bzz.m326_projektarbeit_lma.facade.PersonFacade;

import javax.swing.*;

/**
 * A custom ListModel for visualizing Persons
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.20
 * @version 1.0
 */
public class PersonListModel extends AbstractListModel<Person> {

    /**
     * constructor
     */
    public PersonListModel() {
        PersonFacade.getInstance().addPersonListModel(this);
    }

    @Override
    public int getSize() {
        return PersonFacade.getInstance().getNumberOfPersons();
    }

    @Override
    public Person getElementAt(int index) {
        return PersonFacade.getInstance().getPersonAt(index);
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
        PersonFacade.getInstance().removePersonListModel(this);
    }
}