package UI.Listeners;

import Model.Exception.DeleteDetailLineException;
import Model.Exception.DeleteOrderException;
import UI.MainWindow;
import UI.OrderListingPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteButtonListener implements ActionListener {
    private OrderListingPanel orderListingPanel;
    private MainWindow mainWindow;

    public DeleteButtonListener(OrderListingPanel orderListingPanel, MainWindow mainWindow) {
        this.orderListingPanel = orderListingPanel;
        this.mainWindow = mainWindow;
    }

    public void actionPerformed(ActionEvent e){
        JTable jTable = orderListingPanel.getjTable();
        String orderId = (String)jTable.getValueAt(jTable.getSelectedRow(),0);

        try {
            mainWindow.getOrderController().deleteDetailLines(orderId);
        } catch (DeleteDetailLineException deleteDetailLineException) {
            JOptionPane.showMessageDialog(null, "An error has occurred while deleting detail lines", "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            mainWindow.getOrderController().deleteOrder(orderId);
        } catch (DeleteOrderException deleteOrderException) {
            JOptionPane.showMessageDialog(null,"An error has occurred while deleting the order","Error",JOptionPane.ERROR_MESSAGE);

        }
        mainWindow.repaint();
        mainWindow.printAll(mainWindow.getGraphics());
    }


}
