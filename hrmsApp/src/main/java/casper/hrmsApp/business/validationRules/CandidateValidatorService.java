package casper.hrmsApp.business.validationRules;

import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.concretes.Candidate;

public interface CandidateValidatorService {
    Result candidateNullCheck(Candidate candidate);
}
