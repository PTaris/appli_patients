package fr.bordeaux.isped.sitis.exam_prog301.controller;

import fr.bordeaux.isped.sitis.exam_prog301.domain.PatientDomain;
import fr.bordeaux.isped.sitis.exam_prog301.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
