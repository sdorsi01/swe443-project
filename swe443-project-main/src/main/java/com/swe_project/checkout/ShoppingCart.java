package com.swe_project.checkout;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @JdbcTypeCode(SqlTypes.JSON)
    private ArrayList<CheckoutBook> booksSelected;
    @JdbcTypeCode(SqlTypes.JSON)
    private ArrayList<CheckoutBook> booksAvailable;
    private int userID;

    protected ShoppingCart(){
        this.booksSelected = new ArrayList<>();
        this.booksAvailable = new ArrayList<>();
    }

    public ShoppingCart(int userID){
        this.booksSelected = new ArrayList<>();
        this.booksAvailable = new ArrayList<>();
        this.userID = userID;
    }

    @Override
    public String toString() {
        return booksSelected.toString();
    }
    public Long getId() {
        return id;
    }

    public int getUserID() {
        return userID;
    }

    public ArrayList<CheckoutBook> getBooksAvailable() {
        return booksAvailable;
    }

    public CheckoutBook getBookAvailable(long id){
        for (CheckoutBook book: booksAvailable){
            if (book.getId() == id){
                return book;
            }
        }
        return null;
    }

    public ArrayList<CheckoutBook> getBooksSelected() {
        return booksSelected;
    }

    public String DisplayCart(){
        return booksSelected.toString();
    }

    public String DisplayBooks(){
        return booksAvailable.toString();
    }

    public void addBook(CheckoutBook id){
        booksSelected.add(id);//srvice.getBook(id)
    }

    public void addAvailable(CheckoutBook val){
        booksAvailable.add(val);
    }

    public void addAllAvailable(List<CheckoutBook> list){
        booksAvailable.addAll(list);
    }

    public double giveTotal(){
        double total = 0;
        for(CheckoutBook b:booksSelected)
        {
            total+=b.getFairValue();
        }
        return total;
    }

    public void StartShopping(){
        //Show Page to interact with
    }


}
