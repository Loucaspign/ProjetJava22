package UI.Listeners;

import Model.Exception.SearchByCustomerException;
import UI.ComboItem;
import UI.CustomerSearchResultsPanel;
import UI.DBSearchCustomerPanelForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValidateSearchCustomerButtonListener implements ActionListener {
    private DBSearchCustomerPanelForm dbSearchCustomerPanelForm;

    public ValidateSearchCustomerButtonListener(DBSearchCustomerPanelForm dbSearchCustomerPanelForm){
        this.dbSearchCustomerPanelForm = dbSearchCustomerPanelForm;
    }


    public void actionPerformed(ActionEvent e){
        try{
            dbSearchCustomerPanelForm.getMainWindow().getFrameContainer().removeAll();
            dbSearchCustomerPanelForm.getMainWindow().getFrameContainer().add(new CustomerSearchResultsPanel(dbSearchCustomerPanelForm.getMainWindow(), ((ComboItem)dbSearchCustomerPanelForm.getCustomerComboB().getSelectedItem()).getValue()));
            dbSearchCustomerPanelForm.getMainWindow().repaint();
            dbSearchCustomerPanelForm.getMainWindow().printAll(dbSearchCustomerPanelForm.getMainWindow().getGraphics());

        } catch (SearchByCustomerException searchByCustomerException) {
            JOptionPane.showMessageDialog(null, "An error has occured while searching", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }
}
