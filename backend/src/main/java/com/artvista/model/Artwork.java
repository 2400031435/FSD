package com.artvista.model;

import jakarta.persistence.*;

@Entity
@Table(name = "artworks")
public class Artwork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    private Double price;

    @Column(nullable = false)
    private String category; // Painting, Drawing, Photography, Sculpture

    private String status; // Published, Pending

    private String imageUrl;

    private String artist; // artist name

    public Artwork() {}

    public Artwork(String title, String description, Double price, String category, String status, String imageUrl, String artist) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.status = status;
        this.imageUrl = imageUrl;
        this.artist = artist;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }
}
