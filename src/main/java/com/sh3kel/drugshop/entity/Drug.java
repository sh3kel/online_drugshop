package com.sh3kel.drugshop.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Drug {
    private int id;
    private String title;
    private String description;
    private boolean needPrescription;
    private LocalDate releaseDate;
    private LocalDate expirationDate;
    private int quantity;

    public Drug(int id, String title, String description, boolean needPrescription, LocalDate releaseDate, LocalDate expirationDate, int quantity) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.needPrescription = needPrescription;
        this.releaseDate = releaseDate;
        this.expirationDate = expirationDate;
        this.quantity = quantity;

    }

    public Drug(String title, String description, boolean needPrescription, LocalDate releaseDate, LocalDate expirationDate, int quantity) {
        this.title = title;
        this.description = description;
        this.needPrescription = needPrescription;
        this.releaseDate = releaseDate;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isNeedPrescription() {
        return needPrescription;
    }

    public void setNeedPrescription(boolean needPrescription) {
        this.needPrescription = needPrescription;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        String str = String.format("""
                ID: %s
                Title: %s
                Description: %s
                Release date: %s
                Expiration Date: %s
                Quantity: %s
                """, id, title, description, releaseDate, expirationDate, quantity);
        if(needPrescription) str += "To release Drug, buyer need a prescription!";
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drug drug = (Drug) o;
        return id == drug.id && Objects.equals(title, drug.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
