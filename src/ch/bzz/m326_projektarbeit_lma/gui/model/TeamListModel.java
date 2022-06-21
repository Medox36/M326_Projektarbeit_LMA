package ch.bzz.m326_projektarbeit_lma.gui.model;

import ch.bzz.m326_projektarbeit_lma.facade.TeamFacade;

import javax.swing.*;

/**
 * A custom ListModel for visualizing Teams
 *
 * @author Lorenzo Giuntini (Medox36)
 * @since 2022.06.20
 * @version 1.0
 */
public class TeamListModel extends AbstractListModel<String> {

    /**
     * constructor
     */
    public TeamListModel() {
        TeamFacade.getInstance().addTeamListModel(this);
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

    /**
     * removes this model from the Facade register, so it stops getting fireContentsChanged notifications
     * and can be safely deleted
     *
     * @apiNote this method should be called every time a model isn't used anymore
     */
    public void remove() {
        TeamFacade.getInstance().removeTeamListModel(this);
    }
}