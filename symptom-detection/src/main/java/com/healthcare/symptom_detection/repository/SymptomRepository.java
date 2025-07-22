package com.healthcare.symptom_detection.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthcare.symptom_detection.model.Symptom;

public interface SymptomRepository extends JpaRepository<Symptom, Integer>{
	Optional<Symptom> findByName(String name);
	
	@Query(value = "SELECT s.* FROM symptom s " +
	            "JOIN disease_symptom ds ON s.id = ds.symptom_id " +
	            "GROUP BY s.id " +
	            "ORDER BY COUNT(ds.disease_id) DESC LIMIT 15", nativeQuery = true)
	List<Symptom> findCommonSymptoms();
}
