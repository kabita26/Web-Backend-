package com.example.skincare_backend.service;

import com.example.skincare_backend.dto.productDto;
import com.example.skincare_backend.entity.product;

import java.util.List;
import java.util.Optional;

public interface productService {
    String save(productDto productDto);

    List<product> getAll();

    Optional<product> getById(Integer itemId);

    void deleteById(Integer itemId);
    void update(Integer itemId, productDto productDto);

}
