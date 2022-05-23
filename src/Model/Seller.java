package Model;

import java.util.GregorianCalendar;

public class Seller {
    private String sellerId;
    private String firstName;
    private String lastName;
    private GregorianCalendar hiringDate;

    public Seller(String sellerId, String firstName, String lastName, GregorianCalendar hiringDate) {
        this.sellerId = sellerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hiringDate = hiringDate;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String toString() {
        return firstName + " " + lastName;
    }


}
