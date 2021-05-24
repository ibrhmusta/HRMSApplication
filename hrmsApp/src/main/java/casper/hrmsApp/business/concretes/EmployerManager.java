package casper.hrmsApp.business.concretes;

import casper.hrmsApp.business.abstracts.EmployerService;
import casper.hrmsApp.dataAccess.abstracts.EmployerDao;
import casper.hrmsApp.dataAccess.abstracts.UserDao;
import casper.hrmsApp.entities.concretes.Employer;

public class EmployerManager extends UserManager<Employer> implements EmployerService {
    private EmployerDao employerDao;

    public EmployerManager(UserDao<Employer> userDao) {
        super(userDao);
        this.employerDao=(EmployerDao) userDao;
    }

}
