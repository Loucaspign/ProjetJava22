package UI;

import UI.Listeners.BackButtonListener;
import UI.Listeners.ValidateSearchCustomerButtonListener;

import javax.swing.*;
import java.awt.*;

public class DBSearchCustomerPanel extends JPanel {
    private DBSearchCustomerPanelForm dbSearchCustomerPanelForm;
    private JButton validationButton;
    private JButton backButton;
    private MainWindow mainWindow;

    public DBSearchCustomerPanel(MainWindow mainWindow){
        this.mainWindow = mainWindow;


        dbSearchCustomerPanelForm = new DBSearchCustomerPanelForm(mainWindow);

        validationButton = new JButton("Validate");
        backButton = new JButton("Back");
        dbSearchCustomerPanelForm.setAlignmentX(0);

        validationButton.addActionListener(new ValidateSearchCustomerButtonListener(dbSearchCustomerPanelForm));
        backButton.addActionListener(new BackButtonListener(mainWindow));

        this.add(dbSearchCustomerPanelForm, BorderLayout.CENTER);

        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(5, 3, 0, 0);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(validationButton, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        this.add(backButton, constraints);












    }
}
