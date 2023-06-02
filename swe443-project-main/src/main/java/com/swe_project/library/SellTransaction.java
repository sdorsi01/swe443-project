package com.swe_project.library;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class SellTransaction {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long   id;
    private Long   bookId;
    private Long   sellerID;   // Match member's ID
    private double fairValue;  // 0 if donated
    private double fairPoints; // 0 if it's sold to us.

    // Constructor
    public SellTransaction(Long Id, Long bookId, Long sellerID, double fairValue, double fairPoints) {
        this.id = Id;
        this.bookId = bookId;
        this.sellerID = sellerID;
        this.fairValue = fairValue;
        this.fairPoints = fairPoints;
    }

    // Getters and setters
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return this.bookId;
    }
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getSellerID() {
        return this.sellerID;
    }
    public void setSellerID(Long sellerID) {
        this.sellerID = sellerID;
    }

    public double getFairValue() {
        return this.fairValue;
    }
    public void setFairValue(double fairValue) {
        this.fairValue = fairValue;
    }

    public double getFairPoints() {
        return this.fairPoints;
    }
    public void setFairPoints(double fairPoints) {
        this.fairPoints = fairPoints;
    }

    public boolean isDonated() {
        return this.fairValue == 0;
    }
    public boolean isSoldToUs() {
        return this.fairPoints == 0;
    }

}
