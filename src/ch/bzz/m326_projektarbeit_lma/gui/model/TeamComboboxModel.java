package ch.bzz.m326_projektarbeit_lma.gui.model;

import ch.bzz.m326_projektarbeit_lma.facade.TeamFacade;

import javax.swing.*;

public class TeamComboboxModel extends AbstractListModel<String> implements ComboBoxModel<String> {

    private String selection = null;

    public TeamComboboxModel() {
        TeamFacade.getInstance().addTeamComboboxModel(this);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selection = (String) anItem;
    }

    @Override
    public String getSelectedItem() {
        return selection;
    }

    @Override
    public int getSize() {
        return TeamFacade.getInstance().getNumberOfTeams();
    }

    @Override
    public String getElementAt(int index) {
        return TeamFacade.getInstance().getTeam(index);
    }

    @Override
    public void fireContentsChanged(Object source, int index0, int index1) {
        super.fireContentsChanged(source, index0, index1);
    }

    public void remove() {
        TeamFacade.getInstance().removeTeamComboboxModel(this);
    }
}