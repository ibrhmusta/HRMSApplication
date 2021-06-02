package casper.hrmsApp.business.abstracts;

import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.dtos.CvDto;

public interface CvService {
    Result add(CvDto cvDto,int candidateId);
}
