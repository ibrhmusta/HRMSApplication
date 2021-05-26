package casper.hrmsApp.business.abstracts.auth;

import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.dtos.RegisterForCandidateDto;

public interface CandidateAuthService {
    Result register(RegisterForCandidateDto registerForCandidateDto);
    Result verify(int userId,String activationCode);
}
