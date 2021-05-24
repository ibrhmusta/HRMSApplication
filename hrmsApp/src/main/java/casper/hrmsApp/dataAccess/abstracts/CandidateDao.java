package casper.hrmsApp.dataAccess.abstracts;

import casper.hrmsApp.entities.concretes.Candidate;

import java.util.Optional;

public interface CandidateDao extends UserDao<Candidate>{
    Optional<Candidate> findByNationalIdentity(String nationalIdentity);
}
