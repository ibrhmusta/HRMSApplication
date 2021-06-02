package casper.hrmsApp.business.abstracts;

import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.concretes.CandidateLanguage;


import java.util.List;

public interface CandidateLanguageService {
    Result add(CandidateLanguage candidateLanguage);
    Result addAll(List<CandidateLanguage> candidateLanguage);
    DataResult<List<CandidateLanguage>> getAll();
    DataResult<List<CandidateLanguage>> getAllByCandidateId(int candidateId);
}
