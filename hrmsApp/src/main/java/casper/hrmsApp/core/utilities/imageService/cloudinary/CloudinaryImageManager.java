package casper.hrmsApp.core.utilities.imageService.cloudinary;

import casper.hrmsApp.core.utilities.imageService.ImageService;
import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.core.utilities.results.ErrorDataResult;
import casper.hrmsApp.core.utilities.results.SuccessDataResult;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public class CloudinaryImageManager implements ImageService {
    private final Cloudinary cloudinary;

    @Autowired
    public CloudinaryImageManager(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public DataResult<?> save(MultipartFile file) {
        try{
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return new SuccessDataResult<Map>(uploadResult);
        } catch (IOException e){
            e.printStackTrace();
        }
        return new ErrorDataResult<Map>();
    }
}
