package com.ssafy.cafe.controller.rest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.cafe.model.service.FileStorageService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/image")
@CrossOrigin("*")
public class FileUploadController {

	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
    
	@Autowired
	FileStorageService fileStorageService;

	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@Operation(summary = "이미지 업로드", description = "이미지를 업로드하고, 업로드된 파일의 경로를 반환합니다.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "File uploaded successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid file format or request") })
	public ResponseEntity<String> uploadImage(@RequestPart MultipartFile file) {
		if (file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
		}

		try {
			// 파일 저장 경로 생성
			String uploadDir = fileStorageService.getUploadDir();
			// UUID를 추가한 고유 파일명 생성
			String originalFileName = file.getOriginalFilename();
			String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
			String uniqueFileName = UUID.randomUUID().toString() + extension;

			// 파일 저장 경로
			Path filePath = Paths.get(uploadDir, uniqueFileName);

			// 파일 저장
			Files.write(filePath, file.getBytes());

			logger.debug("Image save filepath={}", filePath);
			
			return ResponseEntity.ok(uniqueFileName);
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving file: " + e.getMessage());
		}
	}

	@DeleteMapping("/delete/{filename}")
	@Operation(summary = "파일 삭제", description = "주어진 파일명을 사용하여 파일을 삭제합니다. 삭제된 파일의 이름을 반환합니다.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "File deleted successfully"),
			@ApiResponse(responseCode = "404", description = "File not found"),
			@ApiResponse(responseCode = "500", description = "Error deleting file") })
	public ResponseEntity<String> deleteImage(@PathVariable String filename) {
		try {
			// 파일 저장 경로
			Path filePath = Paths.get(fileStorageService.getUploadDir(), filename);

			if (filename.contains("..")) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid file path");
			}

			// 파일이 존재하는지 확인
			if (!Files.exists(filePath)) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found: " + filename);
			}

			// 파일 삭제
			Files.delete(filePath);
			

			logger.debug("Image delete filepath={}", filePath);

			return ResponseEntity.ok(filename);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error deleting file: " + e.getMessage());
		}
	}

}
