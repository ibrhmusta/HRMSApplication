package casper.hrmsApp.business.concretes;

import casper.hrmsApp.business.abstracts.CandidateEducationService;
import casper.hrmsApp.business.constant.Messages;
import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.core.utilities.results.SuccessDataResult;
import casper.hrmsApp.core.utilities.results.SuccessResult;
import casper.hrmsApp.dataAccess.abstracts.CandidateEducationDao;
import casper.hrmsApp.entities.concretes.CandidateEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidateEducationManager implements CandidateEducationService {
    private final CandidateEducationDao candidateEducationDao;

    @Autowired
    public CandidateEducationManager(CandidateEducationDao candidateEducationDao) {
        this.candidateEducationDao = candidateEducationDao;
    }

    @Override
    public Result addAll(List<CandidateEducation> candidateEducation) {
        candidateEducationDao.saveAll(candidateEducation);
        return new SuccessResult();
    }

    @Override
    public Result add(CandidateEducation candidateEducation) {
        this.candidateEducationDao.save(candidateEducation);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<CandidateEducation>> getAll() {
        return new SuccessDataResult<>(this.candidateEducationDao.findAll());
    }

    @Override
    public DataResult<List<CandidateEducation>> getAllByCandidateIdOrderByGraduationYear(int candidateId) {
        return new SuccessDataResult<>(this.candidateEducationDao.getAllByCandidateIdOrderByGraduationYear(candidateId), Messages.EducationListed);
    }
}
