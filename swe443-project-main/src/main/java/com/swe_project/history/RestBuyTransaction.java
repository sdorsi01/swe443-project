package com.swe_project.history;

import java.util.ArrayList;

public class RestBuyTransaction {
    private String date;
    private double totalAmount; //no longer needed?
    private ArrayList<Long> booksBought;
    private int ownerID;

    public RestBuyTransaction(){//String date, double totalAmount, ArrayList booksBought, int ownerID){

    }

  @Override
  public String toString(){
      return "Owner: "+ownerID+"\nDate: "+date+"\nAmount: "+totalAmount+"\nBooks Bought: "+booksBought.toString();
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
