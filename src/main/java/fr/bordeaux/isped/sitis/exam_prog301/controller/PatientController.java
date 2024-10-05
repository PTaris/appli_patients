package fr.bordeaux.isped.sitis.exam_prog301.controller;

import fr.bordeaux.isped.sitis.exam_prog301.domain.PatientDomain;
import fr.bordeaux.isped.sitis.exam_prog301.repository.PatientCountSex;
import fr.bordeaux.isped.sitis.exam_prog301.service.ChildDTO;
import fr.bordeaux.isped.sitis.exam_prog301.service.PatientDTO;
import fr.bordeaux.isped.sitis.exam_prog301.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PatientController {
@Autowired
    private PatientService patientService;
    @GetMapping(path="/api/all")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<PatientDomain> findAllPatients(@RequestParam(name="page") int page,@RequestParam(name="pagesize") int pagesize ){
        Pageable pageable1 = PageRequest.of(page, pagesize);
        return patientService.findAllPatients(pageable1);
}

    @GetMapping("api/patient/{id}")
    public ResponseEntity<PatientDomain> findById(@PathVariable(name = "id") String patientId) {
        return patientService.findById(patientId);
    }



    @PostMapping("api/patient")
    public ResponseEntity<PatientDomain> createPatient(@Valid @RequestBody(required = false) PatientDTO patientDTO){

        return patientService.createPatient(patientDTO);
    }

    @GetMapping("api/patient/count")
    public List<PatientCountSex> countSexes(){
        return patientService.countSexes();

    }


    @PostMapping("api/patient/create")
    public ResponseEntity<PatientDomain> systemABO(@Valid @RequestBody(required = false) ChildDTO childDTO){

        return patientService.systemABO(childDTO);
    }

}
