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

    public Departement getDepartement(int index) {
        return departements.get(index);
    }

    public String getDepartmentName(int index) {
        return departements.get(index).getName();
    }

    public String getDepartmentsName() {
        Iterator<Departement> it = departements.iterator();
        if (! it.hasNext()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (;;) {
            Departement d = it.next();
            sb.append(d);
            if (!it.hasNext()) {
                return sb.toString();
            }
            sb.append(",");
        }
    }

    public List<Departement> getDepartmentsNameList() {
        return new ArrayList<>(departements);
    }

    public void removeDepartment(int index) {
        departements.remove(index);
    }

    public int getNumberOfDepartments() {
        return departements.size();
    }

    public void addFunction(String function) {
        functions.addJobFunction(function);
    }

    public String getFunction(int index) {
        return functions.getJobFunction(index);
    }

    public void removeFunction(int index) {
        functions.removeJobFunction(index);
    }

    public void removeFunction(String function) {
        teams.removeTeam(function);
    }

    public int getNumberOfFunctions() {
        return functions.getSize();
    }

    public void addTeam(String team) {
        teams.addTeam(team);
    }

    public String getTeam(int index) {
        return teams.getTeam(index);
    }

    public void removeTeam(int index) {
        teams.removeTeam(index);
    }

    public void removeTeam(String team) {
        teams.removeTeam(team);
    }

    public int getNumberOfTeams() {
        return teams.getSize();
    }
}