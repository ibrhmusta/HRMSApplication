package casper.hrmsApp.business.concretes.auth;

import casper.hrmsApp.business.abstracts.ActivationCodeService;
import casper.hrmsApp.business.abstracts.EmployerService;
import casper.hrmsApp.business.abstracts.UserService;
import casper.hrmsApp.business.abstracts.auth.CandidateAuthService;
import casper.hrmsApp.business.abstracts.auth.EmployerAuthService;
import casper.hrmsApp.business.constant.Messages;
import casper.hrmsApp.business.validationRules.AuthValidatorService;
import casper.hrmsApp.core.utilities.business.BusinessEngine;
import casper.hrmsApp.core.utilities.email.EmailSenderService;
import casper.hrmsApp.core.utilities.results.*;
import casper.hrmsApp.core.utilities.verificationtool.CodeGenerator;
import casper.hrmsApp.entities.abstracts.User;
import casper.hrmsApp.entities.concretes.ActivationCode;
import casper.hrmsApp.entities.concretes.Candidate;
import casper.hrmsApp.entities.concretes.Employer;
import casper.hrmsApp.entities.dtos.RegisterForCandidateDto;
import casper.hrmsApp.entities.dtos.RegisterForEmployerDto;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EmployerAuthManager extends UserAuthManager<RegisterForEmployerDto, Employer>implements EmployerAuthService {

    public EmployerAuthManager(AuthValidatorService authValidatorService, UserService<Employer> userService, ActivationCodeService activationCodeService, EmailSenderService emailSenderService) {
        super(authValidatorService, userService, activationCodeService, emailSenderService);
    }

    @Override
    public Employer newUserInstance(RegisterForEmployerDto registerForEmployerDto) {
        return new Employer(registerForEmployerDto.getCompanyName(), registerForEmployerDto.getWebAdress(), registerForEmployerDto.getPhoneNumber(), registerForEmployerDto.getEmail(), registerForEmployerDto.getPassword());
    }
}
