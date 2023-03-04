package com.amazin.nayra.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.amazin.nayra.model.ProductImage;

public interface ProductImageService {

	ProductImage uploadImage(MultipartFile file) throws IOException;

}
