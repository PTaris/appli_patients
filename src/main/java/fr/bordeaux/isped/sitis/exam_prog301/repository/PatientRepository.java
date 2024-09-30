package fr.bordeaux.isped.sitis.exam_prog301.repository;

import fr.bordeaux.isped.sitis.exam_prog301.domain.PatientDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository <PatientDomain,String> {


}
