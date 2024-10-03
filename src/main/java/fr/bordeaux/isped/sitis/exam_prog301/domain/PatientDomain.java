package fr.bordeaux.isped.sitis.exam_prog301.domain;


import fr.bordeaux.isped.sitis.exam_prog301.service.ChildDTO;
import fr.bordeaux.isped.sitis.exam_prog301.service.PatientDTO;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name= "tab_patient_301", schema = "projet_prog301")

public class PatientDomain {
    //Attributes
    @Id
    @GeneratedValue(strategy =GenerationType.SEQUENCE, generator = "sequence-generator")
    @SequenceGenerator(name="sequence-generator", sequenceName = "projet_prog301.seq_patient_301",schema="projet_prog301",initialValue = 1, allocationSize = 1)

    @Column(name="pat_id")
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
    @Column(name="pat_mom")
    private String mom;
    @Column(name="pat_dad")
    private String dad;
    //Constructors
    //empty constructor
    public PatientDomain(){}

    public PatientDomain(PatientDTO patientDTO){
        this.birthDate = patientDTO.getBirthDate();
        this.sexCod = patientDTO.getSexCod();
        this.name = patientDTO.getName();
        this.firstName = patientDTO.getFirstName();
        this.bloodType = patientDTO.getBloodType();
        this.mom = patientDTO.getMom();
        this.dad = patientDTO.getDad();
    }

    public PatientDomain(ChildDTO childDTO){
        this.birthDate=childDTO.getBirthDate();
        this.sexCod = childDTO.getSexCod();
        this.name = childDTO.getName();
        this.firstName = childDTO.getFirstName();
        this.bloodType= childDTO.getBloodType();
        this.mom = childDTO.getMom();
        this.dad = childDTO.getDad();


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

    public String getMom() {
        return mom;
    }

    public void setMom(String mom) {
        this.mom = mom;
    }

    public String getDad() {
        return dad;
    }

    public void setDad(String dad) {
        this.dad = dad;
    }

    @Override
    public String toString() {
        return "PatientDomain{" +
                "id=" + id +
                ", birthDate=" + birthDate +
                ", sexCod=" + sexCod +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", mom='" + mom + '\'' +
                ", dad='" + dad + '\'' +
                '}';
    }
}
