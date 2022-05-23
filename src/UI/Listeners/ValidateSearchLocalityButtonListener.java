package UI.Listeners;

import Model.Exception.SearchByLocalityException;
import UI.ComboItem;
import UI.DBSearchLocalityPanelForm;
import UI.LocalitySearchResultsPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValidateSearchLocalityButtonListener implements ActionListener {
    private DBSearchLocalityPanelForm dbSearchLocalityPanelForm;

    public ValidateSearchLocalityButtonListener(DBSearchLocalityPanelForm dbSearchLocalityPanelForm) {
        this.dbSearchLocalityPanelForm = dbSearchLocalityPanelForm;
    }

    public void actionPerformed(ActionEvent e){
        try{
            dbSearchLocalityPanelForm.getMainWindow().getFrameContainer().removeAll();
            dbSearchLocalityPanelForm.getMainWindow().getFrameContainer().add(new LocalitySearchResultsPanel(dbSearchLocalityPanelForm.getMainWindow(), ((ComboItem)dbSearchLocalityPanelForm.getLocalityComboB().getSelectedItem()).getValue()));
            dbSearchLocalityPanelForm.getMainWindow().repaint();
            dbSearchLocalityPanelForm.getMainWindow().printAll(dbSearchLocalityPanelForm.getMainWindow().getGraphics());
        } catch (SearchByLocalityException searchByLocalityException) {
            JOptionPane.showMessageDialog(null, "An error has occured while searching", "Error", JOptionPane.ERROR_MESSAGE);
        }
        }
    }

