package UI;

import Model.Customer;
import Model.Locality;
import Model.Seller;
import UI.Listeners.IsDeliveredListener;

import javax.swing.*;
import java.awt.*;

public class DBAddOrderFormPanel extends JPanel {
    private JLabel orderIdLabel, sellerLabel, customerLabel, releaseDateLabel, withdrawDateLabel,
            deadlinePaymentLabel, numberPaymentReminderLabel, isPaidLabel, isDeliveredLabel, sendDateLabel,
            receiptDateLabel,deliveryStreetLabel, deliveryStreetNumberLabel, localityLabel;
    private JTextField orderIdTF, deliveryStreetTF, deliveryStreetNumberTF;
    private JCheckBox isPaidCheckB, isDeliveredCheckB;
    private JSpinner  releaseDateSpinner, deadlinePaymentSpinner, sendDateSpinner, receiptDateSpinner,
            withdrawDateSpinner, numberPaymentReminderSpinner;
    private JComboBox sellerComboB, customerComboB, localityComboB;
    private MainWindow mainWindow;

    public DBAddOrderFormPanel(MainWindow mainWindow) {

        this.mainWindow = mainWindow;

        orderIdLabel = new JLabel("Order ID :");
        sellerLabel = new JLabel("Seller :");
        customerLabel = new JLabel("Customer :");
        releaseDateLabel = new JLabel("Order date :");
        withdrawDateLabel = new JLabel("Withdrawal date :");
        deadlinePaymentLabel = new JLabel("Deadline :");
        numberPaymentReminderLabel = new JLabel("Number of payment reminder :");
        isPaidLabel = new JLabel("Paid");
        isDeliveredLabel = new JLabel("Delivered");
        sendDateLabel = new JLabel("Sent date :");
        receiptDateLabel = new JLabel("Receipt date :");
        deliveryStreetLabel = new JLabel("Delivery street :");
        deliveryStreetNumberLabel = new JLabel("Delivery street number :");
        localityLabel = new JLabel("Locality :");





        orderIdTF = new JTextField();
        deliveryStreetNumberTF = new JTextField();
        deliveryStreetTF = new JTextField();

        isPaidCheckB = new JCheckBox();
        isDeliveredCheckB = new JCheckBox();
        isDeliveredCheckB.addItemListener(new IsDeliveredListener(this));

        releaseDateSpinner = new JSpinner(new SpinnerDateModel());
        deadlinePaymentSpinner = new JSpinner(new SpinnerDateModel());
        withdrawDateSpinner = new JSpinner(new SpinnerDateModel());
        receiptDateSpinner = new JSpinner(new SpinnerDateModel());
        sendDateSpinner = new JSpinner(new SpinnerDateModel());

        SpinnerNumberModel model = new SpinnerNumberModel(0,0 ,1000,1);
        numberPaymentReminderSpinner = new JSpinner(model);


        releaseDateSpinner.setEditor(new JSpinner.DateEditor(releaseDateSpinner, "dd/MM/yyyy"));
        deadlinePaymentSpinner.setEditor(new JSpinner.DateEditor(deadlinePaymentSpinner, "dd/MM/yyyy"));
        withdrawDateSpinner.setEditor(new JSpinner.DateEditor(withdrawDateSpinner, "dd/MM/yyyy"));
        receiptDateSpinner.setEditor(new JSpinner.DateEditor(receiptDateSpinner, "dd/MM/yyyy"));
        sendDateSpinner.setEditor(new JSpinner.DateEditor(sendDateSpinner, "dd/MM/yyyy"));

        sellerComboB = new JComboBox();

        for (Seller seller:
                mainWindow.getOrderController().getSellers()) {
            sellerComboB.addItem(new ComboItem(seller.toString(), seller.getSellerId()));
        }

        customerComboB = new JComboBox();

        for (Customer customer:
                mainWindow.getOrderController().getCustomers()) {
            customerComboB.addItem(new ComboItem(customer.toString(), customer.getCustomerId()));
        }

        localityComboB = new JComboBox();

        for (Locality locality:
                mainWindow.getOrderController().getLocalities()) {
            localityComboB.addItem(new ComboItem(locality.getName(), locality.getLocalityId()));
        }


        orderIdLabel.setHorizontalAlignment(JLabel.RIGHT);
        sellerLabel.setHorizontalAlignment(JLabel.RIGHT);
        customerLabel.setHorizontalAlignment(JLabel.RIGHT);

        releaseDateLabel.setHorizontalAlignment(JLabel.RIGHT);

        withdrawDateLabel.setHorizontalAlignment(JLabel.RIGHT);
        deadlinePaymentLabel.setHorizontalAlignment(JLabel.RIGHT);
        isPaidLabel.setHorizontalAlignment(JLabel.RIGHT);
        isDeliveredLabel.setHorizontalAlignment(JLabel.RIGHT);

        receiptDateLabel.setHorizontalAlignment(JLabel.RIGHT);
        sendDateLabel.setHorizontalAlignment(JLabel.RIGHT);
        deliveryStreetNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
        deliveryStreetLabel.setHorizontalAlignment(JLabel.RIGHT);
        localityLabel.setHorizontalAlignment(JLabel.RIGHT);


        this.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(5, 3, 0, 0);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(orderIdLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        this.add(orderIdTF, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        this.add(sellerLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        this.add(sellerComboB, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        this.add(customerLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        this.add(customerComboB, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        this.add(releaseDateLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        this.add(releaseDateSpinner, constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        this.add(deadlinePaymentLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        this.add(deadlinePaymentSpinner, constraints);

        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        this.add(numberPaymentReminderLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        this.add(numberPaymentReminderSpinner, constraints);


        constraints.gridx = 1;
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        this.add(isPaidLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 6;
        this.add(isPaidCheckB, constraints);

        constraints.gridx = 3;
        constraints.gridy = 6;
        this.add(isDeliveredLabel, constraints);

        constraints.gridx = 4;
        constraints.gridy = 6;
        this.add(isDeliveredCheckB, constraints);

        constraints.gridx = 1;
        constraints.gridy = 7;
        constraints.gridwidth = 1;
        this.add(withdrawDateLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 7;
        constraints.gridwidth = 2;
        this.add(withdrawDateSpinner, constraints);

        constraints.gridx = 1;
        constraints.gridy = 8;
        constraints.gridwidth = 1;
        this.add(sendDateLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 8;
        constraints.gridwidth = 2;
        sendDateSpinner.setEnabled(false);
        this.add(sendDateSpinner, constraints);

        constraints.gridx = 1;
        constraints.gridy = 9;
        constraints.gridwidth = 1;
        this.add(receiptDateLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 9;
        constraints.gridwidth = 2;
        receiptDateSpinner.setEnabled(false);
        this.add(receiptDateSpinner, constraints);

        constraints.gridx = 1;
        constraints.gridy = 10;
        constraints.gridwidth = 1;
        this.add(deliveryStreetLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 10;
        constraints.gridwidth = 2;
        deliveryStreetTF.setEnabled(false);
        this.add(deliveryStreetTF, constraints);

        constraints.gridx = 1;
        constraints.gridy = 11;
        constraints.gridwidth = 1;
        this.add(deliveryStreetNumberLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 11;
        constraints.gridwidth = 2;
        deliveryStreetNumberTF.setEnabled(false);
        this.add(deliveryStreetNumberTF, constraints);

        constraints.gridx = 1;
        constraints.gridy = 12;
        constraints.gridwidth = 1;
        this.add(localityLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 12;
        constraints.gridwidth = 2;
        localityComboB.setEnabled(false);
        this.add(localityComboB, constraints);

    }

    public JCheckBox getIsDeliveredCheckB() {
        return isDeliveredCheckB;
    }

    public JSpinner getWithdrawDateSpinner() {
        return withdrawDateSpinner;
    }

    public JSpinner getSendDateSpinner() {
        return sendDateSpinner;
    }

    public JSpinner getReceiptDateSpinner() {
        return receiptDateSpinner;
    }

    public JSpinner getNumberPaymentReminderSpinner() {
        return numberPaymentReminderSpinner;
    }

    public JTextField getDeliveryStreetNumberTF() {
        return deliveryStreetNumberTF;
    }

    public JTextField getDeliveryStreetTF() {
        return deliveryStreetTF;
    }

    public JComboBox getLocalityComboB() {
        return localityComboB;
    }

    public JCheckBox getIsPaidCheckB() {
        return isPaidCheckB;
    }

    public JComboBox getCustomerComboB() {
        return customerComboB;
    }

    public JComboBox getSellerComboB() {
        return sellerComboB;
    }

    public JSpinner getDeadlinePaymentSpinner() {
        return deadlinePaymentSpinner;
    }

    public JSpinner getReleaseDateSpinner() {
        return releaseDateSpinner;
    }

    public JTextField getOrderIdTF() {
        return orderIdTF;
    }


    public MainWindow getMainWindow() {
        return mainWindow;
    }

}
