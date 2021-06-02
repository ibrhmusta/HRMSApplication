package casper.hrmsApp.dataAccess.abstracts;

import casper.hrmsApp.entities.concretes.CandidateLink;
import casper.hrmsApp.entities.concretes.CandidateSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateLinkDao extends JpaRepository<CandidateLink,Integer> {
    List<CandidateLink> getAllByCandidateId(int candidateId);
}
