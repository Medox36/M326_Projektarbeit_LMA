package ch.bzz.m326_projektarbeit_lma.facade;

import ch.bzz.m326_projektarbeit_lma.company.Company;
import ch.bzz.m326_projektarbeit_lma.data.JSONData;

/**
 * This Facade contains all the functionalities for managing the company
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.17
 * @version 1.3
 */
public class CompanyFacade {

    private Company company;
    private static CompanyFacade instance;

    /**
     * constructor
     * is private because of singleton pattern
     */
    private CompanyFacade() {
        company = JSONData.getInstance().getCompany();
    }

    /**
     * sets the company name
     *
     * @param name to set
     */
    public void setCompanyName(String name) {
        company.setCompanyName(name);
    }

    /**
     * gets the company name
     *
     * @return the company name
     */
    public String getCompanyName() {
        return company.getCompanyName();
    }


    /**
     * returns the instance of the DepartmentFacade class according to the singleton pattern
     *
     * @return the instance
     */
    public static CompanyFacade getInstance() {
        if (instance == null) {
            instance = new CompanyFacade();
        }
        return instance;
    }
}