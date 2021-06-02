package casper.hrmsApp.business.concretes;

import casper.hrmsApp.business.abstracts.CandidateLinkService;
import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.core.utilities.results.SuccessDataResult;
import casper.hrmsApp.core.utilities.results.SuccessResult;
import casper.hrmsApp.dataAccess.abstracts.CandidateLinkDao;
import casper.hrmsApp.entities.concretes.CandidateLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidateLinkManager implements CandidateLinkService {
    private final CandidateLinkDao candidateLinkDao;
    @Autowired
    public CandidateLinkManager(CandidateLinkDao candidateLinkDao) {
        this.candidateLinkDao = candidateLinkDao;
    }

    @Override
    public Result add(CandidateLink candidateLink) {
        this.candidateLinkDao.save(candidateLink);
        return new SuccessResult();
    }

    @Override
    public Result addAll(List<CandidateLink> candidateLink) {
        candidateLinkDao.saveAll(candidateLink);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<CandidateLink>> getAll() {
        return new SuccessDataResult<>(this.candidateLinkDao.findAll());
    }

    @Override
    public DataResult<List<CandidateLink>> getAllByCandidateId(int candidateId) {
        return new SuccessDataResult<>(this.candidateLinkDao.getAllByCandidateId(candidateId));
    }
}
