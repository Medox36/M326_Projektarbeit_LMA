package ch.bzz.m326_projektarbeit_lma.facade;

import ch.bzz.m326_projektarbeit_lma.company.Company;
import ch.bzz.m326_projektarbeit_lma.data.JSONData;
import ch.bzz.m326_projektarbeit_lma.gui.model.TeamListModel;

import java.util.Vector;

/**
 *
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.17
 * @version 1.4
 */
public class TeamFacade {
    private static TeamFacade instance;
    private Company company;
    private Vector<TeamListModel> teamListModels;

    private TeamFacade() {
        company = JSONData.getInstance().getCompany();
        teamListModels = new Vector<>();
    }

    public void addTeamListModel(TeamListModel teamListModel) {
        teamListModels.add(teamListModel);
    }

    public void removeTeamListModel(TeamListModel teamListModel) {
        teamListModels.remove(teamListModel);
    }

    public Vector<String> getAllTeams() {
        return company.getTeams().getAllTeams();
    }

    public int getNumberOfTeams() {
        return company.getTeams().getSize();
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

    private void fireChangesOnAllTeamListModels() {
        for (TeamListModel listModel : teamListModels) {
            listModel.fireContentsChanged(this, 0, getNumberOfTeams());
        }
    }

    public static TeamFacade getInstance() {
        if (instance == null) {
            instance = new TeamFacade();
        }
        return instance;
    }

}