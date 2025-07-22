package com.healthcare.symptom_detection.model;

public class DiseaseMatchDTO {
    private String diseaseName;
    private String precaution;
    private String doctorType;
    private double matchPercentage;

    public DiseaseMatchDTO(String diseaseName, String precaution, String doctorType, double matchPercentage) {
        this.diseaseName = diseaseName;
        this.precaution = precaution;
        this.doctorType = doctorType;
        this.matchPercentage = matchPercentage;
    }

    // Getters and Setters
    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getPrecaution() {
        return precaution;
    }

    public void setPrecaution(String precaution) {
        this.precaution = precaution;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public double getMatchPercentage() {
        return matchPercentage;
    }

    public void setMatchPercentage(double matchPercentage) {
        this.matchPercentage = matchPercentage;
    }
}
