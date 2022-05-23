package UI;

import Model.Customer;
import Model.Order;

import javax.swing.*;
import java.util.ArrayList;

public class DBSearchCustomerPanelForm extends JPanel {
    private JComboBox customerComboB;
    private JLabel customerLabel;
    private MainWindow mainWindow;
    private ArrayList<Customer> customers;


    public DBSearchCustomerPanelForm(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.customers = mainWindow.getOrderController().getCustomers();
        customerLabel = new JLabel("Customer : ");
        customerComboB = new JComboBox();



        for (Customer customer: customers) {
            customerComboB.addItem(new ComboItem((customer.getFirstname() + " " + customer.getLastName()),customer.getCustomerId()));
        }


        this.add(customerLabel);
        this.add(customerComboB);

    }

    public MainWindow getMainWindow() {
        return mainWindow;
    }

    public JComboBox getCustomerComboB() {
        return customerComboB;
    }
}
