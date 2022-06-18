package ch.bzz.m326_projektarbeit_lma.facade;

import ch.bzz.m326_projektarbeit_lma.company.Company;
import ch.bzz.m326_projektarbeit_lma.data.JSONData;

import java.util.Vector;

public class JobFunctionFacade {
    private static JobFunctionFacade instance;

    private Company company;

    public JobFunctionFacade() {
        company = JSONData.getInstance().getCompany();
    }

    public Vector<String> getAllFunctions() {
        return company.getFunctions().getAllFunctions();
    }

    public void addFunction(String name) {
        company.getFunctions().addJobFunction(name);
    }

    public void removeFunction(String name) {
        company.getFunctions().removeJobFunction(name);
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

    public static JobFunctionFacade getInstance() {
        if (instance != null) {
            instance = new JobFunctionFacade();
        }
        return instance;
    }
}