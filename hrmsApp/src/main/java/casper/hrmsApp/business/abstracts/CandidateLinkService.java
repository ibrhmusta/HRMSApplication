package casper.hrmsApp.business.abstracts;

import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.concretes.CandidateLink;

import java.util.List;

public interface CandidateLinkService {
    Result add(CandidateLink candidateLink);
    Result addAll(List<CandidateLink> candidateLink);
    DataResult<List<CandidateLink>> getAll();
    DataResult<List<CandidateLink>> getAllByCandidateId(int candidateId);
}
