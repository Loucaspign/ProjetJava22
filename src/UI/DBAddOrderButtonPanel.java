package UI;

import UI.Listeners.BackButtonListener;
import UI.Listeners.ValidateButtonListener;

import javax.swing.*;
import java.awt.*;

public class DBAddOrderButtonPanel extends JPanel {
    private JButton backButton, validationButton;
    private MainWindow mainWindow;
    private DBAddOrderFormPanel dbAddOrderFormPanel;

    public DBAddOrderButtonPanel(MainWindow mainWindow, DBAddOrderFormPanel dbAddOrderFormPanel) {
        this.mainWindow = mainWindow;
        this.dbAddOrderFormPanel = dbAddOrderFormPanel;

        this.setLayout(new FlowLayout());

        backButton = new JButton("Back");
        validationButton = new JButton("Validate");

        backButton.addActionListener(new BackButtonListener(mainWindow));
        validationButton.addActionListener(new ValidateButtonListener(dbAddOrderFormPanel, mainWindow));

        this.add(backButton);
        this.add(validationButton);
    }
}