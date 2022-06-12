package ch.bzz.m326_projektarbeit_lma;

import ch.bzz.m326_projektarbeit_lma.company.Company;
import ch.bzz.m326_projektarbeit_lma.company.Department;
import ch.bzz.m326_projektarbeit_lma.data.JSONData;
import ch.bzz.m326_projektarbeit_lma.employees.HRPerson;
import ch.bzz.m326_projektarbeit_lma.employees.Person;

public class Main {

    public static void main(String[] args) {
        Company company = new Company("Nukufel GmbH");
        company.addDepartment(new Department("Nufukel IT"));
        company.addDepartment(new Department("Nufukel Abacuuus"));

        company.getFunctions().addJobFunction("IT Guy");
        company.getFunctions().addJobFunction("Abacus Guy");

        company.getTeams().addTeam("IT");
        company.getTeams().addTeam("Abacus");

        company.getDepartment(0).addMember(new Person("Max", "Musterman", null));
        company.getDepartment(0).addMember(new Person("Joe", "Wilkinson", null));
        company.getDepartment(1).addMember(new HRPerson("Jimmy", "Carr", null, 0));

        company.getDepartment(0).getMember(0).getParticipation().addFunction(company.getFunctions().getJobFunction(0));
        company.getDepartment(0).getMember(1).getParticipation().addFunction(company.getFunctions().getJobFunction(1));

        company.getDepartment(0).getMember(0).getParticipation().addTeam(company.getTeams().getTeam(0));
        company.getDepartment(0).getMember(1).getParticipation().addTeam(company.getTeams().getTeam(1));

        company.getDepartment(1).getMember(0).getParticipation().addFunction(company.getFunctions().getJobFunction(1));
        company.getDepartment(1).getMember(0).getParticipation().addTeam(company.getTeams().getTeam(0));

        JSONData jsonData = JSONData.getInstance();
        jsonData.setCompany(company);

        jsonData.writeCompanyJSON();
    }
}