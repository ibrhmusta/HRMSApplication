package casper.hrmsApp.business.abstracts;

import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.concretes.CandidateImage;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

public interface CandidateImageService {
    Result add(CandidateImage candidateImage);
    Result addAll(List<CandidateImage> candidateImage);
    Result add(CandidateImage candidateImage, MultipartFile file);
    DataResult<List<CandidateImage>> getAll();
    DataResult<List<CandidateImage>> getAllByCandidateId(int candidateId);
}
