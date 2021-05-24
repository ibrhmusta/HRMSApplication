package casper.hrmsApp.core.adapters;

import casper.hrmsApp.core.adapters.models.MernisPerson;

public interface UserRealCheckService {
    boolean validate(MernisPerson person);
}
