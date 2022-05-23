package DataAccess;

import Model.Exception.AddOrderException;
import Model.Exception.DeleteOrderException;
import Model.Exception.UpdateOrderException;
import Model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class DBOrderDataAccess implements OrderDataAccess{

    public void addOrder(Order order) throws AddOrderException {
        if (order.getOrderId() != null){
            try {
                Connection connection = SingletonConnection.getInstance();
                PreparedStatement statement = connection.prepareStatement("insert into `order`(order_id,seller_fk,customer_fk,order_date,sent_date,withdraw_date,payement_deadline,receipt_date,number_payment_reminder,is_paid,is_delivered,delivery_street,delivery_street_number,locality_fk)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                statement.setString(1, order.getOrderId());
                statement.setString(2, order.getSeller());
                statement.setString(3, order.getCustomer());
                // Conversion GregorianCalendar => java.sql.Date
                java.sql.Date sqlDate = new java.sql.Date(order.getOrderDate().getTimeInMillis());
                statement.setDate(4,sqlDate);

                if(order.getSentDate() == null) statement.setNull(5, Types.DATE);
                else statement.setDate(5, new java.sql.Date(order.getSentDate().getTimeInMillis()));

                if(order.getWithdrawalDate() == null)statement.setNull(6,Types.DATE);
                else statement.setDate(6, new java.sql.Date(order.getWithdrawalDate().getTimeInMillis()));


                java.sql.Date sqlDate1 = new java.sql.Date((order.getDeadlinePayment().getTimeInMillis()));
                statement.setDate(7,sqlDate1);

                if(order.getReceiptDate() == null) statement.setNull(8,Types.DATE);
                else statement.setDate(8, new java.sql.Date(order.getReceiptDate().getTimeInMillis()));

                statement.setInt(9,order.getNumberPaymentRemeinder());


                statement.setBoolean(10, order.isPaid());
                statement.setBoolean(11, order.isDelivered());
                if(order.getDeliveryStreet() == null) statement.setNull(12,Types.VARCHAR);
                else statement.setString(12, order.getDeliveryStreet());

                if(order.getDeliveryStreetNumber() == null) statement.setNull(13,Types.VARCHAR);
                else statement.setString(13, order.getDeliveryStreetNumber());

                // On fait une condition parce que si c'est pas delivered on doit pas mettre de localité
                if(order.getLocality() == null) statement.setNull(14,Types.VARCHAR);
                else statement.setString(14,order.getLocality());

                statement.executeUpdate();
            } catch (SQLException throwables){
                throw new AddOrderException();
            }
        }

    }

    public ArrayList<Order> getAllOrders() {
        ArrayList<Order> orderList = new ArrayList<>();
        try {
            Connection connection = SingletonConnection.getInstance();
            String query = ("select * from `order`");
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet data = statement.executeQuery(query);
            while (data.next())   {
                String orderId = data.getString(1);
                String sellerId = data.getString(2);
                String customerId = data.getString(3);
                GregorianCalendar orderDate = new GregorianCalendar();
                GregorianCalendar sentDate = new GregorianCalendar();
                GregorianCalendar withdrawalDate = new GregorianCalendar();
                GregorianCalendar paymentDeadline = new GregorianCalendar();
                GregorianCalendar receiptDate = new GregorianCalendar();
                orderDate.setTime(data.getDate(4));
                if (data.getDate(5) != null) sentDate.setTime(data.getDate(5));
                else sentDate = null;
                if(data.getDate(6) != null) withdrawalDate.setTime(data.getDate(6));
                else withdrawalDate = null;
                paymentDeadline.setTime(data.getDate(7));
                if(data.getDate(8) != null)receiptDate.setTime(data.getDate(8));
                else receiptDate = null;
                int numberPaymentReminder =  data.getInt(9);
                boolean isPaid = data.getBoolean(10);
                boolean isDelivered = data.getBoolean(11);
                String deliveryStreet = data.getString(12);
                String deliveryStreetNumber = data.getString(13);
                String localityId = data.getString(14);
                orderList.add(new Order(orderId, orderDate, sentDate, withdrawalDate, paymentDeadline, receiptDate, numberPaymentReminder, isPaid, isDelivered,deliveryStreet, deliveryStreetNumber, customerId, sellerId, localityId));
            }

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orderList;
    }

    public void updateOrder(Order order) throws UpdateOrderException {
        try {
            Connection connection = SingletonConnection.getInstance();
            String query = ("update `order` set order_id = ?, seller_fk = ?, customer_fk = ?, order_date = ?, sent_date = ?, withdraw_date = ?, payement_deadline = ?, receipt_date = ?, number_payment_reminder = ?, is_paid = ?, is_delivered = ?, delivery_street = ?, delivery_street_number = ?, locality_fk = ? where order_id = ?");
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, order.getOrderId());
            statement.setString(2, order.getSeller());
            statement.setString(3, order.getCustomer());
            // Conversion GregorianCalendar => java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(order.getOrderDate().getTimeInMillis());
            statement.setDate(4,sqlDate);

            if(order.getSentDate() == null) statement.setNull(5, Types.DATE);
            else statement.setDate(5, new java.sql.Date(order.getSentDate().getTimeInMillis()));

            if(order.getWithdrawalDate() == null)statement.setNull(6,Types.DATE);
            else statement.setDate(6, new java.sql.Date(order.getWithdrawalDate().getTimeInMillis()));

            java.sql.Date sqlDate1 = new java.sql.Date((order.getDeadlinePayment().getTimeInMillis()));
            statement.setDate(7,sqlDate1);

            if(order.getReceiptDate() == null) statement.setNull(8,Types.DATE);
            else statement.setDate(8, new java.sql.Date(order.getReceiptDate().getTimeInMillis()));

            statement.setInt(9,order.getNumberPaymentRemeinder());
            statement.setBoolean(10, order.isPaid());
            statement.setBoolean(11, order.isDelivered());
            if(order.getDeliveryStreet() == null) statement.setNull(12,Types.VARCHAR);
            else statement.setString(12, order.getDeliveryStreet());

            if(order.getDeliveryStreetNumber() == null) statement.setNull(13,Types.VARCHAR);
            else statement.setString(13, order.getDeliveryStreetNumber());

            if(order.getLocality() == null) statement.setNull(14,Types.VARCHAR);
            else statement.setString(14,order.getLocality());

            statement.setString(15, order.getOrderId());

            statement.executeUpdate();

        } catch (SQLException throwables) {
            throw new UpdateOrderException();
        }
    }

    public void deleteOrder(String orderId) throws DeleteOrderException {
        try {
            Connection connection = SingletonConnection.getInstance();
            String query = ("delete from `order` where order_id=?");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, orderId);

            statement.executeUpdate();

        } catch (SQLException throwables) {
            throw new DeleteOrderException();
        }
    }










    }
















