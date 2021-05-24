package casper.hrmsApp.core.utilities.business;

import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.core.utilities.results.SuccessResult;

public class BusinessEngine {
    public static Result run(Result... logics){
        for(Result logic:logics){
            if(!logic.isSuccess()){
                return logic;
            }
        }
        return new SuccessResult();
    }
}
