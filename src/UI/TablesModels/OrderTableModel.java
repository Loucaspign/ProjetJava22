package UI.TablesModels;

import Controller.OrderController;

import javax.swing.table.AbstractTableModel;
import java.util.Date;

public class OrderTableModel extends AbstractTableModel {

    private OrderController orderController;

    private final String[] columnsName = {"Order ID", "Customer", "Seller", "Order date", "Sent date", "Withdrawal date", "Deadline payment", "Receipt date", "Payment reminders", "Paid", "Delivered", "Delivery street",
            "Delivery street number", "Delivery locality"};


    public OrderTableModel(OrderController orderController){
        super();
        this.orderController = orderController;
    }

    @Override
    public int getRowCount() {
        return orderController.getOrders().size();
    }
    @Override
    public int getColumnCount() {
        return columnsName.length;
    }
    @Override
    public String getColumnName(int column) {
        return columnsName[column];
    }


    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> orderController.getOrders().get(rowIndex).getOrderId();
            case 1 -> orderController.getCustomers().stream().filter(c -> c.getCustomerId().equals(orderController.getOrders().get(rowIndex).getCustomer())).findFirst().get();
            case 2 -> orderController.getSellers().stream().filter(s -> s.getSellerId().equals(orderController.getOrders().get(rowIndex).getSeller())).findFirst().get();
            case 3 -> (orderController.getOrders().get(rowIndex).getOrderDate().getTime());
            case 4 -> (orderController.getOrders().get(rowIndex).getSentDate() != null) ? orderController.getOrders().get(rowIndex).getSentDate().getTime() : null;
            case 5 -> (orderController.getOrders().get(rowIndex).getWithdrawalDate() != null) ? orderController.getOrders().get(rowIndex).getWithdrawalDate().getTime() : null;
            case 6 -> (orderController.getOrders().get(rowIndex).getDeadlinePayment() != null) ? orderController.getOrders().get(rowIndex).getDeadlinePayment().getTime() : null;
            case 7 -> (orderController.getOrders().get(rowIndex).getReceiptDate() != null) ? orderController.getOrders().get(rowIndex).getReceiptDate().getTime() : null;
            case 8 -> orderController.getOrders().get(rowIndex).getNumberPaymentRemeinder();
            case 9 -> orderController.getOrders().get(rowIndex).isPaid();
            case 10 -> orderController.getOrders().get(rowIndex).isDelivered();
            case 11 -> (orderController.getOrders().get(rowIndex).getDeliveryStreet() != null) ? orderController.getOrders().get(rowIndex).getDeliveryStreet() : null;
            case 12 -> (orderController.getOrders().get(rowIndex).getDeliveryStreetNumber() != null) ? orderController.getOrders().get(rowIndex).getDeliveryStreetNumber() : null;
            case 13 -> (orderController.getOrders().get(rowIndex).getLocality() != null) ? orderController.getOrders().get(rowIndex).getLocality() : null;
            default -> null;
        };
    }

        public Class<?> getColumnClass(int columnIndex) {
            return switch (columnIndex){
                case 0 -> String.class;
                case 1 -> String.class;
                case 2 -> String.class;
                case 3 -> Date.class;
                case 4 -> Date.class;
                case 5 -> Date.class;
                case 6 -> Date.class;
                case 7 -> Date.class;
                case 8 -> Integer.class;
                case 9 -> Boolean.class;
                case 10 -> Boolean.class;
                case 11 -> String.class;
                case 12 -> String.class;
                case 13 -> String.class;
                default -> null;
            };
        }



    }










