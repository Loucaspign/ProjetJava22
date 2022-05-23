package UI.Listeners;

import UI.ComboItem;
import UI.DBSearchProductPanelForm;
import UI.ProductSearchResultsPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValidateSearchProductButtonListener implements ActionListener {
    private DBSearchProductPanelForm dbSearchProductPanelForm;

    public ValidateSearchProductButtonListener(DBSearchProductPanelForm dbSearchProductPanelForm) {
        this.dbSearchProductPanelForm = dbSearchProductPanelForm;
    }

    public void actionPerformed(ActionEvent e) {
        try{
            dbSearchProductPanelForm.getMainWindow().getFrameContainer().removeAll();
            dbSearchProductPanelForm.getMainWindow().getFrameContainer().add(new ProductSearchResultsPanel(dbSearchProductPanelForm.getMainWindow(), ((ComboItem)dbSearchProductPanelForm.getProductComboB().getSelectedItem()).getValue()));
            dbSearchProductPanelForm.getMainWindow().repaint();
            dbSearchProductPanelForm.getMainWindow().printAll(dbSearchProductPanelForm.getMainWindow().getGraphics());
        } catch (Model.Exception.SearchByProductException searchByProductException) {
            JOptionPane.showMessageDialog(null, "An error has occurred while searching", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
