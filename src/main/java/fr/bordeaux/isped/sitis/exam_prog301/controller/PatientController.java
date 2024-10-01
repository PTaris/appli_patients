package fr.bordeaux.isped.sitis.exam_prog301.controller;

import fr.bordeaux.isped.sitis.exam_prog301.domain.PatientDomain;
import fr.bordeaux.isped.sitis.exam_prog301.service.PatientDTO;
import fr.bordeaux.isped.sitis.exam_prog301.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {
@Autowired
    private PatientService patientService;
    @GetMapping(path="/api/patients")

    public List<PatientDomain> getPatient(){
        return patientService.getPatient();
}

    @PostMapping("api/patient")
    public ResponseEntity<PatientDomain> createPatient(@Valid @RequestBody(required = false) PatientDTO patientDTO){

        return patientService.createPatient(patientDTO);
    }

}
