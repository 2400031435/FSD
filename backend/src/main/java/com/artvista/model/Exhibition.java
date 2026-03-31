package com.artvista.model;

import jakarta.persistence.*;

@Entity
@Table(name = "exhibitions")
public class Exhibition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    private int artworksCount;

    private String startDate;

    private String endDate;

    private String status; // Active, Upcoming, Completed

    public Exhibition() {}

    public Exhibition(String name, String description, int artworksCount, String startDate, String endDate, String status) {
        this.name = name;
        this.description = description;
        this.artworksCount = artworksCount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getArtworksCount() { return artworksCount; }
    public void setArtworksCount(int artworksCount) { this.artworksCount = artworksCount; }

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
