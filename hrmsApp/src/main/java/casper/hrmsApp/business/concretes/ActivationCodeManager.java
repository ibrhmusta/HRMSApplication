package casper.hrmsApp.business.concretes;

import casper.hrmsApp.business.abstracts.ActivationCodeService;
import casper.hrmsApp.business.constant.Messages;
import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.core.utilities.results.SuccessDataResult;
import casper.hrmsApp.core.utilities.results.SuccessResult;
import casper.hrmsApp.dataAccess.abstracts.ActivationCodeDao;
import casper.hrmsApp.entities.concretes.ActivationCode;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ActivationCodeManager implements ActivationCodeService {
    private ActivationCodeDao activationCodeDao;

    public ActivationCodeManager(ActivationCodeDao activationCodeDao) {
        this.activationCodeDao = activationCodeDao;
    }

    @Override
    public DataResult<List<ActivationCode>> getAll() {
        return new SuccessDataResult<List<ActivationCode>>(this.activationCodeDao.findAll(),Messages.activationCodeListed);
    }

    @Override
    public Result add(ActivationCode activationCode) {
        activationCode.setExprationDate(Date.valueOf(String.valueOf(LocalDateTime.now().plusMinutes(3))));
        activationCodeDao.save(activationCode);
        return new SuccessResult(Messages.activationCodeAdded);
    }

    @Override
    public Result update(ActivationCode activationCode) {
        activationCodeDao.save(activationCode);
        return new SuccessResult(Messages.activationCodeUpdated);
    }

    @Override
    public DataResult<Optional<ActivationCode>> getByUserId(int userId) {
        return new SuccessDataResult<Optional<ActivationCode>>(activationCodeDao.findByUserId(userId));
    }
}
