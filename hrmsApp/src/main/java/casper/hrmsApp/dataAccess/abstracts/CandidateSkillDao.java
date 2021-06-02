package casper.hrmsApp.dataAccess.abstracts;

import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.entities.concretes.CandidateSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateSkillDao extends JpaRepository<CandidateSkill,Integer> {
    List<CandidateSkill> getAllByCandidateId(int candidateId);
}
