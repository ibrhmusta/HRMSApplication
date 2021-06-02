package casper.hrmsApp.dataAccess.abstracts;

import casper.hrmsApp.entities.concretes.CandidateEducation;
import casper.hrmsApp.entities.concretes.CandidateExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateEducationDao extends JpaRepository<CandidateEducation,Integer> {
    List<CandidateEducation> getAllByCandidateIdOrderByGraduationYear(int candidateId);
}
