package UI;

import UI.Listeners.BackButtonListener;
import UI.Listeners.DeleteButtonListener;
import UI.Listeners.UpdateButtonListener;

import javax.swing.*;
import java.awt.*;

public class ListingButtonPanel extends JPanel {
    private JButton backButton, updateButton, deleteButton;
    private MainWindow mainWindow;
    private OrderListingPanel orderListingPanel;


    public ListingButtonPanel(MainWindow mainWindow, OrderListingPanel orderListingPanel) {
        this.mainWindow = mainWindow;
        this.orderListingPanel = orderListingPanel;

        this.setLayout(new FlowLayout());
        backButton = new JButton("Back");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        backButton.addActionListener(new BackButtonListener(mainWindow));
        deleteButton.addActionListener(new DeleteButtonListener(orderListingPanel,mainWindow));
        updateButton.addActionListener(new UpdateButtonListener(orderListingPanel, mainWindow));

        this.add(backButton);
        this.add(deleteButton);
        this.add(updateButton);


    }
}
