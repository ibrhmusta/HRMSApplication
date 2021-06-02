package casper.hrmsApp.business.concretes;

import casper.hrmsApp.business.abstracts.LinkTypeService;
import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.core.utilities.results.SuccessDataResult;
import casper.hrmsApp.core.utilities.results.SuccessResult;
import casper.hrmsApp.dataAccess.abstracts.LinkTypeDao;
import casper.hrmsApp.entities.concretes.LinkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LinkTypeManager implements LinkTypeService {
    private final LinkTypeDao linkTypeDao;

    @Autowired
    public LinkTypeManager(LinkTypeDao linkTypeDao) {
        this.linkTypeDao = linkTypeDao;
    }

    @Override
    public Result add(LinkType linkType) {
        this.linkTypeDao.save(linkType);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<LinkType>> getAll() {
        return new SuccessDataResult<>(this.linkTypeDao.findAll());
    }
}
