package com.emin.hrms.cloudinaryUploader;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.emin.hrms.core.services.CloudinaryImageService;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.ErrorDataResult;
import com.emin.hrms.core.utilities.results.SuccessDataResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryUploadManager implements CloudinaryImageService {

    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "s8ca5f", "api_key", "793716299274276",
            "api_secret", "FxKS570tCPRYlZdnkbk-sh0pxpM"));

    @Override
    public DataResult<?> uploadPicture(MultipartFile file) {
        try {
            Map upload = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return new SuccessDataResult<Map>(upload);
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorDataResult<Map>();
        }
    }

}
