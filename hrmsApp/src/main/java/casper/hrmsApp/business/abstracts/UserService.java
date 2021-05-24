package casper.hrmsApp.business.abstracts;

import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.abstracts.User;

import java.util.List;

public interface UserService<T extends User> {
    DataResult<List<T>>getAll();
    Result add(T t);

}
