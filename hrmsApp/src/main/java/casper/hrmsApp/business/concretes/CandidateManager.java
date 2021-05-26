package casper.hrmsApp.business.concretes;

import casper.hrmsApp.business.abstracts.CandidateService;
import casper.hrmsApp.business.constant.Messages;
import casper.hrmsApp.business.validationRules.CandidateValidatorService;
import casper.hrmsApp.core.adapters.UserRealCheckService;
import casper.hrmsApp.core.adapters.models.MernisPerson;
import casper.hrmsApp.core.utilities.business.BusinessEngine;
import casper.hrmsApp.core.utilities.results.ErrorResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.core.utilities.results.SuccessResult;
import casper.hrmsApp.dataAccess.abstracts.CandidateDao;
import casper.hrmsApp.dataAccess.abstracts.UserDao;
import casper.hrmsApp.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateManager extends UserManager<Candidate> implements CandidateService {

    private CandidateDao candidateDao;
    private UserRealCheckService userRealCheckService;
    private CandidateValidatorService candidateValidatorService;

    @Autowired
    public CandidateManager(UserDao<Candidate> userDao, UserRealCheckService userRealCheckService,
                            CandidateValidatorService candidateValidatorService) {
        super(userDao);
        this.candidateDao = (CandidateDao) userDao;
        this.userRealCheckService = userRealCheckService;
        this.candidateValidatorService = candidateValidatorService;
    }

    @Override
    public Result add(Candidate candidate) {
            Result result = BusinessEngine.run(isIdentityNumberExist(candidate.getNationalIdentity()),
                    isMernisVerified(candidate),candidateValidatorService.candidateNullCheck(candidate),
                    candidateValidatorService.nationalIdValid(candidate.getNationalIdentity()));
            if (result.isSuccess()) {
                return super.add(candidate);
            }
            return result;
    }

    private Result isIdentityNumberExist(String identityNumber) {
        if (candidateDao.findByNationalIdentity(identityNumber).isPresent()) {
            return new ErrorResult(Messages.nationalityIdentityExist);
        }
        return new SuccessResult();
    }

    private Result isMernisVerified(Candidate candidate) {
        MernisPerson mernisPerson = new MernisPerson(candidate.getFirstName(), candidate.getLastName(),
                candidate.getNationalIdentity(), candidate.getDateOfBirth());
        boolean result = userRealCheckService.validate(mernisPerson);
        if(result){
            return new SuccessResult();
        }
        return new ErrorResult(Messages.personInValid);
    }
}
