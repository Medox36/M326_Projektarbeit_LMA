package ch.bzz.m326_projektarbeit_lma.facade;

import ch.bzz.m326_projektarbeit_lma.company.Company;
import ch.bzz.m326_projektarbeit_lma.data.JSONData;

import java.util.Vector;

public class TeamFacade {
    private static TeamFacade instance;
    private Company company;

    private TeamFacade() {
        company = JSONData.getInstance().getCompany();
    }

    public Vector<String> getAllTeams() {
        return company.getTeams().getAllTeams();
    }

    public void addTeam(String name) {
        company.getTeams().addTeam(name);
    }

    public void removeTeam(String name) {
        company.getTeams().removeTeam(name);
    }

    public String getTeam(int index) {
        return company.getTeams().getTeam(index);
    }

    public Vector<String> searchTeams(String filter) {
        Vector<String > departments = new Vector<>();
        for (String s : getAllTeams()) {
            if (s.contains(filter)) {
                departments.add(s);
            }
        }
        return departments;
    }

    public static TeamFacade getInstance() {
        if (instance != null) {
            instance = new TeamFacade();
        }
        return instance;
    }

}