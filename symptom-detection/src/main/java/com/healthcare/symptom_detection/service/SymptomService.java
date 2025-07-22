package com.healthcare.symptom_detection.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.healthcare.symptom_detection.model.Disease;
import com.healthcare.symptom_detection.model.Symptom;
import com.healthcare.symptom_detection.repository.DiseaseRepository;
import com.healthcare.symptom_detection.repository.SymptomRepository;

@Service
public class SymptomService {
	
	private final SymptomRepository symptomRepository;
	private final DiseaseRepository diseaseRepository;

	public SymptomService(SymptomRepository symptomRepository, DiseaseRepository diseaseRepository) {
        this.symptomRepository = symptomRepository;
        this.diseaseRepository = diseaseRepository;
    }

    public List<Symptom> getAllSymptoms() {
        return symptomRepository.findAll();
    }
    
    // NEW METHOD for common symptoms
    public List<Symptom> getCommonSymptoms() {
        return symptomRepository.findCommonSymptoms();
    }

    // NEW METHOD for related symptoms
    public Set<Symptom> getRelatedSymptoms(Set<String> selectedSymptoms) {
        if (selectedSymptoms == null || selectedSymptoms.isEmpty()) {
            return new HashSet<>();
        }

        List<Disease> relatedDiseases = diseaseRepository.findDiseasesBySymptomNames(selectedSymptoms);

        // Collect all symptoms from the related diseases
        Set<Symptom> relatedSymptoms = relatedDiseases.stream()
                .flatMap(disease -> disease.getSymptoms().stream())
                .collect(Collectors.toSet());

        // Remove the symptoms the user has already selected
        relatedSymptoms.removeIf(symptom -> selectedSymptoms.contains(symptom.getName()));

        return relatedSymptoms;
    }
}
