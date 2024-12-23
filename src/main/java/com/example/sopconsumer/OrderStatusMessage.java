package com.example.sopconsumer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderStatusMessage {

    private String customerEmail;
    private String orderStatus;


    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getOrderStatus() {
        return orderStatus;
    }


    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "OrderStatusMessage{" +
                "customerEmail='" + customerEmail + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }

}