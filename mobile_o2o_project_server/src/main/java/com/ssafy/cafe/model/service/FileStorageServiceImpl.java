package com.ssafy.cafe.model.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import javax.annotation.PostConstruct;
import java.io.File;

@Service
public class FileStorageServiceImpl implements FileStorageService {

	@Value("${file.upload-dir}")
	private String uploadDir;

	@PostConstruct
	@Override
	public void init() {
		File directory = new File(uploadDir);
		if (!directory.exists()) {
			directory.mkdirs();
		}
	}

	@Override
	public String getUploadDir() {
		return uploadDir;
	}
}