package fr.bordeaux.isped.sitis.exam_prog301.service;

import fr.bordeaux.isped.sitis.exam_prog301.domain.PatientDomain;
import fr.bordeaux.isped.sitis.exam_prog301.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<PatientDomain> findById(String patientId){

        // Get PatientDomain instance by patientId. findById() method return patient has Optional<PatientDomain>
        Optional<PatientDomain> patient = patientRepository.findById(patientId);

        // Test if the patient (Optional<PatientDomain>) is empty
        if(patient.isEmpty()){
            // If empty, throw ResponseStatusException with HttpStatus.NOT_FOUND
            throwPatientNotFound(patientId);
        }

        // Return patient as PatientDomain encapsulate within a ResponseEntity with HttpStatus.OK
        return new ResponseEntity<PatientDomain>(patient.get(), HttpStatus.OK);

    }

    /**
     * Throw exception when the patient ID was not found within the DB.
     *
     * @param  patientId  the ID of the patient that was not found in the DB
     * @throws ResponseStatusException
     */
    private void throwPatientNotFound(String patientId){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity " + patientId + " not found in the DataBase");
    }

}






