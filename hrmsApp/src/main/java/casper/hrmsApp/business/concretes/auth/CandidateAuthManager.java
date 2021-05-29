package casper.hrmsApp.business.concretes.auth;

import casper.hrmsApp.business.abstracts.ActivationCodeService;
import casper.hrmsApp.business.abstracts.UserService;
import casper.hrmsApp.business.abstracts.auth.CandidateAuthService;
import casper.hrmsApp.business.validationRules.AuthValidatorService;
import casper.hrmsApp.core.utilities.email.EmailSenderService;
import casper.hrmsApp.entities.concretes.Candidate;
import casper.hrmsApp.entities.dtos.RegisterForCandidateDto;
import org.springframework.stereotype.Service;


@Service
public class CandidateAuthManager extends UserAuthManager<RegisterForCandidateDto,Candidate>implements CandidateAuthService {


    public CandidateAuthManager(AuthValidatorService authValidatorService, UserService<Candidate> userService, ActivationCodeService activationCodeService, EmailSenderService emailSenderService) {
        super(authValidatorService, userService, activationCodeService, emailSenderService);
    }

    @Override
    public Candidate newUserInstance(RegisterForCandidateDto registerForCandidateDto) {
        return new Candidate(registerForCandidateDto.getFirstName(), registerForCandidateDto.getLastName()
                , registerForCandidateDto.getNationalIdentity(), registerForCandidateDto.getDateOfBirth(), registerForCandidateDto.getEmail(), registerForCandidateDto.getPassword());
    }
}
