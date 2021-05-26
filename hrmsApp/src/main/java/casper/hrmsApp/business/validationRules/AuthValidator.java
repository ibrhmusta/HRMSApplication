package casper.hrmsApp.business.validationRules;

import casper.hrmsApp.business.constant.Messages;
import casper.hrmsApp.core.utilities.results.ErrorResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.core.utilities.results.SuccessResult;
import org.springframework.stereotype.Component;

@Component
public class AuthValidator implements AuthValidatorService {
    public Result isPasswordConfirmed(String password, String confirmPassword){
        if(password.equals(confirmPassword)){
            return new SuccessResult();
        }
        return new ErrorResult(Messages.PasswordNotConfirmed);
    }
}
