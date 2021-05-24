package casper.hrmsApp.business.concretes;

import casper.hrmsApp.business.abstracts.UserService;
import casper.hrmsApp.business.constraints.Messages;
import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.core.utilities.results.SuccessDataResult;
import casper.hrmsApp.core.utilities.results.SuccessResult;
import casper.hrmsApp.dataAccess.abstracts.UserDao;
import casper.hrmsApp.entities.abstracts.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserManager<T extends User> implements UserService<T> {
    private UserDao<T> userDao;

    @Autowired
    public UserManager(UserDao<T> userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<T>> getAll() {
        return new SuccessDataResult<List<T>>(this.userDao.findAll(), Messages.userListed);
    }

    @Override
    public Result add(T t) {
        this.userDao.save(t);
        return new SuccessResult(Messages.userAdded);
    }
}
