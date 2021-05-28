package casper.hrmsApp.business.concretes;

import casper.hrmsApp.business.abstracts.ActivationCodeService;
import casper.hrmsApp.business.constant.Messages;
import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.core.utilities.results.SuccessDataResult;
import casper.hrmsApp.core.utilities.results.SuccessResult;
import casper.hrmsApp.core.utilities.verificationtool.CodeGenerator;
import casper.hrmsApp.dataAccess.abstracts.ActivationCodeDao;
import casper.hrmsApp.entities.concretes.ActivationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ActivationCodeManager implements ActivationCodeService {
    private ActivationCodeDao activationCodeDao;

    @Autowired
    public ActivationCodeManager(ActivationCodeDao activationCodeDao) {
        this.activationCodeDao = activationCodeDao;
    }

    @Override
    public DataResult<List<ActivationCode>> getAll() {
        return new SuccessDataResult<List<ActivationCode>>(this.activationCodeDao.findAll(),Messages.activationCodeListed);
    }

    @Override
    public Result add(ActivationCode activationCode) {
        activationCode.setExpirationDate(LocalDateTime.now().plusMinutes(5));
        activationCode.setUid(CodeGenerator.generateUuidCode());
        activationCodeDao.save(activationCode);
        return new SuccessResult(Messages.activationCodeAdded);
    }

    @Override
    public Result update(ActivationCode activationCode) {
        activationCodeDao.save(activationCode);
        return new SuccessResult(Messages.activationCodeUpdated);
    }

    @Override
    public DataResult<Optional<ActivationCode>> getByUserUid(String uid) {
        return new SuccessDataResult<Optional<ActivationCode>>(activationCodeDao.findByUserUid(uid));
    }
}
