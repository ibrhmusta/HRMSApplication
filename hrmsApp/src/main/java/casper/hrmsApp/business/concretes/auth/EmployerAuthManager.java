package casper.hrmsApp.business.concretes.auth;

import casper.hrmsApp.business.abstracts.ActivationCodeService;
import casper.hrmsApp.business.abstracts.EmployerService;
import casper.hrmsApp.business.abstracts.auth.EmployerAuthService;
import casper.hrmsApp.business.constant.Messages;
import casper.hrmsApp.business.validationRules.AuthValidatorService;
import casper.hrmsApp.core.utilities.business.BusinessEngine;
import casper.hrmsApp.core.utilities.email.EmailSenderService;
import casper.hrmsApp.core.utilities.results.*;
import casper.hrmsApp.core.utilities.verificationtool.CodeGenerator;
import casper.hrmsApp.entities.concretes.ActivationCode;
import casper.hrmsApp.entities.concretes.Employer;
import casper.hrmsApp.entities.dtos.RegisterForEmployerDto;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EmployerAuthManager implements EmployerAuthService {
    private AuthValidatorService authValidatorService;
    private EmployerService employerService;
    private ActivationCodeService activationCodeService;
    private EmailSenderService emailSenderService;

    public EmployerAuthManager(EmployerService employerService, AuthValidatorService authValidatorService, ActivationCodeService activationCodeService,
                                EmailSenderService emailSenderService) {
        this.authValidatorService = authValidatorService;
        this.employerService = employerService;
        this.activationCodeService = activationCodeService;
        this.emailSenderService = emailSenderService;
    }

    @Override
    public Result register(RegisterForEmployerDto registerForEmployerDto) {
        Result result = BusinessEngine.run(authValidatorService
                .isPasswordConfirmed(registerForEmployerDto.getPassword(),
                        registerForEmployerDto.getConfirmPassword()));
        if (!result.isSuccess()) {
            return result;
        }
        DataResult<Employer> addResult = employerAdd(registerForEmployerDto);
        if (!addResult.isSuccess()) {
            return addResult;
        }
        String code = CodeGenerator.generateUuidCode();
        Result codeAddResult = activationCodeAdd(addResult.getData().getId(), code);
        if (!codeAddResult.isSuccess()) {
            return codeAddResult;
        }
        emailSenderService.send("Doğrulama işin linke tıklayınız : https://dogrulama.deneme/" + code);
        return new SuccessResult(Messages.userAdded);
    }


    private DataResult<Employer>employerAdd(RegisterForEmployerDto registerForEmployerDto){
        Employer employer = new Employer(registerForEmployerDto.getCompanyName(), registerForEmployerDto.getWebAdress(),
                registerForEmployerDto.getPhoneNumber(),registerForEmployerDto.getEmail(),registerForEmployerDto.getPassword());
        Result addResult = employerService.add(employer);
        if (!addResult.isSuccess()) {
            return new ErrorDataResult<>(null, addResult.getMessage());
        }
        return new SuccessDataResult<Employer>(employer);
    }

    private Result activationCodeAdd(int userId, String code) {
        ActivationCode activationCode = new ActivationCode(userId, code);
        Result activationResult = activationCodeService.add(activationCode);
        if (!activationResult.isSuccess()) {
            return activationResult;
        }
        return new SuccessResult();
    }
}
