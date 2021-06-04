package com.emin.hrms.core.helpers;

import com.emin.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface CloudinaryService {

    DataResult<Map> upload(MultipartFile file) throws IOException;

}
