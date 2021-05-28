package casper.hrmsApp.business.concretes.auth;

import casper.hrmsApp.business.abstracts.ActivationCodeService;
import casper.hrmsApp.business.abstracts.auth.VerifyService;
import casper.hrmsApp.business.constant.Messages;
import casper.hrmsApp.core.utilities.results.ErrorResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.core.utilities.results.SuccessResult;
import casper.hrmsApp.entities.concretes.ActivationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class VerifyManager implements VerifyService {

    private ActivationCodeService activationCodeService;

    @Autowired
    public VerifyManager(ActivationCodeService activationCodeService) {
        this.activationCodeService = activationCodeService;
    }

    public Result verify(String uid, String activationCode) {
        Optional<ActivationCode> activation = activationCodeService.getByUserUid(uid).getData();
        Result result = subVerify(activation,activationCode);
        if(!result.isSuccess()){
            return result;
        }
        activation.get().setActivationDate(LocalDateTime.now());
        activation.get().setConfirmed(true);
        activationCodeService.update(activation.get());
        return new SuccessResult(Messages.codeVerified);
    }

    private Result subVerify(Optional<ActivationCode> activation, String activationCode){
        if (activation.isEmpty()) {
            return new ErrorResult(Messages.codeNotFound);
        }
        if (activation.get().isConfirmed()) {
            return new ErrorResult(Messages.activationExist);
        }
        if (activation.get().getExpirationDate().isBefore(LocalDateTime.now())) {
            return new ErrorResult(Messages.codeExpired);
        }
        if (!activation.get().getActivationCode().equals(activationCode)) {
            return new ErrorResult(Messages.codeNotEqual);
        }
        return new SuccessResult();
    }
}
