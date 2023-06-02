package com.swe_project.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class BookView {

    @Autowired
    private Library library;

    @GetMapping("/library/books")
    public String browseBooks(Model model) {
        model.addAttribute("books", library.getBookList());
        return "library-browse-books";
    }

    @GetMapping("/library/books/{id}")
    public String bookDetails(@PathVariable Long id, Model model) {
        Optional<Book> book = library.getBookDetail(id);
        book.ifPresent(value -> model.addAttribute("book", value));
        return "library-book-details";
    }

    // Sell new book to library
    @PostMapping("/library/sellbook")
    public String sellBook(@ModelAttribute Book book, Model model) {
        // Get sell type, sell or donate
        
        // Get Book Value
        Services micro_Services = new Services();
        double value = micro_Services.requestValue(book.getIsbn(), book.getCondition());
        // Add book to library
        library.addBook(book);
        // build a trnasaction history with auto ID
        SellTransaction sellT = new SellTransaction(null, null, null, value, value);
        library.addSellTransaction(sellT);
        model.addAttribute("books", library.getBookList());
        return "";
    }

    // AddBook view get function
    @GetMapping("/library/addbook")
    public String addBook(Model model) {
        return "library-add-books";
    }

    // AddBook View to allow administator to add book to library
    @PostMapping("/library/addbook")
    public String addBook(  @RequestParam("title") String title,
                            @RequestParam("isbn") String isbn,
                            @RequestParam("fairValue") double fairValue,
                            @RequestParam("fairPoints") double fairPoints,
                            @RequestParam("conditions") int conditions,
                            @RequestParam("ownerID") int ownerID) {
        // Add book to library
        Book book = new Book();
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setFairValue(fairValue);
        book.setFairPoints(fairPoints);
        book.setConditions(conditions);
        book.setOwner(ownerID);

        library.addBook(book);
        return "redirect:/library/books";
    }
}
