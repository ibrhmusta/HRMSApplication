package casper.hrmsApp.business.abstracts;

import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.concretes.CandidateSkill;

import java.util.List;

public interface CandidateSkillService {
    Result add(CandidateSkill candidateSkill);
    Result addAll(List<CandidateSkill> candidateSkill);
    DataResult<List<CandidateSkill>> getAll();
    DataResult<List<CandidateSkill>> getAllByCandidateId(int candidateId);

}
