package casper.hrmsApp.business.abstracts;

import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.entities.concretes.Candidate;
import casper.hrmsApp.entities.dtos.CvDto;

public interface CandidateService extends UserService<Candidate> {
    DataResult<CvDto> getResumeByCandidateId(int candidateId);
    DataResult<Candidate> getById(int id);
}
