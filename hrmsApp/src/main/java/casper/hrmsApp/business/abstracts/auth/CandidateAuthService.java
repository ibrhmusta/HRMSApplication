package casper.hrmsApp.business.abstracts.auth;

import casper.hrmsApp.entities.concretes.Candidate;
import casper.hrmsApp.entities.dtos.RegisterForCandidateDtoForAuth;

public interface CandidateAuthService extends UserAuthService<RegisterForCandidateDtoForAuth, Candidate> {
}
