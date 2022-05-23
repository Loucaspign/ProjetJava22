package UI.Listeners;

import UI.DBSearchCustomerPanel;
import UI.DBSearchLocalityPanel;
import UI.MainWindow;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DBSearchByCustomerListener implements MenuListener {
    private MainWindow mainWindow;

    public DBSearchByCustomerListener (MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    public void menuSelected(MenuEvent e) {
        mainWindow.getFrameContainer().removeAll();
        mainWindow.getFrameContainer().add(new DBSearchCustomerPanel(mainWindow));
        mainWindow.repaint();
        mainWindow.printAll(mainWindow.getGraphics());
    }
    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }




}
