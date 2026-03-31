package com.artvista.model;

import jakarta.persistence.*;

@Entity
@Table(name = "purchases")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String artwork;

    private String artist;

    private String buyer;

    private Double amount;

    private String purchaseDate;

    private String status; // Processing, Shipped, Delivered, Completed, Pending

    public Purchase() {}

    public Purchase(String artwork, String artist, String buyer, Double amount, String purchaseDate, String status) {
        this.artwork = artwork;
        this.artist = artist;
        this.buyer = buyer;
        this.amount = amount;
        this.purchaseDate = purchaseDate;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getArtwork() { return artwork; }
    public void setArtwork(String artwork) { this.artwork = artwork; }

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }

    public String getBuyer() { return buyer; }
    public void setBuyer(String buyer) { this.buyer = buyer; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(String purchaseDate) { this.purchaseDate = purchaseDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
