package ch.bzz.m326_projektarbeit_lma.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Vector;

/**
 *
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.01
 * @version 1.0
 */
@Getter
@Setter
public class Teams {

    private Vector<String> designations;

    /**
     * constructor
     */
    public Teams() {
        designations = new Vector<>();

    }

    /**
     * adds a team
     *
     * @param team to be added
     */
    public void addTeam(String team) {
        designations.add(team);
    }

    /**
     * gets a team at a given index
     *
     * @param index of the team
     * @return the team
     */
    public String getTeam(int index) {
        return designations.get(index);
    }

    /**
     * removes a team at a given index
     *
     * @param index of the team
     */
    public void removeTeam(int index) {
        designations.remove(index);
    }

    /**
     * removes a team that matches a given String
     *
     * @param team to be removed
     */
    public void removeTeam(String team) {
        designations.remove(team);
    }

    /**
     * gets the number of all teams
     *
     * @return number of teams
     */
    @JsonIgnore
    public int getSize() {
        return designations.size();
    }

    /**
     * gets all the teams
     *
     * @return all teams in Vector of type String
     */
    @JsonIgnore
    public Vector<String> getAllTeams() {
        return designations;
    }
}