package UI.Listeners;

import Model.Customer;
import Model.Locality;
import Model.Order;
import Model.Seller;
import UI.DBUpdateOrderButtonPanel;
import UI.DBUpdateOrderPanel;
import UI.MainWindow;
import UI.OrderListingPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class UpdateButtonListener implements ActionListener {
    private OrderListingPanel orderListingPanel;
    private MainWindow mainWindow;

    public UpdateButtonListener(OrderListingPanel orderListingPanel, MainWindow mainWindow){
        this.orderListingPanel = orderListingPanel;
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTable jTable = orderListingPanel.getjTable();
        String orderId = (String)jTable.getValueAt(jTable.getSelectedRow(),0);
        ArrayList<Seller> sellers = new ArrayList<>();
        sellers = mainWindow.getOrderController().getSellers();
        ArrayList<Customer> customers = new ArrayList<Customer>();
        customers = mainWindow.getOrderController().getCustomers();
        ArrayList<Locality> localities = new ArrayList<>();
        localities = mainWindow.getOrderController().getLocalities();
        Order order = mainWindow.getOrderController().getOrders().stream().filter(o -> o.getOrderId().equals(orderId)).findFirst().get();

        DBUpdateOrderPanel dbUpdateOrderPanel = new DBUpdateOrderPanel(mainWindow);

        dbUpdateOrderPanel.getDbAddFormPanel().getOrderIdTF().setText(order.getOrderId());
        dbUpdateOrderPanel.getDbAddFormPanel().getOrderIdTF().setEnabled(false);


        int index = sellers.indexOf(sellers.stream().filter(s -> s.getSellerId().equals(order.getSeller())).findFirst().get());
        dbUpdateOrderPanel.getDbAddFormPanel().getSellerComboB().setSelectedIndex(index);

        index = customers.indexOf(customers.stream().filter(c -> c.getCustomerId().equals(order.getCustomer())).findFirst().get());
        dbUpdateOrderPanel.getDbAddFormPanel().getCustomerComboB().setSelectedIndex(index);
        dbUpdateOrderPanel.getDbAddFormPanel().getReleaseDateSpinner().setValue(order.getOrderDate().getTime());
        dbUpdateOrderPanel.getDbAddFormPanel().getDeadlinePaymentSpinner().setValue(order.getDeadlinePayment().getTime());
        dbUpdateOrderPanel.getDbAddFormPanel().getIsPaidCheckB().setSelected(order.isPaid());
        dbUpdateOrderPanel.getDbAddFormPanel().getIsDeliveredCheckB().setSelected(order.isDelivered());


        if(order.isDelivered()){
            dbUpdateOrderPanel.getDbAddFormPanel().getSendDateSpinner().setValue(order.getSentDate().getTime());
            dbUpdateOrderPanel.getDbAddFormPanel().getReceiptDateSpinner().setValue(order.getReceiptDate().getTime());
            dbUpdateOrderPanel.getDbAddFormPanel().getDeliveryStreetTF().setText(order.getDeliveryStreet());
            dbUpdateOrderPanel.getDbAddFormPanel().getDeliveryStreetNumberTF().setText(order.getDeliveryStreetNumber());
            index = localities.indexOf(localities.stream().filter(l -> l.getLocalityId().equals(order.getLocality())).findFirst().get());
            dbUpdateOrderPanel.getDbAddFormPanel().getLocalityComboB().setSelectedIndex(index);
        }
        else{
            dbUpdateOrderPanel.getDbAddFormPanel().getWithdrawDateSpinner().setValue(order.getWithdrawalDate().getTime());
        }



        mainWindow.getFrameContainer().removeAll();
        mainWindow.getFrameContainer().add(dbUpdateOrderPanel);
        mainWindow.repaint();
        mainWindow.printAll(mainWindow.getGraphics());


    }

}
