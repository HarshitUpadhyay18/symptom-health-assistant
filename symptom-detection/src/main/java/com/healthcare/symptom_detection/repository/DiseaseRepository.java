package com.healthcare.symptom_detection.repository;

import com.healthcare.symptom_detection.model.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Set;

public interface DiseaseRepository extends JpaRepository<Disease, Integer> {

    // Make sure this method name is spelled correctly with a 'p'
    @Query("SELECT d FROM Disease d JOIN d.symptoms s WHERE s.name IN :symptomNames")
    List<Disease> findDiseasesBySymptomNames(@Param("symptomNames") Set<String> symptomNames);
    
}