package UI;

import Controller.OrderController;
import DataAccess.SingletonConnection;
import UI.Listeners.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class MainWindow extends JFrame {
    private JMenuBar menuBar;
    private JMenu applicationMenu, searchesMenu, listingTablesMenu, DBManagementMenu, clientOrderMenu;
    private JMenuItem DBSearchByLocality, DBSearchByDates, DBSearchByProduct, DBAddOrder, exit;
    private Container frameContainer;
    private LogoPanel logoPanel;
    private OrderController orderController;


    public MainWindow (OrderController orderController) {
        super("Brewery manager");

        this.orderController = orderController;

        setBounds(10,10,1300,800);

        addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e){
                        System.exit(0);
                        try {
                            SingletonConnection.getInstance().close();
                        } catch (SQLException throwables) {
                            JOptionPane.showMessageDialog(null, "Error while closing db connection", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });


        ImageIcon windowIcon = new ImageIcon("pics/beer-3.png");
        ImageIcon databaseIcon = new ImageIcon("pics/database.png");
        ImageIcon listIcon = new ImageIcon("pics/list.png");
        ImageIcon searchIcon = new ImageIcon("pics/search.png");
        ImageIcon appIcon = new ImageIcon("pics/apps.png");
        ImageIcon exitIcon = new ImageIcon("pics/quit.png");
        ImageIcon addIcon = new ImageIcon("pics/plus.png");
        ImageIcon mapIcon = new ImageIcon("pics/map.png");
        ImageIcon calendarIcon = new ImageIcon("pics/calendar.png");
        ImageIcon productIcon = new ImageIcon("pics/product.png");
        ImageIcon clientOrderIcon = new ImageIcon("pics/dollar.png");


        // image de la fenêtre
        this.setIconImage(windowIcon.getImage());

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        applicationMenu = new JMenu("Application");
        searchesMenu = new JMenu("Searches");

        listingTablesMenu = new JMenu("Tables listing");
        ListingListener listingListener = new ListingListener(this);
        listingTablesMenu.addMenuListener(listingListener);

        DBManagementMenu = new JMenu("DB Management");

        clientOrderMenu = new JMenu("Order client");
        DBSearchByCustomerListener dbSearchByCustomerListener = new DBSearchByCustomerListener(this);
        clientOrderMenu.addMenuListener(dbSearchByCustomerListener);


        DBManagementMenu.setIcon(databaseIcon);
        listingTablesMenu.setIcon(listIcon);
        searchesMenu.setIcon(searchIcon);
        applicationMenu.setIcon(appIcon);
        clientOrderMenu.setIcon(clientOrderIcon);


        menuBar.add(applicationMenu);
        menuBar.add(searchesMenu);
        menuBar.add(listingTablesMenu);
        menuBar.add(DBManagementMenu);
        menuBar.add(clientOrderMenu);

        exit = new JMenuItem("Exit", exitIcon);
        ExitListener exitListener = new ExitListener();
        exit.addActionListener(exitListener);

        DBAddOrder = new JMenuItem("Add order", addIcon);
        DBAddOrderListener dbAddOrderListener = new DBAddOrderListener(this);
        DBAddOrder.addActionListener(dbAddOrderListener);


        applicationMenu.add(exit);
        DBManagementMenu.add(DBAddOrder);

        DBSearchByLocality = new JMenuItem("Search by locality",mapIcon);
        DBSearchByLocalityListener dbSearchByLocalityListener = new DBSearchByLocalityListener(this);
        DBSearchByLocality.addActionListener(dbSearchByLocalityListener);

        DBSearchByDates = new JMenuItem("Search by dates",calendarIcon);
        DBSearchByDatesListener dbSearchByDatesListener = new DBSearchByDatesListener(this);
        DBSearchByDates.addActionListener(dbSearchByDatesListener);

        DBSearchByProduct = new JMenuItem("Search by product",productIcon);
        DBSearchByProductListener dbSearchByProductListener = new DBSearchByProductListener(this);
        DBSearchByProduct.addActionListener(dbSearchByProductListener);

        searchesMenu.add(DBSearchByLocality);
        searchesMenu.add(DBSearchByDates);
        searchesMenu.add(DBSearchByProduct);




        logoPanel = new LogoPanel();
        frameContainer = this.getContentPane();
        frameContainer.setLayout(new BorderLayout());
        frameContainer.add(logoPanel, BorderLayout.CENTER);



        setVisible(true);



    }

        public Container getFrameContainer() {
        return frameContainer;
    }

        public OrderController getOrderController() {
        return orderController;
    }








}
