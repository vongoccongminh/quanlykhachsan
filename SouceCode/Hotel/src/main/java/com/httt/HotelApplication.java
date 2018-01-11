package com.httt;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.httt.service.UploadService;

@SpringBootApplication
public class HotelApplication {
	@Resource
	UploadService uploadService;
	
	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		uploadService.deleteAll();
		uploadService.init();
	}
}
