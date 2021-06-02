package casper.hrmsApp.business.validationRules;

import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.dtos.CvDto;

public interface CvValidatorService {
    Result isCvPropNullCheck(CvDto cvDto);
}
