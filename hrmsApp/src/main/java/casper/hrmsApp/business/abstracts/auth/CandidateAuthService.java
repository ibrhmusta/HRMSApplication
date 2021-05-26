package casper.hrmsApp.business.abstracts.auth;

import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.dtos.RegisterForCandidateDto;

public interface CandidateAuthService {
    Result registerForCandidate(RegisterForCandidateDto registerForCandidateDto);
}
