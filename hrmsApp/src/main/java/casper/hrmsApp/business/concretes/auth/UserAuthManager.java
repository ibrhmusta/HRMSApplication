package casper.hrmsApp.business.concretes.auth;

import casper.hrmsApp.business.abstracts.ActivationCodeService;
import casper.hrmsApp.business.abstracts.UserService;
import casper.hrmsApp.business.abstracts.auth.UserAuthService;
import casper.hrmsApp.business.constant.Messages;
import casper.hrmsApp.business.validationRules.AuthValidatorService;
import casper.hrmsApp.core.utilities.business.BusinessEngine;
import casper.hrmsApp.core.utilities.email.EmailSenderService;
import casper.hrmsApp.core.utilities.results.ErrorResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.core.utilities.results.SuccessResult;
import casper.hrmsApp.core.utilities.verificationtool.CodeGenerator;
import casper.hrmsApp.entities.abstracts.Dto;
import casper.hrmsApp.entities.abstracts.User;
import casper.hrmsApp.entities.concretes.ActivationCode;
import casper.hrmsApp.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public abstract class UserAuthManager<TDto extends Dto, TUser extends User> implements UserAuthService<TDto, TUser> {


    private final AuthValidatorService authValidatorService;
    private final UserService<TUser> userService;
    private final ActivationCodeService activationCodeService;
    private final EmailSenderService emailSenderService;

    @Autowired
    public UserAuthManager(AuthValidatorService authValidatorService, UserService<TUser> userService,
                           ActivationCodeService activationCodeService, EmailSenderService emailSenderService) {
        this.authValidatorService = authValidatorService;
        this.userService = userService;
        this.activationCodeService = activationCodeService;
        this.emailSenderService = emailSenderService;
    }

    @Override
    public Result register(TDto tDto) {
        Result result = BusinessEngine.run(authValidatorService
                .isPasswordConfirmed(tDto.getPassword(),
                        tDto.getConfirmPassword()));
        if (!result.isSuccess()) {
            return result;
        }
        TUser user = newUserInstance(tDto);
        Result addResult = userService.add(user);
        if (!addResult.isSuccess()) {
            return addResult;
        }
        String code = CodeGenerator.generateUuidCode();
        Result codeAddResult = activationCodeAdd(user, code);
        if (!codeAddResult.isSuccess()) {
            return codeAddResult;
        }
        emailSenderService.send("Doğrulama için linke tıklayınız : http://localhost:8080/api/auth/verify?activationCode=" + code + "&uid=" + user.getUid());
        emailSenderService.send("Tekrar kod üretmek için linke tıklayınız : http://localhost:8080/api/auth/resend?uid=" + user.getUid());
        return new SuccessResult(Messages.userAdded);
    }

    @Override
    public Result reSendMail(String uid) {
        String activationCode = CodeGenerator.generateUuidCode();
        return activationCodeUpdate(uid, activationCode);
    }

    public abstract TUser newUserInstance(TDto tDto);

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

    private Result activationCodeUpdate(String uid, String code) {
        Optional<ActivationCode> updateResult = activationCodeService.getByUserUid(uid).getData();
        if (updateResult.get().isConfirmed()) {
            return new ErrorResult("Doğrulanmış bir kullanıcı için kod oluşturulamaz");
        }
        updateResult.get().setExpirationDate(LocalDateTime.now().plusMinutes(5));
        updateResult.get().setActivationCode(code);
        emailSenderService.send("Doğrulama için linke tıklayınız : http://localhost:8080/api/auth/verify?activationCode=" + code + "&uid=" + uid);
        Result activationResult = activationCodeService.update(updateResult.get());
        if (!activationResult.isSuccess()) {
            return activationResult;
        }
        return new SuccessResult();
    }
}
