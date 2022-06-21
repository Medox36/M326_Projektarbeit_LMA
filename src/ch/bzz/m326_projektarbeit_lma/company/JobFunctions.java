package ch.bzz.m326_projektarbeit_lma.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Vector;

/**
 * The JobFunctions class stores all the functions
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.01
 * @version 1.0
 */
@Getter
@Setter
public class JobFunctions {

    private Vector<String> designations;

    /**
     * constructor
     */
    public JobFunctions() {
        designations = new Vector<>();

    }

    /**
     * adds a job function
     *
     * @param jobFunction to be added
     */
    public void addJobFunction(String jobFunction) {
        designations.add(jobFunction);
    }

    /**
     * gets a gob function at a given index
     *
     * @param index of the job function
     * @return the job function
     */
    public String getJobFunction(int index) {
        return designations.get(index);
    }

    /**
     * removes a job function at a given index
     *
     * @param index of the job function
     */
    public void removeJobFunction(int index) {
        designations.remove(index);
    }

    /**
     * removes a job function that matches a given String
     *
     * @param jobFunction to be removed
     */
    public void removeJobFunction(String jobFunction) {
        designations.remove(jobFunction);
    }

    /**
     * gets the number of all job functions
     *
     * @return number of job functions
     */
    @JsonIgnore
    public int getSize() {
        return designations.size();
    }

    /**
     * gets all job functions
     *
     * @return all job functions in Vector of type String
     */
    @JsonIgnore
    public Vector<String> getAllFunctions() {
        return designations;
    }
}