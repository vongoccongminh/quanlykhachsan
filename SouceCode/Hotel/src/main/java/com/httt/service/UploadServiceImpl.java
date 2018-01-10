package com.httt.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.Resource;

import org.springframework.core.io.AbstractFileResolvingResource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadServiceImpl implements UploadService {
	
	final Path rootLocation = Paths.get("E:\\Eclipse\\Hotel\\src\\main\\resources\\static\\imgs");

	public void store(MultipartFile file) {
		try {
			System.out.println("OK");
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("Sai");
			throw new RuntimeException("FAIL!");
		}
	}

	public Resource loadFile(String filename) {
		try {
			Path file = rootLocation.resolve(filename);
			Resource resource = (Resource) new UrlResource(file.toUri());
			if (((AbstractFileResolvingResource) resource).exists() || ((AbstractFileResolvingResource) resource).isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}

	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}

	public void init() {
		try {
			Files.createDirectory(rootLocation);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize storage!");
		}
	}

}
