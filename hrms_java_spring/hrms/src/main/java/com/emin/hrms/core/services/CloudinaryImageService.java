package com.emin.hrms.core.services;

import com.emin.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryImageService {

    DataResult<?> uploadPicture(MultipartFile file);

}
