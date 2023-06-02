package swe443.project.checkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
