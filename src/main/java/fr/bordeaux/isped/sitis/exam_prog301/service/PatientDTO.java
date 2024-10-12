package fr.bordeaux.isped.sitis.exam_prog301.service;

import fr.bordeaux.isped.sitis.exam_prog301.domain.SexEnum;
import jakarta.persistence.Column;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientDTO {
    //Attributes

    private LocalDate birthDate;
    private SexEnum sexCod;
    private String lastName;
    private String firstName;
    private String bloodType;
    private String birthPlace;



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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getBirthPlace(){return birthPlace;}

    public void setBirthPlace(String birthPlace){this.birthDate=birthDate;}
}
