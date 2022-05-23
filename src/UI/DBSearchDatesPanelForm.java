package UI;

import javax.swing.*;
import java.awt.*;

public class DBSearchDatesPanelForm extends JPanel {
    private JSpinner date1, date2;
    private JLabel dateLabel1, dateLabel2;
    private MainWindow mainWindow;



    public DBSearchDatesPanelForm(MainWindow mainWindow){
        this.mainWindow = mainWindow;

        dateLabel1 = new JLabel("Date 1 : ");
        dateLabel2 = new JLabel("Date 2 : ");

        date1 = new JSpinner((new SpinnerDateModel()));
        date2 = new JSpinner((new SpinnerDateModel()));

        date1.setEditor(new JSpinner.DateEditor(date1,"dd/MM/yyyy"));
        date2.setEditor(new JSpinner.DateEditor(date2,"dd/MM/yyyy"));

        this.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(5, 3, 0, 0);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(dateLabel1, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(date1, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        this.add(dateLabel2, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        this.add(date2, constraints);
    }

    public MainWindow getMainWindow() {
        return mainWindow;
    }

    public JSpinner getDates1() {
        return date1;
    }

    public JSpinner getDates2() {
        return date2;
    }
}














