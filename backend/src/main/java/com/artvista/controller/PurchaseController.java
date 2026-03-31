package com.artvista.controller;

import com.artvista.model.Purchase;
import com.artvista.service.PurchaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public List<Purchase> getAllPurchases(@RequestParam(required = false) String buyer,
            @RequestParam(required = false) String artist) {
        if (buyer != null && !buyer.isEmpty()) {
            return purchaseService.getPurchasesByBuyer(buyer);
        }
        if (artist != null && !artist.isEmpty()) {
            return purchaseService.getSalesByArtist(artist);
        }
        return purchaseService.getAllPurchases();
    }

    @PostMapping
    public ResponseEntity<?> createPurchase(@RequestBody Purchase purchase) {
        Purchase created = purchaseService.createPurchase(purchase);
        return ResponseEntity.ok(Map.of("success", true, "message", "Purchase recorded", "purchase", created));
    }
}
