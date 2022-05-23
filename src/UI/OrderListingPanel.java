package UI;

import UI.TablesModels.OrderTableModel;

import javax.swing.*;
import java.awt.*;

public class OrderListingPanel extends JPanel {
    private JTable jTable;
    private MainWindow mainWindow;
    private ListingButtonPanel listingButtonPanel;

    public OrderListingPanel(MainWindow mainWindow){
        super();

        this.setLayout(new GridBagLayout());
        listingButtonPanel = new ListingButtonPanel(mainWindow,this);
        this.mainWindow = mainWindow;
        jTable = new JTable(new OrderTableModel(mainWindow.getOrderController()));

        this.add(new JScrollPane(jTable), new GridBagConstraints(0, 0, 3, 1, 2.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

        this.add(listingButtonPanel, new GridBagConstraints(1, 2, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));



    }

    public JTable getjTable() {
        return jTable;
    }
}
