package casper.hrmsApp.business.concretes;

import casper.hrmsApp.business.abstracts.CandidateSkillService;
import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.core.utilities.results.SuccessDataResult;
import casper.hrmsApp.core.utilities.results.SuccessResult;
import casper.hrmsApp.dataAccess.abstracts.CandidateSkillDao;
import casper.hrmsApp.entities.concretes.CandidateSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidateSkillManager implements CandidateSkillService {

    private final CandidateSkillDao candidateSkillDao;

    @Autowired
    public CandidateSkillManager(CandidateSkillDao candidateSkillDao) {
        this.candidateSkillDao = candidateSkillDao;
    }

    @Override
    public Result add(CandidateSkill candidateSkill) {
        this.candidateSkillDao.save(candidateSkill);
        return new SuccessResult();
    }

    @Override
    public Result addAll(List<CandidateSkill> candidateSkill) {
        candidateSkillDao.saveAll(candidateSkill);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<CandidateSkill>> getAll() {
        return new SuccessDataResult<>(this.candidateSkillDao.findAll());
    }

    @Override
    public DataResult<List<CandidateSkill>> getAllByCandidateId(int candidateId) {
        return new SuccessDataResult<>(this.candidateSkillDao.getAllByCandidateId(candidateId));
    }
}
