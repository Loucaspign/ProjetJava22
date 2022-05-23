package UI;

import UI.Listeners.BackButtonListener;
import UI.Listeners.ValidateSearchLocalityButtonListener;

import javax.swing.*;
import java.awt.*;

public class DBSearchLocalityPanel extends JPanel {
    private DBSearchLocalityPanelForm dbSearchLocalityPanelForm;
    private JButton validationButton;
    private JButton backButton;
    private MainWindow mainWindow;

    public DBSearchLocalityPanel(MainWindow mainWindow){
        this.mainWindow = mainWindow;

        dbSearchLocalityPanelForm = new DBSearchLocalityPanelForm(mainWindow);

        validationButton = new JButton("Validate");
        backButton = new JButton("Back");
        dbSearchLocalityPanelForm.setAlignmentX(0);

        validationButton.addActionListener(new ValidateSearchLocalityButtonListener(dbSearchLocalityPanelForm));
        backButton.addActionListener(new BackButtonListener(mainWindow));


        this.add(dbSearchLocalityPanelForm, BorderLayout.CENTER);

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
