package fr.bordeaux.isped.sitis.exam_prog301.service;

import fr.bordeaux.isped.sitis.exam_prog301.domain.SexEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ChildDTO {
    //Attributes
    private LocalDate birthDate;
    private SexEnum sexCod;
    private String name;
    private String firstName;
    private String idMom;
    private String idDad;

    //Constructors
    public ChildDTO() {
    }

    //Getters and setters

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

    public String getIdMom() {
        return idMom;
    }

    public void setIdMom(String idMom) {
        this.idMom = idMom;
    }

    public String getIdDad() {
        return idDad;
    }

    public void setIdDad(String idDad) {
        this.idDad = idDad;
    }

    @Override
    public String toString() {
        return "ChildDTO{" +
                "birthDate=" + birthDate +
                ", sexCod=" + sexCod +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", idMom='" + idMom + '\'' +
                ", idDad='" + idDad + '\'' +
                '}';
    }
}