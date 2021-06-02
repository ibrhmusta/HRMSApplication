package casper.hrmsApp.dataAccess.abstracts;

import casper.hrmsApp.entities.concretes.CandidateExperience;
import casper.hrmsApp.entities.concretes.CandidateSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateExperienceDao extends JpaRepository<CandidateExperience,Integer> {
    List<CandidateExperience> getAllByCandidateIdOrderByLeaveDateDesc(int candidateId);
}
