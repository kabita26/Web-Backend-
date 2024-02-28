package com.example.skincare_backend.controller;

import com.example.skincare_backend.dto.productDto;
import com.example.skincare_backend.entity.product;
import com.example.skincare_backend.service.productService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class productController {
    private final productService productService;

    @GetMapping("/retrieve-item")
    public String getData() {
        return "data retrieved";
    }

    @PostMapping("/save-item")
    public String createData(@RequestBody productDto itemDto) {
        productService.save(itemDto);
        return "Data saved";
    }

    @PostMapping("/upload")
    public String uploadItem(@RequestBody productDto itemDto) {
        productService.save(itemDto);
        return "Product uploaded";
    }
    @PatchMapping("/update/{itemId}")
    public String editItem(@PathVariable("itemId") Integer itemId,
                           @RequestBody productDto productDto) {
        productService.update(itemId, productDto);
        return "Product Updated";
    }


    @GetMapping("/retrieve-all-item")
    public List<product> getAllData() {
        return productService.getAll();
    }

    @GetMapping("/retrieve-item-by-id/{itemId}")
    public Optional<product> getById(@PathVariable("itemId") Integer itemId) {
        return productService.getById(itemId);
    }

    @DeleteMapping("/delete-item-by-id/{itemId}")
    public void deleteById(@PathVariable("itemId") Integer itemId) {
        productService.deleteById(itemId);
    }
}
