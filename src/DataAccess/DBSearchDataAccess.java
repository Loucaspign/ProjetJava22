package DataAccess;

import Model.CustomerSearchModel;
import Model.DatesSearchModel;
import Model.Exception.SearchByCustomerException;
import Model.Exception.SearchByDatesException;
import Model.Exception.SearchByLocalityException;
import Model.Exception.SearchByProductException;
import Model.LocalitySearchModel;
import Model.ProductSearchModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class DBSearchDataAccess implements SearchDataAccess {

    public ArrayList<LocalitySearchModel> searchByLocality(String localityId) throws SearchByLocalityException {
        ArrayList<LocalitySearchModel> localityList = new ArrayList<>();
        try {
            Connection connection = SingletonConnection.getInstance();
            String query = ("select `order`.order_id,customer.lastname,customer.firstname,seller.lastname,seller.firstname from `order` INNER JOIN customer ON (`order`.customer_fk = customer.customer_id) INNER JOIN seller on (`order`.seller_fk = seller_id) INNER JOIN locality on (`order`.locality_fk = locality.locality_id)  where locality.locality_id = ?");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, localityId);
            ResultSet data = statement.executeQuery();
            while (data.next()){
                String order_id  = data.getString(1);
                String lastname_customer = data.getString(2);
                String firstname_customer  = data.getString(3);
                String lastname_seller = data.getString(4);
                String firstname_seller = data.getString(5);
                localityList.add(new LocalitySearchModel(lastname_customer,firstname_customer,order_id,lastname_seller,firstname_seller));
            }
        } catch (SQLException throwables) {
            throw new SearchByLocalityException();
        }

        return localityList;




    }

    public ArrayList<DatesSearchModel> searchByDates(GregorianCalendar date1, GregorianCalendar date2) throws SearchByDatesException {
        ArrayList<DatesSearchModel> orderList = new ArrayList<>();
        java.sql.Date sqlDate1 = new java.sql.Date(date1.getTimeInMillis());
        java.sql.Date sqlDate2 = new java.sql.Date(date2.getTimeInMillis());

        try {
            Connection connection = SingletonConnection.getInstance();
            String query = ("select `order`.order_date,`order`.order_id,detail_line.quantity, detail_line.sell_price,product.name from `order` INNER JOIN detail_line ON (`order`.order_id = detail_line.order_fk) INNER JOIN product on (detail_line.product_fk = product.code) where `order`.order_date between ? and ?");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDate(1, sqlDate1);
            statement.setDate(2, sqlDate2);
            ResultSet data = statement.executeQuery();
            while (data.next()) {
                GregorianCalendar orderDate = new GregorianCalendar();
                orderDate.setTime(data.getDate(1));
                String order_id = data.getString(2);
                int quantity = data.getInt(3);
                double sellPrice = data.getDouble(4);
                String productName = data.getString(5);
                orderList.add(new DatesSearchModel(orderDate, order_id, quantity, sellPrice, productName));
            }

        } catch (SQLException throwables) {
                throw new SearchByDatesException();
            }

            return orderList;


        }

    public ArrayList<ProductSearchModel> searchByProduct(String code) throws SearchByProductException {
        ArrayList<ProductSearchModel> productsList = new ArrayList<>();
        try{
            Connection connection = SingletonConnection.getInstance();

            String query = ("select customer.firstname, customer.lastname, customer.billing_street, customer.billing_street_number,  locality.zip_code, locality.`name`, order.payement_deadline from customer INNER JOIN `order` ON (`order` .customer_fk = customer.customer_id) INNER JOIN detail_line ON (detail_line.order_fk = `order` .order_id) INNER JOIN product ON (detail_line.product_fk = product.`code`) INNER JOIN locality ON (customer.locality_fk = locality.locality_id) where product.`code`=?");

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, code);

            ResultSet data = statement.executeQuery();
            while (data.next()){
                String firstname = data.getString(1);
                String lastname = data.getString(2);
                String billingStreet = data.getString(3);
                String billingStreetNumber = data.getString(4);
                int zipCode = data.getInt(5);
                String name = data.getString(6);
                GregorianCalendar paymentDeadline = new GregorianCalendar();
                paymentDeadline.setTime(data.getDate(7));

                productsList.add(new ProductSearchModel(paymentDeadline, firstname, lastname, billingStreet, billingStreetNumber, zipCode, name));
            }
        } catch (SQLException throwables) {
            throw new SearchByProductException();
        }
        return productsList;
    }

    public ArrayList<CustomerSearchModel> searchByCustomer(String customerId) throws SearchByCustomerException {
        ArrayList<CustomerSearchModel> customerList = new ArrayList<>();
        try {
            Connection connection = SingletonConnection.getInstance();
            String query = ("select `order`.order_id, product.name, detail_line.quantity, detail_line.reduction, detail_line.sell_price from detail_line INNER JOIN product ON (detail_line.product_fk = product.code) INNER JOIN `order` on (`order`.order_id = detail_line.order_fk) INNER JOIN customer on (`order`.customer_fk = customer_id) where customer.customer_id = ?");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, customerId);
            ResultSet data = statement.executeQuery();
            while (data.next()){
                String order_id = data.getString(1);
                String name_product  = data.getString(2);
                int detail_line_quantity = data.getInt(3);
                double detail_line_reduction  = data.getDouble(4);
                double detail_line_sellPrice = data.getDouble(5);
                customerList.add(new CustomerSearchModel(order_id,name_product,detail_line_quantity,detail_line_reduction,detail_line_sellPrice));
            }
        } catch (SQLException throwables) {
            throw new SearchByCustomerException();
        }

        return customerList;




    }











    }





