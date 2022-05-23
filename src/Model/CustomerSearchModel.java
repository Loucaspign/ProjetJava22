package Model;

public class CustomerSearchModel {
    private String orderId;
    private String productName;
    private Integer quantity;
    private double reduction;
    private double sellPrice;

    public CustomerSearchModel(String orderId, String productName, Integer quantity, double reduction, double sellPrice) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.reduction = reduction;
        this.sellPrice = sellPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public double getReduction() {
        return reduction;
    }

    public double getSellPrice() {
        return sellPrice;
    }
}
