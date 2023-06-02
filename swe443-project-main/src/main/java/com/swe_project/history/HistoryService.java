package com.swe_project.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swe_project.checkout.BuyTransaction;
import com.swe_project.checkout.HistoryRepository;

import java.util.List;

@Service("historyService")
public class HistoryService {
    @Autowired
    HistoryRepository hRepo;

    public void saveTransaction (BuyTransaction transaction)
    {

        hRepo.save(transaction);

    }

    public List<BuyTransaction> getTransactions(int id){
        return hRepo.findByOwnerID(id);
    }
}
