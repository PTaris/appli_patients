package fr.bordeaux.isped.sitis.exam_prog301.domain;


import fr.bordeaux.isped.sitis.exam_prog301.service.PatientDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Entity
@Table(name="tab_patient_301", schema = "projet_prog301")
public class PatientDomain {
    //Attributes
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name="sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {@org.hibernate.annotations.Parameter(name = "sequence_name", value = "user_sequence"),
            @org.hibernate.annotations.Parameter(name= "initial_value", value= "4"),
    @org.hibernate.annotations.Parameter(name="increment_size", value="1")}

    )


    private long id;
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
    public PatientDomain(){}

    public PatientDomain(PatientDTO patientDTO){
        this.birthDate = patientDTO.getBirthDate();
        this.sexCod = patientDTO.getSexCod();
        this.name = patientDTO.getName();
        this.firstName = patientDTO.getFirstName();
        this.bloodType = patientDTO.getBloodType();
    }

    //Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
