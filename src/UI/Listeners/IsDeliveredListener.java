package UI.Listeners;

import UI.DBAddOrderFormPanel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class IsDeliveredListener implements ItemListener {
    DBAddOrderFormPanel dbAddOrderFormPanel;

    public IsDeliveredListener(DBAddOrderFormPanel dbAddOrderFormPanel) {
        this.dbAddOrderFormPanel = dbAddOrderFormPanel;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(dbAddOrderFormPanel.getIsDeliveredCheckB().isSelected()){
            dbAddOrderFormPanel.getDeliveryStreetNumberTF().setEnabled(true);
            dbAddOrderFormPanel.getDeliveryStreetTF().setEnabled(true);
            dbAddOrderFormPanel.getLocalityComboB().setEnabled(true);
            dbAddOrderFormPanel.getReceiptDateSpinner().setEnabled(true);
            dbAddOrderFormPanel.getSendDateSpinner().setEnabled(true);
            dbAddOrderFormPanel.getWithdrawDateSpinner().setEnabled(false);
        }
        else{
            dbAddOrderFormPanel.getWithdrawDateSpinner().setEnabled(true);
            dbAddOrderFormPanel.getDeliveryStreetNumberTF().setEnabled(false);
            dbAddOrderFormPanel.getDeliveryStreetTF().setEnabled(false);
            dbAddOrderFormPanel.getLocalityComboB().setEnabled(false);
            dbAddOrderFormPanel.getReceiptDateSpinner().setEnabled(false);
            dbAddOrderFormPanel.getSendDateSpinner().setEnabled(false);
        }
    }

}
