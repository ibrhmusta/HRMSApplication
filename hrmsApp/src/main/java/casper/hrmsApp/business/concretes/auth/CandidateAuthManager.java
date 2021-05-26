package casper.hrmsApp.business.concretes.auth;

import casper.hrmsApp.business.abstracts.CandidateService;
import casper.hrmsApp.business.abstracts.auth.CandidateAuthService;
import casper.hrmsApp.business.validationRules.AuthValidatorService;
import casper.hrmsApp.core.utilities.business.BusinessEngine;
import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.core.utilities.results.ErrorDataResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.concretes.Candidate;
import casper.hrmsApp.entities.dtos.RegisterForCandidateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateAuthManager implements CandidateAuthService {
    private AuthValidatorService authValidatorService;
    private CandidateService candidateService;

    @Autowired
    public CandidateAuthManager(AuthValidatorService authValidatorService,CandidateService candidateService) {
        this.authValidatorService = authValidatorService;
        this.candidateService = candidateService;
    }

    @Override
    public Result registerForCandidate(RegisterForCandidateDto registerForCandidateDto) {
        Result result = BusinessEngine.run(authValidatorService.isPasswordConfirmed(registerForCandidateDto.getPassword(),
                registerForCandidateDto.getConfirmPassword()));
        if (!result.isSuccess()) {
            return result;
        }
        Candidate candidate = new Candidate(registerForCandidateDto.getFirstName(), registerForCandidateDto.getLastName()
                , registerForCandidateDto.getNationalIdentity(), registerForCandidateDto.getDateOfBirth(), registerForCandidateDto.getEmail(), registerForCandidateDto.getPassword());
        Result addResult = candidateService.add(candidate);
        if(!addResult.isSuccess()){
            return addResult;
        }
        return null;
    }
}
