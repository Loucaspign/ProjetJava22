package UI.Listeners;

import UI.DBSearchDatesPanel;
import UI.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DBSearchByDatesListener implements ActionListener {
    private MainWindow mainWindow;

    public DBSearchByDatesListener (MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainWindow.getFrameContainer().removeAll();
        mainWindow.getFrameContainer().add(new DBSearchDatesPanel(mainWindow));
        mainWindow.repaint();
        mainWindow.printAll(mainWindow.getGraphics());
    }




}
