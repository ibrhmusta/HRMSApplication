package casper.hrmsApp.business.concretes.auth;

import casper.hrmsApp.business.abstracts.ActivationCodeService;
import casper.hrmsApp.business.abstracts.UserService;
import casper.hrmsApp.business.abstracts.auth.EmployerAuthService;
import casper.hrmsApp.business.validationRules.AuthValidatorService;
import casper.hrmsApp.core.utilities.email.EmailSenderService;
import casper.hrmsApp.entities.concretes.Employer;
import casper.hrmsApp.entities.dtos.RegisterForEmployerDtoForAuth;
import org.springframework.stereotype.Service;

@Service
public class EmployerAuthManager extends UserAuthManager<RegisterForEmployerDtoForAuth, Employer> implements EmployerAuthService {

    public EmployerAuthManager(AuthValidatorService authValidatorService, UserService<Employer> userService, ActivationCodeService activationCodeService, EmailSenderService emailSenderService) {
        super(authValidatorService, userService, activationCodeService, emailSenderService);
    }

    @Override
    public Employer newUserInstance(RegisterForEmployerDtoForAuth registerForEmployerDto) {
        return new Employer(registerForEmployerDto.getCompanyName(), registerForEmployerDto.getWebAddress(), registerForEmployerDto.getPhoneNumber(), registerForEmployerDto.getEmail(), registerForEmployerDto.getPassword());
    }
}
