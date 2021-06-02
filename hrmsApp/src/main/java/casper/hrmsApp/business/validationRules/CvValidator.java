package casper.hrmsApp.business.validationRules;

import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.dtos.CvDto;
import org.springframework.stereotype.Component;

@Component
public class CvValidator implements CvValidatorService{
    @Override
    public Result isCvPropNullCheck(CvDto cvDto) {
        return null;
    }
}
