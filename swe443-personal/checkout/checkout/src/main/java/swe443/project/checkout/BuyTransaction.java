package swe443.project.checkout;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class BuyTransaction {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    //private String content;
    private String date;
    private double totalAmount; //no longer needed?

    private ArrayList<Long> booksBought;
    private int ownerID;

    protected BuyTransaction(){}

    public BuyTransaction(String date, double totalAmount, ArrayList<Long> booksBought, int ownerID){
        this.date = date;
        this.totalAmount = totalAmount;
        this.booksBought = booksBought;
        this.ownerID = ownerID;
    }

    @Override
    public String toString(){
        return "Owner: "+ownerID+"\nDate: "+date+"\nAmount: "+totalAmount+"\nBooks Bought by ID: "+booksBought.toString();
    }

    public BuyTransaction addBook(int id){
        //getBookFrom id + add to bought books
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public ArrayList<Long> getBooksBought() {
        return booksBought;
    }

    public int getOwnerID() {
        return ownerID;
    }
}
