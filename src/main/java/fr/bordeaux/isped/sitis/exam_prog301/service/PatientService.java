package fr.bordeaux.isped.sitis.exam_prog301.service;

import fr.bordeaux.isped.sitis.exam_prog301.domain.PatientDomain;
import fr.bordeaux.isped.sitis.exam_prog301.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    public List<PatientDomain> getPatient(){
        return patientRepository.findAll();
    }
    public ResponseEntity<PatientDomain> createPatient(PatientDTO patientDTO){
        // Create an instance of PatientDomain based on an instance of PatientDTO
        PatientDomain patient = new PatientDomain(patientDTO);

        // Save the instance of PatientDomain within the DB
        // The save() method return an instance of PatientDomain, including the id attribute generated DB-side
        patient = patientRepository.save(patient);

        // Return the saved instance within a ResponseEntity
        return new ResponseEntity<PatientDomain>(patient, HttpStatus.OK);
    }







}
