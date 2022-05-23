package UI;

import javax.swing.*;
import java.awt.*;

public class DBUpdateOrderPanel extends JPanel {
    private DBAddOrderFormPanel dbAddOrderFormPanel;
    private DBUpdateOrderButtonPanel dbUpdateOrderButtonPanel;
    private MainWindow mainWindow;

    public DBUpdateOrderPanel(MainWindow mainWindow) {
        this.mainWindow = mainWindow;


        dbAddOrderFormPanel = new DBAddOrderFormPanel(mainWindow);
        dbUpdateOrderButtonPanel = new DBUpdateOrderButtonPanel(mainWindow, dbAddOrderFormPanel);
        dbAddOrderFormPanel.setAlignmentX(0);

        this.setLayout(new BorderLayout());
        this.add(dbAddOrderFormPanel, BorderLayout.CENTER);
        this.add(dbUpdateOrderButtonPanel, BorderLayout.SOUTH);

    }

    public DBAddOrderFormPanel getDbAddFormPanel() {
        return dbAddOrderFormPanel;
    }
}



