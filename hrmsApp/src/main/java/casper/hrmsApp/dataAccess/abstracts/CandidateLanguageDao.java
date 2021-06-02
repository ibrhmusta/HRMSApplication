package casper.hrmsApp.dataAccess.abstracts;

import casper.hrmsApp.entities.concretes.CandidateLanguage;
import casper.hrmsApp.entities.concretes.CandidateSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateLanguageDao extends JpaRepository<CandidateLanguage,Integer> {
    List<CandidateLanguage> getAllByCandidateId(int candidateId);
}
