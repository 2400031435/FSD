package com.artvista.controller;

import com.artvista.model.Artwork;
import com.artvista.service.ArtworkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/artworks")
public class ArtworkController {

    private final ArtworkService artworkService;

    public ArtworkController(ArtworkService artworkService) {
        this.artworkService = artworkService;
    }

    @GetMapping
    public List<Artwork> getAllArtworks(@RequestParam(required = false) String category,
            @RequestParam(required = false) String artist) {
        if (category != null && !category.isEmpty()) {
            return artworkService.getByCategory(category);
        }
        if (artist != null && !artist.isEmpty()) {
            return artworkService.getByArtist(artist);
        }
        return artworkService.getAllArtworks();
    }

    @PostMapping
    public ResponseEntity<?> createArtwork(@RequestBody Artwork artwork) {
        Artwork created = artworkService.createArtwork(artwork);
        return ResponseEntity.ok(Map.of("success", true, "message", "Artwork created", "artwork", created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateArtwork(@PathVariable Long id, @RequestBody Artwork artwork) {
        try {
            Artwork updated = artworkService.updateArtwork(id, artwork);
            return ResponseEntity.ok(Map.of("success", true, "artwork", updated));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("success", false, "message", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArtwork(@PathVariable Long id) {
        artworkService.deleteArtwork(id);
        return ResponseEntity.ok(Map.of("success", true, "message", "Artwork deleted"));
    }
}
