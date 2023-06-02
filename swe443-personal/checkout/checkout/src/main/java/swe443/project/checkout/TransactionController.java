package swe443.project.checkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class TransactionController {

    @Autowired
    HistoryService service;
    ShoppingCart cart = new ShoppingCart();
    @GetMapping("/checkout")
    public String DisplayBooks(Model model){
        //REST CALL 1, 0 if no member found and a guest
        cart = new ShoppingCart(GetMember());
        //REST CALL 2, default 5 books created if failed
        cart.addAllAvailable(GetBookDetails());
        //cart.addBook(3);
        model.addAttribute("shoppingCart",cart);//with checkout.html transaction);
        return "checkout";//result should print list of available books with buttons
    }

    @GetMapping("/checkout/transaction")
    public String displayTransaction(Model model){

        return DisplayBooks(model);
    }

    @PostMapping("/checkout")
    public String AddToCart(@RequestParam(name = "bookID") long bookID, Model model) {
        Book myBook = cart.getBookAvailable(bookID);
        if(myBook!=null)
            this.cart.addBook(myBook);
        model.addAttribute("shoppingCart", this.cart);
        return "checkout";
    }
    @PostMapping("/checkout/transaction")
    public String completeTransaction(Model model) {
        ArrayList<Long> bookIDs = new ArrayList<>();
        for(Book b: cart.getBooksSelected()){
            bookIDs.add(b.getId());
        }
        BuyTransaction transaction = new BuyTransaction(Date.from(Instant.now()).toString(), cart.giveTotal(),bookIDs, cart.getUserID());
        model.addAttribute("shoppingCart", this.cart);
        model.addAttribute("buyTransaction", transaction);
        service.saveTransaction(transaction);
        return "checkout";
    }

    //Receive calls from microservice to update model
@GetMapping("/checkout/update")
    public ResponseEntity<List<BuyTransaction>> getTransactions(Model model, @RequestParam(name = "user") String id){
        List<BuyTransaction> sendBT = service.getTransactions(Integer.parseInt(id));
       ResponseEntity<List<BuyTransaction>> myResp = new ResponseEntity<List<BuyTransaction>>(sendBT,HttpStatus.OK);
        return myResp;
    }

    private List<Book> GetBookDetails(){//REST CALL 2
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Book>> libraryResponse;
        List<Book> list = new ArrayList<>();
        try {
            libraryResponse = restTemplate.exchange("http://localhost:8080/library/books", HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>(){});
            list = libraryResponse.getBody();
        }catch(Exception e) {

            for (long i = 0; i < 5; i++) {
                list.add(new Book(i,"","Name "+i,0.0+i,0,0,0));
            }
        }
        return list;
    }

    private int GetMember(){//REST CALL 1
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Integer> memberResponse;
        try {
            memberResponse = restTemplate.getForEntity("http://localhost:8080/member/GetMember", Integer.class);
            if(memberResponse.hasBody()&&memberResponse.getBody()!=null) {
                return memberResponse.getBody();//string of current user's history
            }
        } catch (Exception e) {
            memberResponse = new ResponseEntity<>(HttpStatus.BAD_REQUEST);// "NONE";//new ArrayList<>();
        }

        return 0;
    }
/*
    @GetMapping("/myMapping")//replace with your own call name you will need to do: yourURL+"?ownerID="+ID to call service
    public String getHistory(@RequestParam(name = "ownerID") String ownerID, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity history;
        int id = Integer.parseInt(ownerID);
        try {
//replace PORT with port of my microservice
            history = restTemplate.exchange("http://localhost:8081/giveHistoryFromUser?ownerID="+id, HttpMethod.GET, null, new ParameterizedTypeReference<List<BuyTransaction>>(){});

        } catch (Exception e) {
            history = new ResponseEntity<>(HttpStatus.BAD_REQUEST);// "NONE";//new ArrayList<>();
        }
        model.addAttribute("historyList",history.getBody());
        System.out.println(history.getBody());
        return "history";//string of current user's history
    }*/
}
