package Model;

public class Product {
    private String code;
    private String name;
    private double price;
    private double VAT;

    public Product(String code, String name, double price, double VAT) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.VAT = VAT;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
