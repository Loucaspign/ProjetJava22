package UI.Listeners;

import Model.Exception.AddOrderException;
import Model.Order;
import UI.ComboItem;
import UI.DBAddOrderFormPanel;
import UI.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;


public class ValidateButtonListener implements ActionListener {
    private DBAddOrderFormPanel dbAddOrderFormPanel;
    private MainWindow mainWindow;

    public ValidateButtonListener(DBAddOrderFormPanel dbAddOrderFormPanel, MainWindow mainWindow){
        this.dbAddOrderFormPanel = dbAddOrderFormPanel;
        this.mainWindow = mainWindow;
    }

    public void actionPerformed(ActionEvent e) {
        if (dbAddOrderFormPanel.getOrderIdTF().getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "OrderId is required", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(dbAddOrderFormPanel.getDeliveryStreetTF().getText().isEmpty() && dbAddOrderFormPanel.getIsDeliveredCheckB().isSelected()){
            JOptionPane.showMessageDialog(null, "Delivery street is required", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(dbAddOrderFormPanel.getIsDeliveredCheckB().isSelected() && dbAddOrderFormPanel.getDeliveryStreetNumberTF().getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Delivery street number is required", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(mainWindow.getOrderController().getOrders().stream().anyMatch(o -> o.getOrderId().toLowerCase().equals(dbAddOrderFormPanel.getOrderIdTF().getText().toLowerCase()))){
            JOptionPane.showMessageDialog(null, "Order id already exist", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            Order newOrder;
            String orderId = dbAddOrderFormPanel.getOrderIdTF().getText();
            String sellerId = ((ComboItem) dbAddOrderFormPanel.getSellerComboB().getSelectedItem()).getValue();
            String customerId = ((ComboItem) dbAddOrderFormPanel.getCustomerComboB().getSelectedItem()).getValue();
            GregorianCalendar releaseDate = new GregorianCalendar();
            releaseDate.setTime((Date) dbAddOrderFormPanel.getReleaseDateSpinner().getValue());
            GregorianCalendar paymentDeadline = new GregorianCalendar();
            paymentDeadline.setTime((Date) dbAddOrderFormPanel.getDeadlinePaymentSpinner().getValue());
            int numberPaymentReminder = (int) dbAddOrderFormPanel.getNumberPaymentReminderSpinner().getValue();
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
                newOrder = new Order(orderId, releaseDate, sendDate, null, paymentDeadline, receiptDate,numberPaymentReminder, isPaid, isDelivered, deliveryStreet, deliveryStreetNumber, customerId, sellerId, localityId);
            }
            else{
                GregorianCalendar withdrawDate = new GregorianCalendar();
                withdrawDate.setTime((Date) dbAddOrderFormPanel.getWithdrawDateSpinner().getValue());
                newOrder = new Order(orderId, releaseDate, null, withdrawDate, paymentDeadline, null, numberPaymentReminder, isPaid, isDelivered, null, null, customerId, sellerId, null);
            }
            try {
                dbAddOrderFormPanel.getMainWindow().getOrderController().addNewOrder(newOrder);
                JOptionPane.showMessageDialog(null, "The order was successfully added", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

            } catch (AddOrderException addOrderException) {
                JOptionPane.showMessageDialog(null, "An error has occurred while adding the new order", "Error", JOptionPane.ERROR_MESSAGE);
            }
            dbAddOrderFormPanel.getMainWindow().getFrameContainer().removeAll();
            //dbAddOrderFormPanel.getMainWindow().getFrameContainer().add(new AddDetailLinePanel(orderId, dbAddOrderFormPanel.getMainWindow()));
            dbAddOrderFormPanel.getMainWindow().repaint();
            dbAddOrderFormPanel.getMainWindow().printAll(dbAddOrderFormPanel.getMainWindow().getGraphics());
        }
    }
}




