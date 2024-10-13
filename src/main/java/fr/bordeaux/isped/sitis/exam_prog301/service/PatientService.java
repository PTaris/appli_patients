package fr.bordeaux.isped.sitis.exam_prog301.service;

import fr.bordeaux.isped.sitis.exam_prog301.domain.PatientDomain;
import fr.bordeaux.isped.sitis.exam_prog301.domain.RandomBloodTypeEnum;
import fr.bordeaux.isped.sitis.exam_prog301.domain.SexEnum;
import fr.bordeaux.isped.sitis.exam_prog301.repository.PatientCountSex;
import fr.bordeaux.isped.sitis.exam_prog301.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Random;
@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<PatientDomain> findAllPatients(Pageable pageable) {
        return patientRepository.findAll(pageable).toList();
    }

    public ResponseEntity<PatientDomain> createPatient(PatientDTO patientDTO) {
        // Create an instance of PatientDomain based on an instance of PatientDTO
        PatientDomain patient = new PatientDomain(patientDTO);

        // Save the instance of PatientDomain within the DB
        // The save() method return an instance of PatientDomain, including the id attribute generated DB-side
        patient = patientRepository.save(patient);

        // Return the saved instance within a ResponseEntity
        return new ResponseEntity<PatientDomain>(patient, HttpStatus.OK);
    }

    public ResponseEntity<PatientDomain> findById(String patientId) {

        // Get PatientDomain instance by patientId. findById() method return patient has Optional<PatientDomain>
        Optional<PatientDomain> patient = patientRepository.findById(patientId);

        // Test if the patient (Optional<PatientDomain>) is empty
        if (patient.isEmpty()) {
            // If empty, throw ResponseStatusException with HttpStatus.NOT_FOUND
            throwPatientNotFound(patientId);
        }

        // Return patient as PatientDomain encapsulate within a ResponseEntity with HttpStatus.OK
        return new ResponseEntity<PatientDomain>(patient.get(), HttpStatus.OK);

    }

    /**
     * Throw exception when the patient ID was not found within the DB.
     *
     * @param patientId the ID of the patient that was not found in the DB
     * @throws ResponseStatusException
     */
    private void throwPatientNotFound(String patientId) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity " + patientId + " not found in the DataBase");
    }

    public List<PatientCountSex> countSexes() {
        List<PatientCountSex> patientCountSex = patientRepository.countPatientBySex();
        return patientCountSex;
    }
// check if the child have parents who are patients
    public ResponseEntity<PatientDomain> systemABO(ChildDTO child){

        String id1= child.getMomId();
        String id2= child.getDadId();

        Optional<PatientDomain> dadOptional = patientRepository.findById(id1);
        Optional<PatientDomain> momOptional = patientRepository.findById(id2);
        //if parents' id is not given properly
        if (dadOptional.isEmpty() && momOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }else{

        PatientDomain dad = dadOptional.get();
        PatientDomain mom = momOptional.get();

        // get parents' bloodtype
        String dadBloodType = dad.getBloodType();
        String momBloodType = mom.getBloodType();

        //get parents' sex to check
        SexEnum maledad = dad.getSexCod();
        SexEnum femalemom = mom.getSexCod();

        // create a new Patient if it is biologically possible
        if(maledad.equals(SexEnum.FEMALE) || femalemom.equals(SexEnum.MALE)){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
        }else {


            PatientDomain childPatient = new PatientDomain(child);

            if (dadBloodType.equals(momBloodType)) {
                childPatient.setBloodType(momBloodType);

            } else if ((dadBloodType.equals("A") || dadBloodType.equals("O")) && (momBloodType.equals("A") || momBloodType.equals("O"))) {
                childPatient.setBloodType("A");
            } else if ((dadBloodType.equals("B") || dadBloodType.equals("O")) && ((momBloodType.equals("B") || momBloodType.equals("O")))) {
                childPatient.setBloodType("B");
            } else if ((dadBloodType.equals("AB") || dadBloodType.equals("O")) && ((momBloodType.equals("AB") || momBloodType.equals("O")))) {
                // Generate randomly a coherent bloodtype because of several possibilities for instance (AB + 0 ==> A or B type )
                //Instance of the java class Random
                Random random = new Random();

                // Random between 0 and 1 to have B or A with the enum class RandomBloodTypeEnum
                int randomInt = random.nextInt(2);
                String bloodType = RandomBloodTypeEnum.randomBloodTypeEnum(randomInt);
                childPatient.setBloodType(bloodType);
            } else if ((dadBloodType.equals("AB") || dadBloodType.equals("A")) && ((momBloodType.equals("AB") || momBloodType.equals("A")))) {
                // several possibilities for instance (AB + A ==> AB or A type ).
                //Instance of the class java Random
                Random random = new Random();
                // 1 or 2 to have A or AB with the enum class RandomBloodTypeEnum
                int randomInt = random.nextInt(1, 3);
                String bloodType = RandomBloodTypeEnum.randomBloodTypeEnum(randomInt);
                childPatient.setBloodType(bloodType);
            }

            // save the child with the right bloodtype
            childPatient = patientRepository.save(childPatient);

            //return new ResponseEntity<PatientDomain>(childPatient, HttpStatus.OK);
            return ResponseEntity.ok(childPatient);
        }}}}




















































