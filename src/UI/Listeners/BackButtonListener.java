package UI.Listeners;

import UI.LogoPanel;
import UI.MainWindow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackButtonListener implements ActionListener {
    private MainWindow mainWindow;

    public BackButtonListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainWindow.getFrameContainer().removeAll();
        mainWindow.getFrameContainer().add(new LogoPanel(), BorderLayout.CENTER);
        mainWindow.repaint();
        mainWindow.printAll(mainWindow.getGraphics());
    }
}
