package casper.hrmsApp.business.abstracts;

import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.concretes.ActivationCode;

import java.util.List;

public interface ActivationCodeService {
    DataResult<List<ActivationCode>> getAll();
    Result add(ActivationCode activationCode);
    Result update(ActivationCode activationCode);
}
