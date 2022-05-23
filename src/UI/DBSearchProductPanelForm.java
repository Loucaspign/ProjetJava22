package UI;

import Model.Product;

import javax.swing.*;
import java.util.ArrayList;

public class DBSearchProductPanelForm extends JPanel {
    private JComboBox productComboB;
    private JLabel productLabel;
    private MainWindow mainWindow;
    private ArrayList<Product> products;


    public DBSearchProductPanelForm(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.products = mainWindow.getOrderController().getProducts();
        productLabel = new JLabel("Product : ");
        productComboB = new JComboBox();

        for (Product product : products) {
            productComboB.addItem(new ComboItem(product.getName(),product.getCode()));
        }
        this.add(productLabel);
        this.add(productComboB);


    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public JComboBox getProductComboB() {
        return productComboB;
    }

    public MainWindow getMainWindow() {
        return mainWindow;
    }

}
