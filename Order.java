package customer;

import java.sql.Date;

public class Order {
    private int orderId;
    private int customerId;
    private String product;
    private double amount;
    private Date orderDate;

    public Order(int orderId, int customerId, String product, double amount, Date orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.product = product;
        this.amount = amount;
        this.orderDate = orderDate;
    }

    // Getters
    public int getOrderId() { return orderId; }
    public int getCustomerId() { return customerId; }
    public String getProduct() { return product; }
    public double getAmount() { return amount; }
    public Date getOrderDate() { return orderDate; }
}
