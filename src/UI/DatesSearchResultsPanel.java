package UI;

import Model.Exception.SearchByDatesException;
import UI.TablesModels.DatesSearchTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.GregorianCalendar;

public class DatesSearchResultsPanel extends JPanel {
    private JTable result;
    private MainWindow mainWindow;
    private GregorianCalendar date1, date2;

    public DatesSearchResultsPanel(MainWindow mainWindow, GregorianCalendar date1, GregorianCalendar date2) throws SearchByDatesException {
        super();

        this.mainWindow = mainWindow;
        this.date1 = date1;
        this.date2 = date2;

        this.setLayout(new BorderLayout());

        result = new JTable(new DatesSearchTableModel(mainWindow.getOrderController().searchByDates(date1, date2)));
        this.add(new JScrollPane(result), BorderLayout.CENTER);

    }
}
