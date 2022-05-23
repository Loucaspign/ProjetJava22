package Controller;

import BusinessLogic.OrderBusiness;
import Model.*;
import Model.Exception.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class OrderController {

    private OrderBusiness orderBusiness;

    public OrderController() {
        setOrderBusiness(new OrderBusiness());

    }

    public void setOrderBusiness(OrderBusiness orderBusiness){
        this.orderBusiness = orderBusiness;
    }


    /*----------------------------------CRUD-----------------------------------------*/


    public void addNewOrder(Order order) throws AddOrderException {
        orderBusiness.addNewOrder(order);
    }

    public void deleteOrder(String orderId) throws DeleteOrderException {
        orderBusiness.deleteOrder(orderId);
    }

    public void updateOrder(Order order) throws UpdateOrderException {
        orderBusiness.updateOrder(order);
    }

    public void deleteDetailLines(String orderId) throws DeleteDetailLineException {
        orderBusiness.deleteDetailLines(orderId);
    }

    /*----------------------------------GET-------------------------------------------*/



    public ArrayList<Order> getOrders() {
        return orderBusiness.getOrders();
    }

    public ArrayList<Seller> getSellers() { return orderBusiness.getSellers(); }

    public ArrayList<Locality> getLocalities() { return orderBusiness.getLocalities(); }

    public ArrayList<Customer> getCustomers() { return orderBusiness.getCustomers(); }

    public ArrayList<Product> getProducts() { return orderBusiness.getProducts();}



    /*---------------------------------SEARCHES----------------------------------------*/


    public ArrayList<LocalitySearchModel> searchByLocality(String localityId) throws SearchByLocalityException {
        return orderBusiness.searchByLocality(localityId);
    }

    public ArrayList<DatesSearchModel> searchByDates(GregorianCalendar date1, GregorianCalendar date2) throws SearchByDatesException {
        return orderBusiness.searchByDates(date1, date2);
    }

    public ArrayList<ProductSearchModel> searchByProduct(String code) throws SearchByProductException {
        return orderBusiness.searchByProduct(code);
    }

    public ArrayList<CustomerSearchModel> searchByCustomer(String customerId) throws SearchByCustomerException {
        return orderBusiness.searchByCustomer(customerId);
    }

    /*---------------------------------CALCUL----------------------------------------*/

    public double calculateOrder(String  orderId){
        return orderBusiness.calculateOrder(orderId);
    }








}
