package ch.bzz.m326_projektarbeit_lma.gui.model;

import ch.bzz.m326_projektarbeit_lma.facade.JobFunctionFacade;

import javax.swing.*;

public class JobFunctionsComboboxModel extends AbstractListModel<String> implements ComboBoxModel<String> {

    private String selection = null;

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

    public void remove() {
        JobFunctionFacade.getInstance().removeJobFunctionComboboxModel(this);
    }
}