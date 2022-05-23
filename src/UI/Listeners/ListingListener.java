package UI.Listeners;

import UI.MainWindow;
import UI.OrderListingPanel;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

public class ListingListener implements MenuListener {
    private MainWindow mainWindow;

    public ListingListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }


    @Override
    public void menuSelected(MenuEvent e) {
        mainWindow.getFrameContainer().removeAll();
        mainWindow.getFrameContainer().add(new OrderListingPanel(mainWindow), BorderLayout.CENTER);
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