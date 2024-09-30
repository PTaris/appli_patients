package fr.bordeaux.isped.sitis.exam_prog301.service;

import fr.bordeaux.isped.sitis.exam_prog301.domain.SexEnum;
import jakarta.persistence.Column;

import java.time.LocalDate;

public class PatientDTO {
    //Attributes
    private String id;
    private LocalDate birthDate;
    private SexEnum sexCod;
    private String name ;
    private String firstName;
    private String bloodType;
    //Constructor
    public PatientDTO(){}
    //Getters and Setters


    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public SexEnum getSexCod() {
        return sexCod;
    }

    public void setSexCod(SexEnum sexCod) {
        this.sexCod = sexCod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }


}
