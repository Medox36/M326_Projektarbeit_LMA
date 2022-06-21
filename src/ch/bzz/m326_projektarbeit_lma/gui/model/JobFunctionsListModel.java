package ch.bzz.m326_projektarbeit_lma.gui.model;

import ch.bzz.m326_projektarbeit_lma.facade.JobFunctionFacade;

import javax.swing.*;

/**
 * A custom ListModel for visualizing JobFunctions
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.20
 * @version 1.0
 */
public class JobFunctionsListModel extends AbstractListModel<String> {

    /**
     * constructor
     */
    public JobFunctionsListModel() {
        JobFunctionFacade.getInstance().addJobFunctionListModel(this);
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
        JobFunctionFacade.getInstance().removeJobFunctionListModel(this);
    }
}