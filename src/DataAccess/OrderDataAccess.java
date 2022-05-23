package DataAccess;

import Model.Exception.AddOrderException;
import Model.Exception.DeleteOrderException;
import Model.Exception.UpdateOrderException;
import Model.Order;

import java.util.ArrayList;

public interface OrderDataAccess {

    public abstract void addOrder(Order order) throws AddOrderException; //Create
    public abstract ArrayList<Order> getAllOrders(); //Read
    public abstract void updateOrder(Order order) throws UpdateOrderException; //Update
    public abstract void deleteOrder(String orderId) throws DeleteOrderException; //Delete

}
