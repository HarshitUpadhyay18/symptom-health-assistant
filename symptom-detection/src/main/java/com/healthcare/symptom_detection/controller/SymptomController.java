package com.healthcare.symptom_detection.controller;

import com.healthcare.symptom_detection.model.Symptom;
import com.healthcare.symptom_detection.service.SymptomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/symptoms") // This makes all endpoints start with /api/symptoms
@CrossOrigin(origins = "*")    // This allows requests from your frontend
public class SymptomController {

    private final SymptomService symptomService;

    public SymptomController(SymptomService symptomService) {
        this.symptomService = symptomService;
    }

    /**
     * Handles GET requests to /api/symptoms/common
     * This is the new endpoint your frontend is trying to call.
     */
    @GetMapping("/common")
    public List<Symptom> getCommonSymptoms() {
        return symptomService.getCommonSymptoms();
    }

    /**
     * Handles POST requests to /api/symptoms/related
     */
    @PostMapping("/related")
    public Set<Symptom> getRelatedSymptoms(@RequestBody Set<String> selectedSymptoms) {
        return symptomService.getRelatedSymptoms(selectedSymptoms);
    }
}