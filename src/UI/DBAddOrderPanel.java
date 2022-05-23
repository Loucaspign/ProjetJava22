package UI;

import javax.swing.*;
import java.awt.*;

public class DBAddOrderPanel extends JPanel {
    private DBAddOrderFormPanel dbAddOrderFormPanel;
    private DBAddOrderButtonPanel dbAddOrderButtonPanel;
    private MainWindow mainWindow;

    public DBAddOrderPanel(MainWindow mainWindow) {
        this.mainWindow = mainWindow;

        dbAddOrderFormPanel = new DBAddOrderFormPanel(mainWindow);
        dbAddOrderButtonPanel = new DBAddOrderButtonPanel(mainWindow, dbAddOrderFormPanel);

        dbAddOrderFormPanel.setAlignmentX(0);

        this.setLayout(new BorderLayout());
        this.add(dbAddOrderFormPanel, BorderLayout.CENTER);
        this.add(dbAddOrderButtonPanel, BorderLayout.SOUTH);
    }

}