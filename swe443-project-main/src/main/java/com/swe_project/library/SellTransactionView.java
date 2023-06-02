package com.swe_project.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class SellTransactionView {
    @Autowired
    private Library library;

    // Get the member's sell transaction, and fill the book detail with boodId. 
    @GetMapping("/library/sellhistory/{id}")
    public String getSellHistory(@PathVariable Long id, Model model) {
        // get all sell transactions for a member
        // member id currently from passed in value
        // get all sell transactions for a member, then fill the book detail by the book id in transaction
        Optional<SellTransaction> sellT = library.getSellHistory(id);
        sellT.ifPresent(obj_sellt -> model.addAttribute("sellhistory", obj_sellt));
        return "library-get-sellhistory";
    }

    // Add a new sell transaction to the sell history
    @PostMapping("/library/sellhistory")
    protected String addTranscation(@PathVariable SellTransaction sellT, Model model) {
        // add a new transaction to the sell history
        library.addSellTransaction(sellT);
        return "library-add-sellhistory-done";
    }

    // Get all sell transactions for a member
    @GetMapping("/library/sellhistory")
    protected String getTranscation(Model model) {
        // get all sell transactions for a member
        long memberID = 1;
        Optional<SellTransaction> sellT = library.getSellHistory(memberID);
        sellT.ifPresent(obj_sellt -> model.addAttribute("sellhistory", obj_sellt));
        return "library-list-sellhistory";
    }
}
