package com.amazin.nayra.serviceImpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazin.nayra.model.ProductImage;
import com.amazin.nayra.repository.ProductImageRepository;
import com.amazin.nayra.service.ProductImageService;
import com.amazin.nayra.util.ImageUtil;

@Service
public class ProductImageServiceImpl implements ProductImageService{
	
	@Autowired
    private ProductImageRepository imageRepo;

	@Override
	public ProductImage uploadImage(MultipartFile file) throws IOException {
		ProductImage pImage = new ProductImage();
		pImage.setName(file.getOriginalFilename());
		pImage.setType(file.getContentType());
		pImage.setImageData(ImageUtil.compressImage(file.getBytes()));
		return imageRepo.save(pImage);
	}

	
	

}
