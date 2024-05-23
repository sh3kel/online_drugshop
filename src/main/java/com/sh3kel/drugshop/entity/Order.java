package com.sh3kel.drugshop.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Order {
    private int id;
    private int user_id;
    private LocalDateTime date;
    private String address;
    private BigDecimal cost;
    private String paymentType;
    private boolean paid;
    private String status;

    public Order(int id, int user_id, LocalDateTime date, String address, BigDecimal cost, String paymentType, boolean paid, String status) {
        this.id = id;
        this.user_id = user_id;
        this.date = date;
        this.address = address;
        this.cost = cost;
        this.paymentType = paymentType;
        this.paid = paid;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Objects.equals(cost, order.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cost);
    }

    @Override
    public String toString() {
        return String.format("""
                Order №%s. User: №%s""");
    }
}
