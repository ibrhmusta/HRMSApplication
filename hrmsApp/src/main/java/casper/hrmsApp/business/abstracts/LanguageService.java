package casper.hrmsApp.business.abstracts;

import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.concretes.Language;

import java.util.List;

public interface LanguageService {
    Result add(Language language);
    DataResult<List<Language>> getAll();

}
