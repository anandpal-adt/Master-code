package com.amazin.nayra.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazin.nayra.model.ProductImage;
import com.amazin.nayra.service.ProductImageService;

@RestController
public class ImageController {
	
	@Autowired
	private ProductImageService productImageService;
	
	@ResponseStatus(value = HttpStatus.OK)
	@PostMapping("/image")
	public ProductImage uploadImage(@RequestParam("productImage")MultipartFile file) throws IOException{
		return productImageService.uploadImage(file);
	}

}
