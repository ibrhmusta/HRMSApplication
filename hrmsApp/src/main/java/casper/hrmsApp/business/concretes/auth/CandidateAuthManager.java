package casper.hrmsApp.business.concretes.auth;

import casper.hrmsApp.business.abstracts.ActivationCodeService;
import casper.hrmsApp.business.abstracts.CandidateService;
import casper.hrmsApp.business.abstracts.auth.CandidateAuthService;
import casper.hrmsApp.business.constant.Messages;
import casper.hrmsApp.business.validationRules.AuthValidatorService;
import casper.hrmsApp.core.utilities.business.BusinessEngine;
import casper.hrmsApp.core.utilities.email.EmailSenderService;
import casper.hrmsApp.core.utilities.results.*;
import casper.hrmsApp.core.utilities.verificationtool.CodeGenerator;
import casper.hrmsApp.entities.abstracts.User;
import casper.hrmsApp.entities.concretes.ActivationCode;
import casper.hrmsApp.entities.concretes.Candidate;
import casper.hrmsApp.entities.dtos.RegisterForCandidateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CandidateAuthManager implements CandidateAuthService {
    private AuthValidatorService authValidatorService;
    private CandidateService candidateService;
    private ActivationCodeService activationCodeService;
    private EmailSenderService emailSenderService;

    @Autowired
    public CandidateAuthManager(AuthValidatorService authValidatorService, CandidateService candidateService,
                                ActivationCodeService activationCodeService, EmailSenderService emailSenderService) {
        this.authValidatorService = authValidatorService;
        this.candidateService = candidateService;
        this.activationCodeService = activationCodeService;
        this.emailSenderService = emailSenderService;
    }

    @Override
    public Result register(RegisterForCandidateDto registerForCandidateDto) {
        Result result = BusinessEngine.run(authValidatorService
                .isPasswordConfirmed(registerForCandidateDto.getPassword(),
                        registerForCandidateDto.getConfirmPassword()));
        if (!result.isSuccess()) {
            return result;
        }
        DataResult<Candidate> addResult = candidateAdd(registerForCandidateDto);
        if (!addResult.isSuccess()) {
            return addResult;
        }
        String code = CodeGenerator.generateUuidCode();
        Result codeAddResult = activationCodeAdd(addResult.getData(), code);
        if (!codeAddResult.isSuccess()) {
            return codeAddResult;
        }
        emailSenderService.send("Doğrulama için linke tıklayınız : http://localhost:8080/api/auth/verify?activationCode="+code+"&uid="+addResult.getData().getUid());
        return new SuccessResult(Messages.userAdded);
    }


    private DataResult<Candidate> candidateAdd(RegisterForCandidateDto registerForCandidateDto) {
        Candidate candidate = new Candidate(registerForCandidateDto.getFirstName(), registerForCandidateDto.getLastName()
                , registerForCandidateDto.getNationalIdentity(), registerForCandidateDto.getDateOfBirth(), registerForCandidateDto.getEmail(), registerForCandidateDto.getPassword());
        Result addResult = candidateService.add(candidate);
        if (!addResult.isSuccess()) {
            return new ErrorDataResult<>(null, addResult.getMessage());
        }
        return new SuccessDataResult<Candidate>(candidate);
    }

    private Result activationCodeAdd(User user, String code) {
        ActivationCode activationCode = new ActivationCode();
        activationCode.setActivationCode(code);
        activationCode.setUser(user);
        Result activationResult = activationCodeService.add(activationCode);
        if (!activationResult.isSuccess()) {
            return activationResult;
        }
        return new SuccessResult();
    }
}
