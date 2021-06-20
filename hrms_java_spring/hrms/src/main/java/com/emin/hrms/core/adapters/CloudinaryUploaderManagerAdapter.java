package com.emin.hrms.core.adapters;

import com.emin.hrms.CloudinaryImageUploader.CloudinaryManager;
import com.emin.hrms.core.services.CloudinaryService;
import com.emin.hrms.core.utilities.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryUploaderManagerAdapter implements CloudinaryService {

    private CloudinaryManager cloudinaryManager;

    @Autowired
    public CloudinaryUploaderManagerAdapter(CloudinaryManager cloudinaryManager) {
        this.cloudinaryManager = cloudinaryManager;
    }

    @Override
    public DataResult<Map> upload(MultipartFile file) throws IOException {
        return this.cloudinaryManager.upload(file);
    }
}
