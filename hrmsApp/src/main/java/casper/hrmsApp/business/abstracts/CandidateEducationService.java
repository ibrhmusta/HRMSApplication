package casper.hrmsApp.business.abstracts;

import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.concretes.CandidateEducation;

import java.util.List;

public interface CandidateEducationService {
    Result add(CandidateEducation candidateEducation);
    Result addAll(List<CandidateEducation> candidateEducation);
    DataResult<List<CandidateEducation>> getAll();
    DataResult<List<CandidateEducation>> getAllByCandidateIdOrderByGraduationYear(int candidateId);
}
