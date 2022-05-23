package UI.Listeners;

import UI.DBAddOrderPanel;
import UI.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DBAddOrderListener implements ActionListener {
    private MainWindow mainWindow;

    public DBAddOrderListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }
    public void actionPerformed(ActionEvent e){
        mainWindow.getFrameContainer().removeAll();
        mainWindow.getFrameContainer().add(new DBAddOrderPanel(mainWindow));
        mainWindow.repaint();
        mainWindow.printAll(mainWindow.getGraphics());
    }
}
