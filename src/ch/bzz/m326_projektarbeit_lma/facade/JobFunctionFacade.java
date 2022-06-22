package ch.bzz.m326_projektarbeit_lma.facade;

import ch.bzz.m326_projektarbeit_lma.company.Company;
import ch.bzz.m326_projektarbeit_lma.data.JSONData;
import ch.bzz.m326_projektarbeit_lma.gui.model.JobFunctionsComboboxModel;
import ch.bzz.m326_projektarbeit_lma.gui.model.JobFunctionsListModel;
import ch.bzz.m326_projektarbeit_lma.log.UserAction;

import java.util.Vector;

/**
 * This Facade contains all the functionalities for managing JobFunctions
 *
 * @apiNote job function and function is the same thing
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.17
 * @version 1.4
 */
public class JobFunctionFacade {
    private static JobFunctionFacade instance;
    private Vector<JobFunctionsListModel> jobFunctionsListModels;
    private Vector<JobFunctionsComboboxModel> jobFunctionsComboboxModels;

    private Company company;

    /**
     * constructor
     * is private because of singleton pattern
     */
    public JobFunctionFacade() {
        company = JSONData.getInstance().getCompany();
        jobFunctionsListModels = new Vector<>();
        jobFunctionsComboboxModels = new Vector<>();
    }

    /**
     * adds a given JobFunctionsListModel, so it is updated when the data changes
     *
     * @param jobFunctionsListModel to be added
     */
    public void addJobFunctionListModel(JobFunctionsListModel jobFunctionsListModel) {
        jobFunctionsListModels.add(jobFunctionsListModel);
    }

    /**
     * removes a given JobFunctionListModel, so it won't get update notification on changes
     *
     * @param jobFunctionsListModel to be removed
     */
    public void removeJobFunctionListModel(JobFunctionsListModel jobFunctionsListModel) {
        jobFunctionsListModels.remove(jobFunctionsListModel);
    }

    /**
     * adds a given JobFunctionsComboboxModel, so it is updated when the data changes
     *
     * @param jobFunctionsComboboxModel to be added
     */
    public void addJobFunctionComboboxModel(JobFunctionsComboboxModel jobFunctionsComboboxModel) {
        jobFunctionsComboboxModels.add(jobFunctionsComboboxModel);
    }

    /**
     * removes a given JobFunctionsComboboxModel, so it won't get update notification on changes
     *
     * @param jobFunctionsComboboxModel to be removed
     */
    public void removeJobFunctionComboboxModel(JobFunctionsComboboxModel jobFunctionsComboboxModel) {
        jobFunctionsComboboxModels.remove(jobFunctionsComboboxModel);
    }

    /**
     * gets all the functions
     *
     * @return all the functions
     */
    public Vector<String> getAllFunctions() {
        return company.getFunctions().getAllFunctions();
    }

    /**
     * gets the number of functions
     *
     * @return number of functions
     */
    public int getNumberOfJobFunctions() {
        return company.getFunctions().getSize();
    }

    /**
     * adds a new function
     *
     * @param name of the function to be added
     */
    public void addFunction(String name) {
        company.getFunctions().addJobFunction(name);
        fireChangesOnAllJobFunctionListModels();
        fireChangesOnAllJobFunctionComboboxModels();
        PersonFacade.getInstance().getLoggedInHRPerson().writeLogEntry(null, UserAction.CHANGED_BASE_DATA);
    }

    /**
     * updates a job function to the newValue by searching the position of the oldValue
     *
     * @param oldValue to get the index from
     * @param newValue to set
     */
    public void updateFunction(String oldValue, String newValue) {
        int index = getAllFunctions().indexOf(oldValue);
        company.getFunctions().setJobFunctionAtIndex(newValue, index);
        PersonFacade.getInstance().fireAllFunctionChangesOnPersons();
        PersonFacade.getInstance().getLoggedInHRPerson().writeLogEntry(null, UserAction.CHANGED_BASE_DATA);
        fireChangesOnAllJobFunctionListModels();
        fireChangesOnAllJobFunctionComboboxModels();
    }

    /**
     * removes a function
     *
     * @param name of the function to be removed
     */
    public void removeFunction(String name) {
        company.getFunctions().removeJobFunction(name);
        PersonFacade.getInstance().removeFunctionOfAllPersons(name);
        PersonFacade.getInstance().getLoggedInHRPerson().writeLogEntry(null, UserAction.CHANGED_BASE_DATA);
        fireChangesOnAllJobFunctionListModels();
        fireChangesOnAllJobFunctionComboboxModels();
    }

    /**
     * gets the function at a given index
     *
     * @param index of the function
     * @return function at given index
     */
    public String getFunction(int index) {
        return company.getFunctions().getJobFunction(index);
    }

    /**
     * notifies all registered JobFunctionListModels of changes
     */
    private void fireChangesOnAllJobFunctionListModels() {
        for (JobFunctionsListModel listModel : jobFunctionsListModels) {
            listModel.fireContentsChanged(this, 0, getNumberOfJobFunctions());
        }
    }

    /**
     * notifies all registered JobFunctionComboboxModels of changes
     */
    private void fireChangesOnAllJobFunctionComboboxModels() {
        for (JobFunctionsComboboxModel comboboxModel : jobFunctionsComboboxModels) {
            comboboxModel.fireContentsChanged(this, 0, getNumberOfJobFunctions());
        }
    }

    /**
     * returns the instance of the JobFunctionFacade class according to the singleton pattern
     *
     * @return the instance
     */
    public static JobFunctionFacade getInstance() {
        if (instance == null) {
            instance = new JobFunctionFacade();
        }
        return instance;
    }
}