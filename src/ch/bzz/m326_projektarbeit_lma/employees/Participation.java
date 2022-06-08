package ch.bzz.m326_projektarbeit_lma.employees;

import java.util.Vector;

/**
 *
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.05.18
 * @version 1.1
 */
public class Participation {

    private Vector<String> function;
    private Vector<String> teams;

    public Participation() {
        function = new Vector<>();
        teams = new Vector<>();
    }

    public void addFunction(String function) {
        this.function.add(function);
    }

    public int getNumberOfFunctions() {
        return function.size();
    }

    public void removeJobFunction(int index) {
        function.remove(index);
    }

    public void removeJobFunction(String function) {
        this.function.remove(function);
    }

    public void addTeam(String team) {
        teams.add(team);
    }

    public String getTeamName(int index) {
        return teams.get(index);
    }

    public void removeTeam(int index) {
        teams.remove(index);
    }

    public void removeTeam(String team) {
        teams.remove(team);
    }

    public int getNumberOfTeams() {
        return teams.size();
    }
}