package com.artvista.service;

import com.artvista.model.Purchase;
import com.artvista.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    public List<Purchase> getPurchasesByBuyer(String buyer) {
        return purchaseRepository.findByBuyer(buyer);
    }

    public List<Purchase> getSalesByArtist(String artist) {
        return purchaseRepository.findByArtist(artist);
    }

    public Purchase createPurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }
}
