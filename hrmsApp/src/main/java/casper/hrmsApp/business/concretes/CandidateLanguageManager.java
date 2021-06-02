package casper.hrmsApp.business.concretes;

import casper.hrmsApp.business.abstracts.CandidateLanguageService;
import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.core.utilities.results.SuccessDataResult;
import casper.hrmsApp.core.utilities.results.SuccessResult;
import casper.hrmsApp.dataAccess.abstracts.CandidateLanguageDao;
import casper.hrmsApp.entities.concretes.CandidateLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidateLanguageManager implements CandidateLanguageService {
    private final CandidateLanguageDao candidateLanguageDao;
    @Autowired
    public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao) {
        this.candidateLanguageDao = candidateLanguageDao;
    }

    @Override
    public Result add(CandidateLanguage candidateLanguage) {
        this.candidateLanguageDao.save(candidateLanguage);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<CandidateLanguage>> getAll() {
        return new SuccessDataResult<>(this.candidateLanguageDao.findAll());
    }

    @Override
    public DataResult<List<CandidateLanguage>> getAllByCandidateId(int candidateId) {
        return new SuccessDataResult<>(this.candidateLanguageDao.getAllByCandidateId(candidateId));
    }
}
