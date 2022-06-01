package ch.bzz.m326_projektarbeit_lma.employees;

import ch.bzz.m326_projektarbeit_lma.company.JobFunctions;
import ch.bzz.m326_projektarbeit_lma.company.Teams;

public class Participation {

    private JobFunctions function;
    private Teams teams;

    public Participation() {
        function = new JobFunctions();
        teams = new Teams();
    }

    public void addFunction(String function) {
        this.function.addJobFunction(function);
    }

    public int getNumberOfFunctions() {
        return function.getSize();
    }

    public void removeJobFunction(int index) {
        function.removeJobFunction(index);
    }

    public void removeJobFunction(String function) {
        this.function.removeJobFunction(function);
    }

    public void addTeam(String team) {
        teams.addTeam(team);
    }

    public String getTeamName(int index) {
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