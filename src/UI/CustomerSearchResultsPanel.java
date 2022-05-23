package UI;

import Model.Exception.SearchByCustomerException;
import UI.Listeners.BackButtonListener;
import UI.Listeners.CalculateButtonListener;
import UI.TablesModels.CustomerSearchTableModel;

import javax.swing.*;
import java.awt.*;

public class CustomerSearchResultsPanel extends JPanel {
    private JTable result;
    private MainWindow mainWindow;
    private String customerId;
    private JButton calculateButton;
    private JButton backButton;

    public CustomerSearchResultsPanel(MainWindow mainWindow, String customerId) throws SearchByCustomerException {
        super();

        this.mainWindow = mainWindow;
        this.customerId = customerId;



        calculateButton = new JButton("Calculate");
        backButton = new JButton("Back");

        backButton.addActionListener(new BackButtonListener(mainWindow));

        this.setLayout(new BorderLayout());

        result = new JTable(new CustomerSearchTableModel(mainWindow.getOrderController().searchByCustomer(customerId)));
        this.add(new JScrollPane(result), BorderLayout.CENTER);

        this.add(calculateButton);
        calculateButton.addActionListener(new CalculateButtonListener(this, mainWindow));

        this.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(5, 3, 0, 0);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridx = 0;
        constraints.gridy = 10;
        constraints.gridwidth = 2;
        this.add(calculateButton, constraints);





    }

    public JTable getResult() {
        return result;
    }
}
