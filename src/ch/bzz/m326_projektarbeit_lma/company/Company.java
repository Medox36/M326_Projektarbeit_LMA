package ch.bzz.m326_projektarbeit_lma.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 *
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.01
 * @version 1.1
 */
public class Company {

    private String name;
    private Vector<Departement> departements;
    private JobFunctions functions;
    private Teams teams;

    public Company() {
    }

    public Company(String name) {
        this.name = name;
        departements = new Vector<>();
        functions = new JobFunctions();
        teams = new Teams();
    }

    public String getCompanyName() {
        return name;
    }

    public void addDepartment(Departement departement) {
        departements.add(departement);
    }

    public Vector<Departement> getAllDepartments() {
        return departements;
    }

    public Departement getDepartement(int index) {
        return departements.get(index);
    }

    public String getDepartmentName(int index) {
        return departements.get(index).getName();
    }

    public Vector<String> getDepartmentsName() {
        Vector<String> names = new Vector<>();

        Iterator<Departement> it = departements.iterator();
        if (! it.hasNext()) {
            return names;
        }

        for (;;) {
            Departement d = it.next();
            names.add(d.getName());
            if (!it.hasNext()) {
                return names;
            }
        }
    }

    public List<Departement> getDepartmentsNameList() {
        return new ArrayList<>(departements);
    }

    public void removeDepartment(int index) {
        departements.remove(index);
    }

    public void removeDepartment(Departement departement) {
        departements.remove(departement);
    }

    public int getNumberOfDepartments() {
        return departements.size();
    }

    public JobFunctions getFunctions() {
        return functions;
    }

    public Teams getTeams() {
        return teams;
    }
}