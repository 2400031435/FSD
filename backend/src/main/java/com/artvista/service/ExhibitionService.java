package com.artvista.service;

import com.artvista.model.Exhibition;
import com.artvista.repository.ExhibitionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExhibitionService {

    private final ExhibitionRepository exhibitionRepository;

    public ExhibitionService(ExhibitionRepository exhibitionRepository) {
        this.exhibitionRepository = exhibitionRepository;
    }

    public List<Exhibition> getAllExhibitions() {
        return exhibitionRepository.findAll();
    }

    public Exhibition createExhibition(Exhibition exhibition) {
        return exhibitionRepository.save(exhibition);
    }

    public Exhibition updateExhibition(Long id, Exhibition updated) {
        Exhibition exhibition = exhibitionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exhibition not found"));
        exhibition.setName(updated.getName());
        exhibition.setDescription(updated.getDescription());
        exhibition.setArtworksCount(updated.getArtworksCount());
        exhibition.setStartDate(updated.getStartDate());
        exhibition.setEndDate(updated.getEndDate());
        exhibition.setStatus(updated.getStatus());
        return exhibitionRepository.save(exhibition);
    }

    public void deleteExhibition(Long id) {
        exhibitionRepository.deleteById(id);
    }
}
