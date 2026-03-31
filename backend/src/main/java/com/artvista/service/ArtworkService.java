package com.artvista.service;

import com.artvista.model.Artwork;
import com.artvista.repository.ArtworkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtworkService {

    private final ArtworkRepository artworkRepository;

    public ArtworkService(ArtworkRepository artworkRepository) {
        this.artworkRepository = artworkRepository;
    }

    public List<Artwork> getAllArtworks() {
        return artworkRepository.findAll();
    }

    public List<Artwork> getByCategory(String category) {
        return artworkRepository.findByCategory(category);
    }

    public List<Artwork> getByArtist(String artist) {
        return artworkRepository.findByArtist(artist);
    }

    public Artwork createArtwork(Artwork artwork) {
        return artworkRepository.save(artwork);
    }

    public Artwork updateArtwork(Long id, Artwork updated) {
        Artwork artwork = artworkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artwork not found"));
        artwork.setTitle(updated.getTitle());
        artwork.setDescription(updated.getDescription());
        artwork.setPrice(updated.getPrice());
        artwork.setCategory(updated.getCategory());
        artwork.setStatus(updated.getStatus());
        artwork.setImageUrl(updated.getImageUrl());
        artwork.setArtist(updated.getArtist());
        return artworkRepository.save(artwork);
    }

    public void deleteArtwork(Long id) {
        artworkRepository.deleteById(id);
    }
}
