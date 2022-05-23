package Model;

public class DetailLine {
    private Integer quantity;
    private double reduction;
    private double sellPrice;
    private String order;
    private String product;


    public DetailLine(Integer quantity, double reduction, double sellPrice, String order, String product) {
        this.quantity = quantity;
        this.reduction = reduction;
        this.sellPrice = sellPrice;
        this.order = order;
        this.product = product;
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

    public String getOrder() {
        return order;
    }

    public String getProduct() {
        return product;
    }
}
