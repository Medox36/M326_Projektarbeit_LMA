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
 * @version 1.0
 */
public class Company {

    private String name;
    private Vector<Departement> departements;

    public Company(String name) {
        this.name = name;
        departements = new Vector<>();
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
}