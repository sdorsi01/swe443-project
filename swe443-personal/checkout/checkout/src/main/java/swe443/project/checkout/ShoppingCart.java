package swe443.project.checkout;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private ArrayList<Book> booksSelected;
    private ArrayList<Book> booksAvailable;
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

    public ArrayList<Book> getBooksAvailable() {
        return booksAvailable;
    }

    public Book getBookAvailable(long id){
        for (Book book: booksAvailable){
            if (book.getId() == id){
                return book;
            }
        }
        return null;
    }

    public ArrayList<Book> getBooksSelected() {
        return booksSelected;
    }

    public String DisplayCart(){
        return booksSelected.toString();
    }

    public String DisplayBooks(){
        return booksAvailable.toString();
    }

    public void addBook(Book id){
        booksSelected.add(id);//srvice.getBook(id)
    }

    public void addAvailable(Book val){
        booksAvailable.add(val);
    }

    public void addAllAvailable(List<Book> list){
        booksAvailable.addAll(list);
    }

    public double giveTotal(){
        double total = 0;
        for(Book b:booksSelected)
        {
            total+=b.getFairValue();
        }
        return total;
    }

    public void StartShopping(){
        //Show Page to interact with
    }


}
