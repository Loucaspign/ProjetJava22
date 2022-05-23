package DataAccess;

import Model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBCustomerDataAccess implements CustomerDataAccess {
    public ArrayList<Customer> getAllCustomer() {
        ArrayList<Customer> CustomerList = new ArrayList<Customer>();

        try{
            Connection connection = SingletonConnection.getInstance();


            String query = ("select * from customer");
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet data = statement.executeQuery(query);

            while (data.next()){
                String customerId = data.getString(1);
                String firstname = data.getString(2);
                String lastname = data.getString(3);
                String accountNumber = data.getString(4);
                String paymentType = data.getString(5);
                String billingStreet = data.getString(6);
                String billingStreetNumber = data.getString(7);
                String localityId = data.getString(8);
                CustomerList.add(new Customer(customerId, firstname, lastname, accountNumber, paymentType, billingStreet, billingStreetNumber, localityId));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return CustomerList;
    }

}
