package ch.bzz.m326_projektarbeit_lma.gui.model;

import ch.bzz.m326_projektarbeit_lma.facade.JobFunctionFacade;

import javax.swing.*;

/**
 * A custom ComboboxModel for visualizing JPbFunctions
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.20
 * @version 1.0
 */
public class JobFunctionsComboboxModel extends AbstractListModel<String> implements ComboBoxModel<String> {

    private String selection = null;

    /**
     * constructor
     */
    public JobFunctionsComboboxModel() {
        JobFunctionFacade.getInstance().addJobFunctionComboboxModel(this);
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
        return JobFunctionFacade.getInstance().getNumberOfJobFunctions();
    }

    @Override
    public String getElementAt(int index) {
        return JobFunctionFacade.getInstance().getFunction(index);
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
        JobFunctionFacade.getInstance().removeJobFunctionComboboxModel(this);
    }
}