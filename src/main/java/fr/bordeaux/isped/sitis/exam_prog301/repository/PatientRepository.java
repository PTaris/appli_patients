package fr.bordeaux.isped.sitis.exam_prog301.repository;

import fr.bordeaux.isped.sitis.exam_prog301.domain.PatientDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<PatientDomain, String> {
    @Query(value = "SELECT "
            + "COUNT(*) AS patientCount, "
            + "pat_sex_cod AS sex "
            + "FROM tab_patient_301 "
            + "GROUP BY pat_sex_cod; ",
            nativeQuery = true)
    List<PatientCountSex> countPatientBySex();
}

