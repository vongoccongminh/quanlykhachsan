package com.httt.service;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public interface UploadService {
	final Path rootLocation = Paths.get("E:\\Eclipse\\Hotel\\src\\main\\resources\\static\\imgs");
	
	public void store(MultipartFile file);
	
	public Resource loadFile(String filename);
	
	public void deleteAll();
	
	public void init();
	
}
