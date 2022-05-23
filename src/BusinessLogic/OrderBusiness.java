package BusinessLogic;

import DataAccess.*;
import Model.*;
import Model.Exception.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

public class OrderBusiness {

    private OrderDataAccess orderDataAccess;

    private CustomerDataAccess customerDataAccess;
    private LocalityDataAccess localityDataAccess;
    private SellerDataAccess sellerDataAccess;
    private SearchDataAccess searchDataAccess;
    private ProductDataAccess productDataAccess;
    private DetailLineDataAccess detailLineDataAccess;

    private ArrayList<Order> orders;
    private ArrayList<DetailLine> detailLines;


    public OrderBusiness() {
        setOrderDataAccess(new DBOrderDataAccess());
        setCustomerDataAccess(new DBCustomerDataAccess());
        setLocalityDataAccess(new DBLocalityDataAccess());
        setSellerDataAccess(new DBSellerDataAccess());
        setSearchDataAccess(new DBSearchDataAccess());
        setProductDataAccess(new DBProductDataAccess());
        setDetailLineDataAccess(new DBDetailLineDataAccess());
    }

    private void setOrderDataAccess(DBOrderDataAccess orderDataAccess) {
        this.orderDataAccess = orderDataAccess;
    }

    private void setCustomerDataAccess(DBCustomerDataAccess customerDataAccess) { this.customerDataAccess = customerDataAccess; }

    private void setLocalityDataAccess(DBLocalityDataAccess localityDataAccess) {this.localityDataAccess = localityDataAccess; }

    private void setSellerDataAccess(DBSellerDataAccess sellerDataAccess) {this.sellerDataAccess = sellerDataAccess; }

    public void setSearchDataAccess(DBSearchDataAccess searchDataAccess) {
        this.searchDataAccess = searchDataAccess;
    }

    public void setProductDataAccess(ProductDataAccess productDataAccess) { this.productDataAccess = productDataAccess; }

    public void setDetailLineDataAccess(DBDetailLineDataAccess detailLineDataAccess) { this.detailLineDataAccess = detailLineDataAccess; }

    /*----------------------------------CRUD-----------------------------------------*/


    public void addNewOrder(Order order) throws AddOrderException {
        orderDataAccess.addOrder(order);
    }

    public void deleteOrder(String orderId) throws DeleteOrderException {
        orderDataAccess.deleteOrder(orderId);
    }


    public void updateOrder(Order order) throws UpdateOrderException {
        if(orderDataAccess.getAllOrders().stream().anyMatch(o -> o.getOrderId().equals(order.getOrderId()))){
            orderDataAccess.updateOrder(order);
            Order orderToDelete = orderDataAccess.getAllOrders().stream().filter(o -> o.getOrderId().equals(order.getOrderId())).findFirst().get();
            orderDataAccess.getAllOrders().remove(orderToDelete);
            orderDataAccess.getAllOrders().add(order);
        }
        else{
            throw new UpdateOrderException();
        }
    }




    public void deleteDetailLines(String orderId) throws DeleteDetailLineException {
        detailLineDataAccess.deleteDetailLine(orderId);
        ArrayList<DetailLine> linesToDelete = new ArrayList<DetailLine>(detailLineDataAccess.getAllDetailLine().stream().filter(l -> l.getOrder().equals(orderId)).collect(Collectors.toList()));
        for (DetailLine line:linesToDelete) {
            detailLineDataAccess.getAllDetailLine().remove(line);
        }
    }



    /*----------------------------------GET-------------------------------------------*/

    public ArrayList<Order> getOrders() {
        return orderDataAccess.getAllOrders();
    }

    public ArrayList<Customer> getCustomers() {
        return customerDataAccess.getAllCustomer();
    }

    public ArrayList<Seller> getSellers() {
        return sellerDataAccess.getAllSeller();
    }

    public ArrayList<Locality> getLocalities() {
        return localityDataAccess.getAllLocality();
    }

    public ArrayList<Product> getProducts() { return productDataAccess.getAllProduct(); }

    public ArrayList<DetailLine> getDetailLines() { return detailLineDataAccess.getAllDetailLine(); }


    /*---------------------------------SEARCHES----------------------------------------*/


    public ArrayList<LocalitySearchModel> searchByLocality(String localityId) throws SearchByLocalityException {
        return searchDataAccess.searchByLocality(localityId);
    }

    public ArrayList<DatesSearchModel> searchByDates(GregorianCalendar date1, GregorianCalendar date2) throws SearchByDatesException {
        return searchDataAccess.searchByDates(date1, date2);
    }

    public ArrayList<ProductSearchModel> searchByProduct(String code) throws SearchByProductException {
        return searchDataAccess.searchByProduct(code);
    }

    public ArrayList<CustomerSearchModel> searchByCustomer(String customerId) throws SearchByCustomerException {
        return searchDataAccess.searchByCustomer(customerId);
    }

    /*---------------------------------CALCUL----------------------------------------*/

    public double calculateOrder(String orderId){
        List<DetailLine> linesList = detailLineDataAccess.getAllDetailLine().stream().filter(dl -> dl.getOrder().equals(orderId)).collect(Collectors.toList());
        ArrayList<DetailLine> lines = new ArrayList<DetailLine>(linesList);
        double price = 0;
        for (DetailLine line:
                lines) {
            price += (line.getSellPrice() - line.getSellPrice() * line.getReduction()) * line.getQuantity();
        }
        return price;
    }

    public double calculateOrders(String orderId){
        List<DetailLine> linesList = detailLines.stream().filter(dl -> dl.getOrder().equals(orderId)).collect(Collectors.toList());
        ArrayList<DetailLine> lines = new ArrayList<DetailLine>(linesList);
        double price = 0;
        for (DetailLine line:
                lines) {
            price += (line.getSellPrice() - line.getSellPrice() * line.getReduction()) * line.getQuantity();
        }
        return price;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void setDetailLines(ArrayList<DetailLine> detailLines) {
        this.detailLines = detailLines;
    }


}
