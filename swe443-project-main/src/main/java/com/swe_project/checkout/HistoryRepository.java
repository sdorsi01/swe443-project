package com.swe_project.checkout;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface HistoryRepository extends
        CrudRepository<BuyTransaction, Long> {
    List<BuyTransaction> findByOwnerID(int ownerID);
    Optional<BuyTransaction> findById(Long id);
}
