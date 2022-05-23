package Model;

import java.util.GregorianCalendar;

public class Order {
    private String orderId;
    private GregorianCalendar orderDate;
    private GregorianCalendar sentDate;
    private GregorianCalendar withdrawalDate;
    private GregorianCalendar deadlinePayment;
    private GregorianCalendar receiptDate;
    private Integer numberPaymentRemeinder;
    private boolean isPaid;
    private boolean isDelivered;
    private String deliveryStreet;
    private String deliveryStreetNumber;
    private String customerId;
    private String sellerId;
    private String localityId;


    public Order(String orderId, GregorianCalendar orderDate, GregorianCalendar sentDate, GregorianCalendar withdrawalDate, GregorianCalendar deadlinePayment, GregorianCalendar receiptDate, Integer numberPaymentRemeinder, boolean isPaid, boolean isDelivered, String deliveryStreet, String deliveryStreetNumber, String customer, String seller, String locality) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.sentDate = sentDate;
        this.withdrawalDate = withdrawalDate;
        this.deadlinePayment = deadlinePayment;
        this.receiptDate = receiptDate;
        this.numberPaymentRemeinder = numberPaymentRemeinder;
        this.isPaid = isPaid;
        this.isDelivered = isDelivered;
        this.deliveryStreet = deliveryStreet;
        this.deliveryStreetNumber = deliveryStreetNumber;
        this.customerId = customer;
        this.sellerId = seller;
        this.localityId = locality;
    }


    public String getOrderId() {
        return orderId;
    }

    public GregorianCalendar getOrderDate() {
        return orderDate;
    }

    public GregorianCalendar getSentDate() {
        return sentDate;
    }

    public GregorianCalendar getWithdrawalDate() {
        return withdrawalDate;
    }

    public GregorianCalendar getDeadlinePayment() {
        return deadlinePayment;
    }

    public GregorianCalendar getReceiptDate() {
        return receiptDate;
    }

    public Integer getNumberPaymentRemeinder() {
        return numberPaymentRemeinder;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public String getDeliveryStreet() {
        return deliveryStreet;
    }

    public String getDeliveryStreetNumber() {
        return deliveryStreetNumber;
    }

    public String getSeller() {
        return sellerId;
    }

    public String getCustomer() {
        return customerId;
    }

    public String getLocality() {
        return localityId;
    }


}
