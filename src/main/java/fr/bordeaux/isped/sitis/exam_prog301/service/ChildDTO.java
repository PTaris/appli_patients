package fr.bordeaux.isped.sitis.exam_prog301.service;

import fr.bordeaux.isped.sitis.exam_prog301.domain.SexEnum;

import java.time.LocalDate;

public class ChildDTO {
    private LocalDate birthDate;
    private SexEnum sexCod;
    private String lastName;
    private String firstName;
    private String birthPlace;
    private String momId;
    private String dadId;

    //Constructor
    public ChildDTO() {
    }

    public String getBirthPlace(){
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace){
        this.birthPlace=birthPlace;
    }

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

    public String getMomId() {
        return momId;
    }

    public void setMomId(String momId) {
        this.momId = momId;
    }

    public String getDadId() {
        return dadId;
    }

    public void setDadId(String dadId) {
        this.dadId = dadId;
    }

    @Override
    public String toString() {
        return "ChildDTO{" +
                "birthDate=" + birthDate +
                ", sexCod=" + sexCod +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", momId='" + momId + '\'' +
                ", dadId='" + dadId + '\'' +
                ", birthPlace='" + birthPlace +
                '}';
    }
}