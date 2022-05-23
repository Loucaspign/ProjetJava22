package Model;

import java.util.GregorianCalendar;

public class DatesSearchModel {
    private GregorianCalendar orderDate;
    private String orderId;
    private Integer quantity;
    private double sellPrice;
    private String productName;

    public DatesSearchModel(GregorianCalendar orderDate, String orderId, Integer quantity, double sellPrice, String productName) {
        this.orderDate = orderDate;
        this.orderId = orderId;
        this.quantity = quantity;
        this.sellPrice = sellPrice;
        this.productName = productName;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public GregorianCalendar getOrderDate() {
        return orderDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getProductName() {
        return productName;
    }
}
