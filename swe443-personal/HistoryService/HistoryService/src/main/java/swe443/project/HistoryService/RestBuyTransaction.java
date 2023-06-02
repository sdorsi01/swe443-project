package swe443.project.HistoryService;

import java.util.ArrayList;

public class RestBuyTransaction {
    //private Long id;
    //private String content;
    private String date;
    private double totalAmount; //no longer needed?
    private ArrayList<Integer> booksBought;
    private int ownerID;

    public RestBuyTransaction(){//String date, double totalAmount, ArrayList booksBought, int ownerID){
        /*this.date = date;
        this.totalAmount = totalAmount;
        this.booksBought = booksBought;
        this.ownerID = ownerID;*/
    }

  /*  public long getId() {
        return id;
    }*/
  @Override
  public String toString(){
      return "Owner: "+ownerID+"\nDate: "+date+"\nAmount: "+totalAmount+"\nBooks Bought: "+booksBought.toString();
  }

  /*public RestBuyTransaction(String str){
      int index = str.indexOf(": ");
      int space = str.indexOf(" ");
      int owner = Integer.parseInt(str.substring(index+2,space));
      str = str.substring(space+1);

      index = str.indexOf(": ");
      space = str.indexOf(" ");
      String date = (str.substring(index+2,space));
      str = str.substring(space+1);

      index = str.indexOf(": ");
      space = str.indexOf(" ");
      double amount = Double.parseDouble(str.substring(index+2,space));
      str = str.substring(space+1);

      index = str.indexOf(": ");
      space = str.indexOf(" ");
      String arr =(str.substring(index+2,space));
      str = str.substring(space+1);

      this.date = date;
      this.totalAmount = amount;
      this.booksBought = new ArrayList<>();
      this.ownerID = owner;
  }*/

    public String getDate() {
        return date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public ArrayList<Integer> getBooksBought() {
        return booksBought;
    }

    public int getOwnerID() {
        return ownerID;
    }
}
