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

    public Teams() {
        designations = new Vector<>();

    }

    public void addTeam(String team) {
        designations.add(team);
    }

    public String getTeam(int index) {
        return designations.get(index);
    }

    public void removeTeam(int index) {
        designations.remove(index);
    }

    public void removeTeam(String team) {
        designations.remove(team);
    }

    @JsonIgnore
    public int getSize() {
        return designations.size();
    }

    public Vector<String> getAllTeams() {
        return designations;
    }
}