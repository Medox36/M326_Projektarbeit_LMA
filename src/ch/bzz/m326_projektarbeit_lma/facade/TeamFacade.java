package ch.bzz.m326_projektarbeit_lma.facade;

import ch.bzz.m326_projektarbeit_lma.company.Company;
import ch.bzz.m326_projektarbeit_lma.data.JSONData;
import ch.bzz.m326_projektarbeit_lma.gui.model.TeamComboboxModel;
import ch.bzz.m326_projektarbeit_lma.gui.model.TeamListModel;

import java.util.Vector;

/**
 * This Facade contains all the functionalities for managing Teams
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.17
 * @version 1.4
 */
public class TeamFacade {
    private static TeamFacade instance;
    private Company company;
    private Vector<TeamListModel> teamListModels;
    private Vector<TeamComboboxModel> teamComboboxModels;

    /**
     * constructor
     * is private because of singleton pattern
     */
    private TeamFacade() {
        company = JSONData.getInstance().getCompany();
        teamListModels = new Vector<>();
        teamComboboxModels = new Vector<>();
    }

    /**
     * adds a given TeamListModel, so it is updated when the data changes
     *
     * @param teamListModel to be added
     */
    public void addTeamListModel(TeamListModel teamListModel) {
        teamListModels.add(teamListModel);
    }

    /**
     * removes a given TeamListModel, so it won't get update notification on changes
     *
     * @param teamListModel to be removed
     */
    public void removeTeamListModel(TeamListModel teamListModel) {
        teamListModels.remove(teamListModel);
    }

    /**
     * adds a given TeamComboboxModel, so it is updated when the data changes
     *
     * @param teamComboboxModel to be added
     */
    public void addTeamComboboxModel(TeamComboboxModel teamComboboxModel) {
        teamComboboxModels.add(teamComboboxModel);
    }

    /**
     * removes a given TeamComboboxModel, so it won't get update notification on changes
     *
     * @param teamComboboxModel to be removed
     */
    public void removeTeamComboboxModel(TeamComboboxModel teamComboboxModel) {
        teamComboboxModels.remove(teamComboboxModel);
    }

    /**
     * gets all the teams
     *
     * @return all teams
     */
    public Vector<String> getAllTeams() {
        return company.getTeams().getAllTeams();
    }

    /**
     * gets the number of teams
     *
     * @return number of teams
     */
    public int getNumberOfTeams() {
        return company.getTeams().getSize();
    }

    /**
     * adds a given team
     *
     * @param name of team to be added
     */
    public void addTeam(String name) {
        company.getTeams().addTeam(name);
        fireChangesOnAllTeamListModels();
        fireChangesOnAllTeamComboboxModels();
    }

    /**
     * removes a given team
     *
     * @param name of team to be removed
     */
    public void removeTeam(String name) {
        company.getTeams().removeTeam(name);
        fireChangesOnAllTeamListModels();
        fireChangesOnAllTeamComboboxModels();
    }

    /**
     * gets a team at a given index
     *
     * @param index of the team
     * @return team at a given index
     */
    public String getTeam(int index) {
        return company.getTeams().getTeam(index);
    }

    /**
     * notifies all registered TeamListModel of changes
     */
    private void fireChangesOnAllTeamListModels() {
        for (TeamListModel listModel : teamListModels) {
            listModel.fireContentsChanged(this, 0, getNumberOfTeams());
        }
    }

    /**
     * notifies all registered TeamComboboxModels of changes
     */
    private void fireChangesOnAllTeamComboboxModels() {
        for (TeamComboboxModel comboboxModel : teamComboboxModels) {
            comboboxModel.fireContentsChanged(this, 0, getNumberOfTeams());
        }
    }

    /**
     * returns the instance of the TeamFacade class according to the singleton pattern
     *
     * @return the instance
     */
    public static TeamFacade getInstance() {
        if (instance == null) {
            instance = new TeamFacade();
        }
        return instance;
    }
}