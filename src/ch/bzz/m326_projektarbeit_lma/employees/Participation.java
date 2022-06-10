package ch.bzz.m326_projektarbeit_lma.employees;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Vector;

/**
 *
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.05.18
 * @version 1.1
 */
@Getter
@Setter
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

    @JsonIgnore
    public int getNumberOfFunctions() {
        return function.size();
    }

    public void removeJobFunction(int index) {
        function.remove(index);
    }

    public void removeJobFunction(String function) {
        this.function.remove(function);
    }

    public Vector<String> getAllFunctions() {
        return function;
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

    @JsonIgnore
    public int getNumberOfTeams() {
        return teams.size();
    }

    public Vector<String> getAllTeams() {
        return teams;
    }
}