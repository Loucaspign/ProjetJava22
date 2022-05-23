package UI;

import UI.Listeners.BackButtonListener;
import UI.Listeners.ValidateSearchProductButtonListener;

import javax.swing.*;
import java.awt.*;

public class DBSearchProductPanel extends JPanel {
    private DBSearchProductPanelForm dbSearchProductPanelForm;
    private MainWindow mainWindow;
    private JButton validationButton;
    private JButton backButton;

    public DBSearchProductPanel(MainWindow mainWindow){
        this.mainWindow = mainWindow;

        dbSearchProductPanelForm = new DBSearchProductPanelForm(mainWindow);

        validationButton = new JButton("Validate");
        backButton = new JButton("Back");

        dbSearchProductPanelForm.setAlignmentX(0);

        validationButton.addActionListener(new ValidateSearchProductButtonListener(dbSearchProductPanelForm));
        backButton.addActionListener(new BackButtonListener(mainWindow));


        this.add(dbSearchProductPanelForm, BorderLayout.CENTER);


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
