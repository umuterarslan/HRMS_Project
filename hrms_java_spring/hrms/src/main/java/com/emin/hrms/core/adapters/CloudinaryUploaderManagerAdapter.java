package com.emin.hrms.core.adapters;

import com.emin.hrms.cloudinaryUploader.CloudinaryUploadManager;
import com.emin.hrms.core.services.CloudinaryImageService;
import com.emin.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

public class CloudinaryUploaderManagerAdapter implements CloudinaryImageService {

    private CloudinaryUploadManager cloudinaryUploadManager;

    public CloudinaryUploaderManagerAdapter(CloudinaryUploadManager cloudinaryUploadManager) {
        this.cloudinaryUploadManager = cloudinaryUploadManager;
    }

    @Override
    public DataResult<?> uploadPicture(MultipartFile file) {
        return this.cloudinaryUploadManager.uploadPicture(file);
    }
}
