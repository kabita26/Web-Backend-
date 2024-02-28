package com.example.skincare_backend.service.impl;

import com.example.skincare_backend.dto.productDto;
import com.example.skincare_backend.entity.product;
import com.example.skincare_backend.repository.productRepo;
import com.example.skincare_backend.service.productService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class productServiceImpl implements productService {
    private final productRepo productRepo;

    @Override
    public String save(productDto productDto) {


        product product = new product();

        if (productDto.getItemId() != null) {
            product = productRepo.findById(productDto.getItemId())
                    .orElseThrow(() -> new NullPointerException("data not found"));
        }
        product.setItemName(productDto.getItemName());
        product.setImage(productDto.getImage());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());

        productRepo.save(product);
        return "Data saved";
    }

    @Override
    public List<product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Optional<product> getById(Integer productId) {
        return productRepo.findById(productId);
    }

    @Override
    public void deleteById(Integer productId) {
        productRepo.deleteById(productId);
    }

    @Override
    public void update(Integer productId, productDto productDto) {
        Optional<product> optionalProduct = productRepo.findById(productId);
        if (optionalProduct.isPresent()) {
            product product = optionalProduct.get();
            product.setItemName(productDto.getItemName());
            product.setImage(productDto.getImage());
            product.setPrice(productDto.getPrice());
            product.setDescription(productDto.getDescription());

            productRepo.save(product);

        } else {
            // Handle product not found
            throw new IllegalArgumentException("Product with ID " + productId + " not found");
        }
    }
}
