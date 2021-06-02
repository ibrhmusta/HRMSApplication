package casper.hrmsApp.business.abstracts.auth;

import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.abstracts.DtoForAuth;
import casper.hrmsApp.entities.abstracts.User;

public interface UserAuthService<TDto extends DtoForAuth, TUser extends User> {
    Result register(TDto tDto);

    Result reSendMail(String uid);
}
