package UI.Listeners;

import Model.Exception.SearchByDatesException;
import UI.DBSearchDatesPanelForm;
import UI.DatesSearchResultsPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;

public class ValidateSearchDatesButtonListener implements ActionListener {
    private DBSearchDatesPanelForm dbSearchDatesPanelForm;

    public ValidateSearchDatesButtonListener(DBSearchDatesPanelForm dbSearchDatesPanelForm) {
        this.dbSearchDatesPanelForm = dbSearchDatesPanelForm;
    }

    public void actionPerformed(ActionEvent e) {
        try{
            dbSearchDatesPanelForm.getMainWindow().getFrameContainer().removeAll();
            GregorianCalendar date1 = new GregorianCalendar();
            GregorianCalendar date2 = new GregorianCalendar();
            date1.setTime((Date)dbSearchDatesPanelForm.getDates1().getValue());
            date2.setTime((Date)dbSearchDatesPanelForm.getDates2().getValue());
            dbSearchDatesPanelForm.getMainWindow().getFrameContainer().add(new DatesSearchResultsPanel(dbSearchDatesPanelForm.getMainWindow(), date1, date2));
            dbSearchDatesPanelForm.getMainWindow().repaint();
            dbSearchDatesPanelForm.getMainWindow().printAll(dbSearchDatesPanelForm.getMainWindow().getGraphics());
        } catch (SearchByDatesException searchByDatesException) {
            JOptionPane.showMessageDialog(null, "An error has occured while searching", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
