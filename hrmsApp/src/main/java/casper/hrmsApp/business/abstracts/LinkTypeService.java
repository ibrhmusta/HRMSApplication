package casper.hrmsApp.business.abstracts;

import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.concretes.LinkType;

import java.util.List;

public interface LinkTypeService {
    Result add(LinkType linkType);
    DataResult<List<LinkType>> getAll();
}
