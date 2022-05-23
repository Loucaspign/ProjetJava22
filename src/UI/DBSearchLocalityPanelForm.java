package UI;

import Model.Locality;

import javax.swing.*;
import java.util.ArrayList;

public class DBSearchLocalityPanelForm extends JPanel {
    private JComboBox localityComboB;
    private JLabel localityLabel;
    private MainWindow mainWindow;
    private ArrayList<Locality> localities;

    public DBSearchLocalityPanelForm(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.localities = mainWindow.getOrderController().getLocalities();
        localityLabel = new JLabel("Locality : ");
        localityComboB = new JComboBox();

        for (Locality locality: localities) {
            localityComboB.addItem(new ComboItem((locality.getName() + "(" + locality.getZipCode() + ")"), locality.getLocalityId()));
        }
        this.add(localityLabel);
        this.add(localityComboB);

    }

    public MainWindow getMainWindow() {
        return mainWindow;
    }

    public JComboBox getLocalityComboB() {
        return localityComboB;
    }
}
