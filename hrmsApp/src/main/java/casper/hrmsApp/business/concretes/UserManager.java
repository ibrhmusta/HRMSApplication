package casper.hrmsApp.business.concretes;

import casper.hrmsApp.business.abstracts.UserService;
import casper.hrmsApp.business.constant.Messages;
import casper.hrmsApp.core.utilities.business.BusinessEngine;
import casper.hrmsApp.core.utilities.results.*;
import casper.hrmsApp.core.utilities.verificationtool.CodeGenerator;
import casper.hrmsApp.dataAccess.abstracts.UserDao;
import casper.hrmsApp.entities.abstracts.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        Result result = BusinessEngine.run(isEmailExist(t.getEmail()));
        if (!result.isSuccess()) {
            return result;
        }
        t.setUid(CodeGenerator.generateUuidCode());
        this.userDao.save(t);
        return new SuccessResult(Messages.userAdded);

    }


    private Result isEmailExist(String email) {
        if (userDao.findByEmail(email).isPresent()) {
            return new ErrorResult(Messages.emailExist);
        }
        return new SuccessResult();
    }
}
