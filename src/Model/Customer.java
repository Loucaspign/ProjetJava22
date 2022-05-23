package Model;

public class Customer {
    private String customerId;
    private String firstname;
    private String lastName;
    private String accountNumber;
    private String paymentType;
    private String streetBilling;
    private String streetNumberBilling;
    private String localityIdBilling;


    public Customer(String customerId, String firstname, String lastName, String accountNumber, String paymentType, String streetBilling, String streetNumberBilling, String localityIdBilling) {
        this.customerId = customerId;
        this.firstname = firstname;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.paymentType = paymentType;
        this.streetBilling = streetBilling;
        this.streetNumberBilling = streetNumberBilling;
        this.localityIdBilling = localityIdBilling;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getStreetBilling() {
        return streetBilling;
    }

    public String getStreetNumberBilling() {
        return streetNumberBilling;
    }

    public String getLocalityIdBilling() {
        return localityIdBilling;
    }

    public String toString() { return firstname + " " + lastName; }
}
