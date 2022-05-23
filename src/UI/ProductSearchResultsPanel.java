package UI;

import Model.Exception.SearchByProductException;
import UI.TablesModels.ProductSearchTableModel;

import javax.swing.*;
import java.awt.*;

public class ProductSearchResultsPanel extends JPanel {
    private JTable result;
    private MainWindow mainWindow;
    private String code;

    public ProductSearchResultsPanel(MainWindow mainWindow, String code) throws SearchByProductException {
        super();

        this.setLayout(new BorderLayout());
        this.mainWindow = mainWindow;
        this.code = code;
        result = new JTable(new ProductSearchTableModel(mainWindow.getOrderController().searchByProduct(code)));
        this.add(new JScrollPane(result), BorderLayout.CENTER);
    }
}
