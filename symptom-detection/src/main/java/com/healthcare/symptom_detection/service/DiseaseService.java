package com.healthcare.symptom_detection.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.healthcare.symptom_detection.model.Disease;
import com.healthcare.symptom_detection.model.DiseaseMatchDTO;
import com.healthcare.symptom_detection.repository.DiseaseRepository;

@Service
public class DiseaseService {

    private final DiseaseRepository diseaseRepository;

    public DiseaseService(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    public DiseaseMatchDTO findDiseaseBySymptoms(Set<String> symptomNames) {
        // 1. Normalize the input from the frontend for reliable matching
        Set<String> inputSymptoms = symptomNames.stream()
                .map(s -> s.trim().toLowerCase()) // Trim whitespace and convert to lowercase
                .collect(Collectors.toSet());

        // This is still using findAll for simplicity as per the last code,
        // but remember the optimization suggestion to create a custom query in the repository.
        List<Disease> allDiseases = diseaseRepository.findAll();
        Disease bestMatch = null;
        double bestMatchPercentage = 0.0;

        for (Disease disease : allDiseases) {
            // Ensure the symptom set is not null or empty
            if (disease.getSymptoms() == null || disease.getSymptoms().isEmpty()) {
                continue;
            }

            // 2. Normalize the symptoms from the database before comparison
            Set<String> diseaseSymptoms = disease.getSymptoms().stream()
                    .map(s -> s.getName().trim().toLowerCase())
                    .collect(Collectors.toSet());

            // 3. Find how many symptoms match
            long matchedCount = diseaseSymptoms.stream()
                    .filter(inputSymptoms::contains)
                    .count();

            // 4. Calculate the match percentage
            if (matchedCount > 0) {
                // IMPORTANT: Match percentage should be based on the number of symptoms in the disease
                double matchPercentage = (double) matchedCount / diseaseSymptoms.size() * 100;

                if (matchPercentage > bestMatchPercentage) {
                    bestMatchPercentage = matchPercentage;
                    bestMatch = disease;
                }
            }
        }

        // 5. Return a structured response even if no match is found
        if (bestMatch == null) {
            return new DiseaseMatchDTO("No matching disease found.", "N/A", "N/A", 0);
        }

        return new DiseaseMatchDTO(
            bestMatch.getName(),
            bestMatch.getPrecaution(),
            bestMatch.getDoctorType(),
            Math.round(bestMatchPercentage * 100.0) / 100.0 // Round to 2 decimal places
        );
    }
}