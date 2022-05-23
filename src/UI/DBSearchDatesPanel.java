package UI;

import UI.Listeners.BackButtonListener;
import UI.Listeners.ValidateSearchDatesButtonListener;

import javax.swing.*;
import java.awt.*;

public class DBSearchDatesPanel extends JPanel {
    private DBSearchDatesPanelForm dbSearchDatesPanelForm;
    private JButton validationButton;
    private JButton backButton;
    private MainWindow mainWindow;

    public DBSearchDatesPanel(MainWindow mainWindow){
        this.mainWindow = mainWindow;

        dbSearchDatesPanelForm = new DBSearchDatesPanelForm(mainWindow);
        validationButton = new JButton("Validate");
        backButton = new JButton("Back");

        validationButton.addActionListener(new ValidateSearchDatesButtonListener(dbSearchDatesPanelForm));
        backButton.addActionListener(new BackButtonListener(mainWindow));

        this.add(dbSearchDatesPanelForm, BorderLayout.CENTER);
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
