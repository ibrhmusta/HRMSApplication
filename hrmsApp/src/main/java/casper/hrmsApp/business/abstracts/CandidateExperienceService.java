package casper.hrmsApp.business.abstracts;

import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.concretes.CandidateExperience;


import java.util.List;

public interface CandidateExperienceService {
    Result add(CandidateExperience candidateExperience);
    DataResult<List<CandidateExperience>> getAll();
    DataResult<List<CandidateExperience>> getAllByCandidateIdOrderByLeaveDate(int candidateId);
}
