package com.artvista.repository;

import com.artvista.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    List<Purchase> findByBuyer(String buyer);
    List<Purchase> findByArtist(String artist);
}
