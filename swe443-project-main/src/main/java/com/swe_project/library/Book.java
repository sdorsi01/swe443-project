package com.swe_project.library;

// import com.swe_project.member.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long   id;
    private String title;
    private String isbn;
    private double fairValue;
    private double fairPoints;
    private int    conditions; /* From 0 ~ 100 */

    //@ManyToOne
    //@JoinColumn(name = "author_id", referencedColumnName = "id")
    private int ownerID;

    // Constructor
    public Book(Long Id, String isbn, String title, double fairValue, int fairPoints, int conditions, int owner) {
        this.id = Id;
        this.isbn = isbn;
        this.title = title;
        this.fairValue = fairValue;
        this.fairPoints = fairPoints;
        this.conditions = conditions;
        this.ownerID = owner;
    }

    public Book() {
        
    }

    // Getters and setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getCondition() {
        return this.conditions;
    }

    public void setConditions(int conditions) {
        this.conditions = conditions;
    }

    public int getOwner() {
        return this.ownerID;
    }

    public void setOwner(int owner) {
        this.ownerID = owner;
    }
}


