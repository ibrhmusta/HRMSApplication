package casper.hrmsApp.business.concretes;

import casper.hrmsApp.business.abstracts.CandidateExperienceService;
import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.core.utilities.results.SuccessDataResult;
import casper.hrmsApp.core.utilities.results.SuccessResult;
import casper.hrmsApp.dataAccess.abstracts.CandidateExperienceDao;
import casper.hrmsApp.entities.concretes.CandidateExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidateExperienceManager implements CandidateExperienceService {
    private final CandidateExperienceDao candidateExperienceDao;

    @Autowired
    public CandidateExperienceManager(CandidateExperienceDao candidateExperienceDao) {
        this.candidateExperienceDao = candidateExperienceDao;
    }

    @Override
    public Result add(CandidateExperience candidateExperience) {
        this.candidateExperienceDao.save(candidateExperience);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<CandidateExperience>> getAll() {
        return new SuccessDataResult<>(this.candidateExperienceDao.findAll());
    }

    @Override
    public DataResult<List<CandidateExperience>> getAllByCandidateIdOrderByLeaveDate(int candidateId) {
        return new SuccessDataResult<>(this.candidateExperienceDao.getAllByCandidateIdOrderByLeaveDateDesc(candidateId));
    }


}
