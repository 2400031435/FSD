package com.artvista.controller;

import com.artvista.model.Exhibition;
import com.artvista.service.ExhibitionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/exhibitions")
public class ExhibitionController {

    private final ExhibitionService exhibitionService;

    public ExhibitionController(ExhibitionService exhibitionService) {
        this.exhibitionService = exhibitionService;
    }

    @GetMapping
    public List<Exhibition> getAllExhibitions() {
        return exhibitionService.getAllExhibitions();
    }

    @PostMapping
    public ResponseEntity<?> createExhibition(@RequestBody Exhibition exhibition) {
        Exhibition created = exhibitionService.createExhibition(exhibition);
        return ResponseEntity.ok(Map.of("success", true, "message", "Exhibition created", "exhibition", created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateExhibition(@PathVariable Long id, @RequestBody Exhibition exhibition) {
        try {
            Exhibition updated = exhibitionService.updateExhibition(id, exhibition);
            return ResponseEntity.ok(Map.of("success", true, "exhibition", updated));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("success", false, "message", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExhibition(@PathVariable Long id) {
        exhibitionService.deleteExhibition(id);
        return ResponseEntity.ok(Map.of("success", true, "message", "Exhibition deleted"));
    }
}
