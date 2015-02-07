package com.swz.voice.model;

import org.springframework.web.multipart.MultipartFile;

public class BoUploadFile {
	private MultipartFile File; 
	private String name;

	public MultipartFile getImageFile() {
		return File;
	}

	public void setImageFile(MultipartFile imageFile) {
		this.File = imageFile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
