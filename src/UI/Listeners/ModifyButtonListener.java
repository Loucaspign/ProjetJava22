package UI.Listeners;

import Model.Exception.UpdateOrderException;
import Model.Order;
import UI.ComboItem;
import UI.DBAddOrderFormPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;

public class ModifyButtonListener implements ActionListener {
    private DBAddOrderFormPanel dbAddOrderFormPanel;

    public ModifyButtonListener(DBAddOrderFormPanel dbAddOrderFormPanel) {
        this.dbAddOrderFormPanel = dbAddOrderFormPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(dbAddOrderFormPanel.getDeliveryStreetTF().getText().isEmpty() && dbAddOrderFormPanel.getIsDeliveredCheckB().isSelected()){
            JOptionPane.showMessageDialog(null, "Delivery street is required", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(dbAddOrderFormPanel.getIsDeliveredCheckB().isSelected() && dbAddOrderFormPanel.getDeliveryStreetNumberTF().getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Delivery street number is required", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            Order updatedOrder;
            String orderId = dbAddOrderFormPanel.getOrderIdTF().getText();
            String sellerId = ((ComboItem) dbAddOrderFormPanel.getSellerComboB().getSelectedItem()).getValue();
            String customerId = ((ComboItem) dbAddOrderFormPanel.getCustomerComboB().getSelectedItem()).getValue();
            GregorianCalendar releaseDate = new GregorianCalendar();
            releaseDate.setTime((Date) dbAddOrderFormPanel.getReleaseDateSpinner().getValue());
            GregorianCalendar paymentDeadline = new GregorianCalendar();
            paymentDeadline.setTime((Date) dbAddOrderFormPanel.getDeadlinePaymentSpinner().getValue());
            int numberPaymentReminder =(int) dbAddOrderFormPanel.getNumberPaymentReminderSpinner().getValue();
            boolean isPaid = dbAddOrderFormPanel.getIsPaidCheckB().isSelected();
            boolean isDelivered = dbAddOrderFormPanel.getIsDeliveredCheckB().isSelected();
            if(isDelivered){
                GregorianCalendar sendDate = new GregorianCalendar();
                sendDate.setTime((Date) dbAddOrderFormPanel.getSendDateSpinner().getValue());
                GregorianCalendar receiptDate = new GregorianCalendar();
                receiptDate.setTime((Date) dbAddOrderFormPanel.getReceiptDateSpinner().getValue());
                String deliveryStreet = dbAddOrderFormPanel.getDeliveryStreetTF().getText();
                String deliveryStreetNumber = dbAddOrderFormPanel.getDeliveryStreetNumberTF().getText();
                String localityId = ((ComboItem) dbAddOrderFormPanel.getLocalityComboB().getSelectedItem()).getValue();
                updatedOrder = new Order(orderId, releaseDate, sendDate, null, paymentDeadline, receiptDate, numberPaymentReminder, isPaid, isDelivered, deliveryStreet, deliveryStreetNumber, customerId, sellerId, localityId);
            }
            else{
                GregorianCalendar withdrawDate = new GregorianCalendar();
                withdrawDate.setTime((Date) dbAddOrderFormPanel.getWithdrawDateSpinner().getValue());
                updatedOrder = new Order(orderId, releaseDate, null, withdrawDate, paymentDeadline, null, numberPaymentReminder, isPaid, isDelivered, null, null, customerId, sellerId, null);
            }
            try {
                dbAddOrderFormPanel.getMainWindow().getOrderController().updateOrder(updatedOrder);
                JOptionPane.showMessageDialog(null, "The order was successfully updated", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

            } catch (UpdateOrderException updateOrderException) {
                JOptionPane.showMessageDialog(null, "An error has occurred while updating the new order", "Error", JOptionPane.ERROR_MESSAGE);


            }
        }
    }


}
