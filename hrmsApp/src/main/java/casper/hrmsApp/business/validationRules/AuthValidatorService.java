package casper.hrmsApp.business.validationRules;

import casper.hrmsApp.core.utilities.results.Result;

public interface AuthValidatorService {
    Result isPasswordConfirmed(String password, String confirmPassword);
}
