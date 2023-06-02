package com.swe_project.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

// Inventory controller
public class Library {
    @Autowired
    private BookRepository bookRepository;
    private List<SellTransaction> sellHistory;

    public Library() {
        this.sellHistory = new ArrayList<>();
    }

    // Inventory controller
    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookDetail(Long id) {
        return bookRepository.findById(id);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    // getSellHisotry from member
    public Optional<SellTransaction> getSellHistory(Long id) {
        return sellHistory.stream().filter(sellT -> sellT.getSellerID().equals(id)).findFirst();
    }

    public void addSellTransaction(SellTransaction sellT) {
        sellHistory.add(sellT);
    }

}