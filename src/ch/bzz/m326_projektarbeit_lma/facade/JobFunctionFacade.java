package ch.bzz.m326_projektarbeit_lma.facade;

import ch.bzz.m326_projektarbeit_lma.company.Company;
import ch.bzz.m326_projektarbeit_lma.data.JSONData;
import ch.bzz.m326_projektarbeit_lma.gui.model.JobFunctionsListModel;

import java.util.Vector;

/**
 *
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.17
 * @version 1.4
 */
public class JobFunctionFacade {
    private static JobFunctionFacade instance;
    private Vector<JobFunctionsListModel> jobFunctionsListModels;

    private Company company;

    public JobFunctionFacade() {
        company = JSONData.getInstance().getCompany();
        jobFunctionsListModels = new Vector<>();
    }

    public void addJobFunctionListModel(JobFunctionsListModel jobFunctionsListModel) {
        jobFunctionsListModels.add(jobFunctionsListModel);
    }

    public void removeJobFunctionListModel(JobFunctionsListModel jobFunctionsListModel) {
        jobFunctionsListModels.remove(jobFunctionsListModel);
    }

    public Vector<String> getAllFunctions() {
        return company.getFunctions().getAllFunctions();
    }

    public int getNumberOfJobFunctions() {
        return company.getFunctions().getSize();
    }

    public void addFunction(String name) {
        company.getFunctions().addJobFunction(name);
        fireChangesOnAllJobFunctionListModels();
    }

    public void removeFunction(String name) {
        company.getFunctions().removeJobFunction(name);
        fireChangesOnAllJobFunctionListModels();
    }

    public String getFunction(int index) {
        return company.getFunctions().getJobFunction(index);
    }

    public Vector<String> searchFunctions(String filter) {
        Vector<String > departments = new Vector<>();
        for (String s : getAllFunctions()) {
            if (s.contains(filter)) {
                departments.add(s);
            }
        }
        return departments;
    }

    private void fireChangesOnAllJobFunctionListModels() {
        for (JobFunctionsListModel listModel : jobFunctionsListModels) {
            listModel.fireContentsChanged(this, 0, getNumberOfJobFunctions());
        }
    }

    public static JobFunctionFacade getInstance() {
        if (instance == null) {
            instance = new JobFunctionFacade();
        }
        return instance;
    }
}