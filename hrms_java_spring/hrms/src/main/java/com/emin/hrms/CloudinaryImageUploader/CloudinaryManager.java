package com.emin.hrms.CloudinaryImageUploader;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.emin.hrms.core.utilities.results.DataResult;
import com.emin.hrms.core.utilities.results.ErrorDataResult;
import com.emin.hrms.core.utilities.results.SuccessDataResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryManager{

    private Cloudinary cloudinary;

    public CloudinaryManager() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "s8ca5f",
                "api_key", "793716299274276",
                "api_secret", "FxKS570tCPRYlZdnkbk-sh0pxpM"));
    }

    public DataResult<Map> upload(MultipartFile multipartFile) throws IOException {
        Map<String, Object> options = new HashMap<>();
        var allowedFormats = Arrays.asList("png", "jpg", "jpeg");
        options.put("allowed_formats", allowedFormats);
        File file = convertToFile(multipartFile);
        Map uploader = null;
        try {
            uploader = cloudinary.uploader().upload(file, options);
        } catch (Exception e) {
            return new ErrorDataResult<>(e.getMessage());
        }
        return new SuccessDataResult<>(uploader);
    }

    private File convertToFile(MultipartFile multipartFile) throws IOException {
        String path = "D:\\Java-React\\Java\\hrms\\hrms_java_spring\\hrms\\pictures\\";
        File file = new File(path + multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();
        return file;
    }

}
