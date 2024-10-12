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
    @Column(name="pat_lastname")
    private String lastName ;
    @Column(name="pat_firstname")
    private String firstName;
    @Column(name="pat_blood_type")
    private String bloodType;
    @Column(name= "pat_id_mom")
    private String momId ;
    @Column(name= "pat_id_dad")
    private String dadId ;
    @Column(name="pat_birth_place")
    private String birthPlace;
    //Constructors
    //empty constructor
    public PatientDomain(){}

    public PatientDomain(PatientDTO patientDTO){
        this.birthDate = patientDTO.getBirthDate();
        this.sexCod = patientDTO.getSexCod();
        this.lastName = patientDTO.getLastName();
        this.firstName = patientDTO.getFirstName();
        this.bloodType = patientDTO.getBloodType();
        this.birthPlace = patientDTO.getBirthPlace();

    }

    public PatientDomain(ChildDTO childDTO){
        this.birthDate = childDTO.getBirthDate();
        this.sexCod = childDTO.getSexCod();
        this.lastName = childDTO.getLastName();
        this.firstName = childDTO.getFirstName();
        this.birthPlace = childDTO.getBirthPlace();
        this.momId = childDTO.getMomId();
        this.dadId = childDTO.getDadId();

    }

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
    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }




    @Override
    public String toString() {
        return "PatientDomain{" +
                "id=" + id +
                ", birthDate=" + birthDate +
                ", sexCod=" + sexCod +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", momId='" + momId + '\'' +
                ", dadId='" + dadId + '\'' +
                ", birthDate='"+birthPlace+
                '}';
    }
}
