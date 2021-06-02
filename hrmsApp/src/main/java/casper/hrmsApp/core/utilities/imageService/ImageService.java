package casper.hrmsApp.core.utilities.imageService;

import casper.hrmsApp.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    DataResult<?> save(MultipartFile file);
}
