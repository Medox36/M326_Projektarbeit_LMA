package ch.bzz.m326_projektarbeit_lma.employees;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Vector;

/**
 * The Participation class stores every team and function participation of a Person
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

    /**
     * constructor
     */
    public Participation() {
        function = new Vector<>();
        teams = new Vector<>();
    }

    /**
     * adds a new function
     *
     * @param function to be added
     */
    public void addFunction(String function) {
        this.function.add(function);
    }

    /**
     * gets the number of functions
     *
     * @return number of functions
     */
    @JsonIgnore
    public int getNumberOfFunctions() {
        return function.size();
    }

    /**
     * removes a function at a given index
     *
     * @param index of the function
     */
    public void removeJobFunction(int index) {
        function.remove(index);
    }

    /**
     * removes a function that matches a given String
     *
     * @param function name of the function
     */
    public void removeJobFunction(String function) {
        this.function.remove(function);
    }

    public String getFunctionName(int index) {
        return function.get(index);
    }

    /**
     * gets all the functions
     *
     * @return all functions in Vector of type String
     */
    @JsonIgnore
    public Vector<String> getAllFunctions() {
        return function;
    }

    /**
     * adds a team
     *
     * @param team to be added
     */
    public void addTeam(String team) {
        teams.add(team);
    }

    /**
     * gets the name of a team at a given index
     *
     * @param index of the team
     * @return name of the team
     */
    public String getTeamName(int index) {
        return teams.get(index);
    }

    /**
     * removes a team at a given index
     *
     * @param index of the team
     */
    public void removeTeam(int index) {
        teams.remove(index);
    }

    /**
     * removes a team that matches a given String
     *
     * @param team name of the team
     */
    public void removeTeam(String team) {
        teams.remove(team);
    }

    /**
     * gets the number of teams
     *
     * @return number of teams
     */
    @JsonIgnore
    public int getNumberOfTeams() {
        return teams.size();
    }

    /**
     * gets all the teams
     *
     * @return all teams in Vector of type String
     */
    @JsonIgnore
    public Vector<String> getAllTeams() {
        return teams;
    }
}