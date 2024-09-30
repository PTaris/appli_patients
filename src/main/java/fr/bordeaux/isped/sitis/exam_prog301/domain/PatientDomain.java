package fr.bordeaux.isped.sitis.exam_prog301.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name="tab_patient_301", schema = "projet_prog301")
public class PatientDomain {
    //Attributes
    @Id
    @Column(name="pat_id")
    private String id;
    @Column(name="pat_birth_date")
    private LocalDate birthDate;
    @Column(name="pat_sex_cod")
    private SexEnum sexCod;
    @Column(name="pat_name")
    private String name ;
    @Column(name="pat_firstname")
    private String firstName;
    @Column(name="pat_blood_type")
    private String bloodType;
    //Constructors
    //empty constructor
    public PatientDomain() {
    }

    public PatientDomain(String id, LocalDate birthDate, SexEnum sexCod, String name, String firstName, String bloodType) {
        this.id = id;
        this.birthDate = birthDate;
        this.sexCod = sexCod;
        this.name = name;
        this.firstName = firstName;
        this.bloodType = bloodType;
    }

    //Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    //ToString


    @Override
    public String toString() {
        return "PatientDomain{" +
                "id='" + id + '\'' +
                ", birthDate=" + birthDate +
                ", sexCod=" + sexCod +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", bloodType='" + bloodType + '\'' +
                '}';
    }
}
