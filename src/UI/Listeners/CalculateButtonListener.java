package UI.Listeners;

import UI.CustomerSearchResultsPanel;
import UI.MainWindow;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateButtonListener implements ActionListener {
    private CustomerSearchResultsPanel customerSearchResultsPanel;
    private MainWindow mainWindow;

    public CalculateButtonListener(CustomerSearchResultsPanel customerSearchResultsPanel, MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.customerSearchResultsPanel = customerSearchResultsPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTable jTable = customerSearchResultsPanel.getResult();
        String orderId = (String)jTable.getValueAt(jTable.getSelectedRow(), 0);
        double price = mainWindow.getOrderController().calculateOrder(orderId);
        JOptionPane.showMessageDialog(null, ("The total price of the order " + orderId + " is " + price + "€"), "Total price", JOptionPane.INFORMATION_MESSAGE);
    }
}