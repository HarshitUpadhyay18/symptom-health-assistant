package com.healthcare.symptom_detection.controller;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.symptom_detection.model.DiseaseMatchDTO;
import com.healthcare.symptom_detection.model.Symptom;
import com.healthcare.symptom_detection.service.DiseaseService;
import com.healthcare.symptom_detection.service.SymptomService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class DiseaseController {

    private final SymptomService symptomService;
    private final DiseaseService diseaseService;

    public DiseaseController(SymptomService symptomService, DiseaseService diseaseService) {
        this.symptomService = symptomService;
        this.diseaseService = diseaseService;
    }

    @GetMapping("/symptoms")
    public List<Symptom> getAllSymptoms() {
        return symptomService.getAllSymptoms();
    }

    @PostMapping("/detect")
    public DiseaseMatchDTO detectDisease(@RequestBody Set<String> selectedSymptoms) {
        return diseaseService.findDiseaseBySymptoms(selectedSymptoms);
    }
}
