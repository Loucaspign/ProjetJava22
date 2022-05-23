package UI.Listeners;

import UI.DBSearchProductPanel;
import UI.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DBSearchByProductListener implements ActionListener {
    private MainWindow mainWindow;

    public DBSearchByProductListener (MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainWindow.getFrameContainer().removeAll();
        mainWindow.getFrameContainer().add(new DBSearchProductPanel(mainWindow));
        mainWindow.repaint();
        mainWindow.printAll(mainWindow.getGraphics());
    }
}
