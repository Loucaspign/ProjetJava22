import Controller.OrderController;
import UI.MainWindow;

public class Main {
    public static void main(String[] args) {

        MainWindow mainWindow = new MainWindow(new OrderController());
    }
}
