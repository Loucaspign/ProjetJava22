package DataAccess;

import Model.Customer;

import java.util.ArrayList;

public interface CustomerDataAccess {
    public abstract ArrayList<Customer> getAllCustomer(); //Read
}
