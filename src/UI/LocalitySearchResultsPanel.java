package UI;

import Model.Exception.SearchByLocalityException;
import UI.TablesModels.LocalitySearchTableModel;

import javax.swing.*;
import java.awt.*;

public class LocalitySearchResultsPanel extends JPanel {
    private JTable result;
    private MainWindow mainWindow;
    private String localityId;

    public LocalitySearchResultsPanel(MainWindow mainWindow, String localityId) throws SearchByLocalityException {
        super();

        this.mainWindow = mainWindow;
        this.localityId = localityId;

        this.setLayout(new BorderLayout());

        result = new JTable(new LocalitySearchTableModel(mainWindow.getOrderController().searchByLocality(localityId)));
        this.add(new JScrollPane(result), BorderLayout.CENTER);
    }

}
