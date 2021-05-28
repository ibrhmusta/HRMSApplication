package casper.hrmsApp.business.abstracts.auth;

import casper.hrmsApp.core.utilities.results.Result;

public interface VerifyService {
    Result verify(String uid, String activationCode);
}
