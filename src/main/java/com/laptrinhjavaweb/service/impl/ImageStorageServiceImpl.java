//package com.laptrinhjavaweb.service.impl;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//import java.util.Arrays;
//import java.util.UUID;
//import java.util.stream.Stream;
//
//import org.apache.commons.io.FilenameUtils;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.UrlResource;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StreamUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.laptrinhjavaweb.service.IStorageService;
//
//@Service
//public class ImageStorageServiceImpl implements IStorageService {
//	
//	private final Path storageFolder = Paths.get("uploads"); 
//
//	// contructor
//	public ImageStorageServiceImpl() {
//		try {
//			Files.createDirectories(storageFolder);
//		} catch (IOException exception) {
//			throw new RuntimeException("Cannot initialize storage", exception);
//		}
//	}
//	
//	private boolean isImageFile(MultipartFile file) {
//		String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
//		return Arrays.asList(new String[] {"png", "jpg", "jpeg", "bmp"})
//				.contains(fileExtension.trim().toLowerCase());
//	}
//	
//	@Override
//	public String storeFile(MultipartFile file) {
//		try {
//			if (file.isEmpty()) {
//				throw new RuntimeException("Failed to store empty file.");
//			}
//			// check file is image
//			if(!isImageFile(file)) {
//				throw new RuntimeException("You can only upload image file.");
//			}
//			// file must be <= 5Mb
//			float fileSizeMegabytes = file.getSize() / 1_000_000.0f;
//			if(fileSizeMegabytes > 5.0f) {
//				throw new RuntimeException("File must be <= 5Mb.");
//			}
//			// file must be rename
//			String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
//			String generatedFileName = UUID.randomUUID().toString().replace("-", "");
//			generatedFileName = generatedFileName + "." + fileExtension;
//			Path destinationFilePath = this.storageFolder.resolve(
//					Paths.get(generatedFileName)
//				).normalize().toAbsolutePath();
//			if(!destinationFilePath.getParent().equals(this.storageFolder.toAbsolutePath())) {
//				throw new RuntimeException("Cannot store file outside current directory.");
//			}
//			try (InputStream inputStream = file.getInputStream()) {
//				Files.copy(inputStream, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
//			}
//			return generatedFileName;
//		} catch (IOException exception) {
//			throw new RuntimeException("Failed to store file", exception);
//		}
//	}
//
//	@Override
//	public Stream<Path> loadAll() {
//		try {
//			return Files.walk(this.storageFolder, 1)
//					.filter(path -> !path.equals(storageFolder))
//					.map(this.storageFolder::relativize);
//		} catch (IOException exception) {
//			throw new RuntimeException("Failed to load stored files.", exception);
//		}
//	}
//
//	@Override
//	public byte[] readFileContent(String fileName) {
//		try {
//			Path file = storageFolder.resolve(fileName);
//			Resource resource = new UrlResource(file.toUri());
//			if(resource.exists() || resource.isReadable()) {
//				byte[] bytes = StreamUtils.copyToByteArray(resource.getInputStream());
//				return bytes;
//			}
//			else {
//				throw new RuntimeException("Could not read file: " + fileName);
//			}
//		} catch (IOException exception) {
//			throw new RuntimeException("Could not read file: " + fileName, exception);
//		}
//		
//	}
//
//	@Override
//	public void deleteAllFiles() {
//		
//		
//	}
//
//}
