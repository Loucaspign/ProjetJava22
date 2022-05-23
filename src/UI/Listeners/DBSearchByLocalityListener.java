package UI.Listeners;

import UI.DBSearchLocalityPanel;
import UI.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DBSearchByLocalityListener implements ActionListener {
    private MainWindow mainWindow;

    public DBSearchByLocalityListener (MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainWindow.getFrameContainer().removeAll();
        mainWindow.getFrameContainer().add(new DBSearchLocalityPanel(mainWindow));
        mainWindow.repaint();
        mainWindow.printAll(mainWindow.getGraphics());
    }
}
