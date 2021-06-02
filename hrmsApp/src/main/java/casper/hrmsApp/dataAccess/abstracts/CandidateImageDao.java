package casper.hrmsApp.dataAccess.abstracts;

import casper.hrmsApp.entities.concretes.CandidateImage;
import casper.hrmsApp.entities.concretes.CandidateSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateImageDao extends JpaRepository<CandidateImage,Integer> {
    List<CandidateImage> getAllByCandidateId(int candidateId);
}
