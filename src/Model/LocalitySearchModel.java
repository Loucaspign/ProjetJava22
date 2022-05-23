package Model;

public class LocalitySearchModel {
    private String customerLastname;
    private String customerFirstname;
    private String orderId;
    private String sellerLastname;
    private String sellerFirstname;

    public LocalitySearchModel(String customerLastname, String customerFirstname, String orderId, String sellerLastname, String sellerFirstname) {
        this.customerLastname = customerLastname;
        this.customerFirstname = customerFirstname;
        this.orderId = orderId;
        this.sellerLastname = sellerLastname;
        this.sellerFirstname = sellerFirstname;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerFirstname() {
        return customerFirstname;
    }

    public String getCustomerLastname() {
        return customerLastname;
    }

    public String getSellerFirstname() {
        return sellerFirstname;
    }

    public String getSellerLastname() {
        return sellerLastname;
    }

}
