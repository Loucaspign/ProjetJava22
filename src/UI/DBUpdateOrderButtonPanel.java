package UI;

import UI.Listeners.BackButtonListener;
import UI.Listeners.ModifyButtonListener;

import javax.swing.*;
import java.awt.*;

public class DBUpdateOrderButtonPanel extends JPanel {
    private JButton backButton, modifyButton;
    private MainWindow mainWindow;
    private DBAddOrderFormPanel dbAddOrderFormPanel;


    public DBUpdateOrderButtonPanel(MainWindow mainWindow, DBAddOrderFormPanel dbAddOrderFormPanel) {
        this.mainWindow = mainWindow;
        this.dbAddOrderFormPanel = dbAddOrderFormPanel;


        this.setLayout(new FlowLayout());

        backButton = new JButton("Back");
        modifyButton = new JButton("Modify");

        backButton.addActionListener(new BackButtonListener(mainWindow));
        modifyButton.addActionListener(new ModifyButtonListener(dbAddOrderFormPanel));

        this.add(backButton);
        this.add(modifyButton);
    }

}
