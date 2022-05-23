package Model;

import java.util.GregorianCalendar;

public class ProductSearchModel {
    private GregorianCalendar paymentDeadline;
    private String firstname;
    private String lastname;
    private String billingStreet;
    private String billingStreetNumber;
    private Integer zipCode;
    private String localityName;

    public ProductSearchModel(java.util.GregorianCalendar paymentDeadline, String firstname, String lastname, String billingStreet, String billingStreetNumber, Integer zipCode, String localityName) {
        this.paymentDeadline = paymentDeadline;
        this.firstname = firstname;
        this.lastname = lastname;
        this.billingStreet = billingStreet;
        this.billingStreetNumber = billingStreetNumber;
        this.zipCode = zipCode;
        this.localityName = localityName;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBillingStreet() {
        return billingStreet;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public String getLocalityName() {
        return localityName;
    }

    public String getFirstname() {
        return firstname;
    }

    public GregorianCalendar getPaymentDeadline() {
        return paymentDeadline;
    }

    public String getBillingStreetNumber() {
        return billingStreetNumber;
    }
}
