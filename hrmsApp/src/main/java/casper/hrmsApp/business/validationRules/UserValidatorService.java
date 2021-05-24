package casper.hrmsApp.business.validationRules;

import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.abstracts.User;

public interface UserValidatorService {
    Result userNullCheck(User user);
}
