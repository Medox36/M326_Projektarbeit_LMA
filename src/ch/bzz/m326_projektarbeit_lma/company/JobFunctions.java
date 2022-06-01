package ch.bzz.m326_projektarbeit_lma.company;

import java.util.Vector;

public class JobFunctions {

    private Vector<String> designations;

    public JobFunctions() {
        designations = new Vector<>();
    }

    public void addJobFunction(String function) {
        designations.add(function);
    }

    public String getJobFunction(int index) {
        return designations.get(index);
    }

    public void removeJobFunction(int index) {
        designations.remove(index);
    }

    public void removeJobFunction(String jobFunction) {
        designations.remove(jobFunction);
    }

    public int getSize() {
        return designations.size();
    }
}