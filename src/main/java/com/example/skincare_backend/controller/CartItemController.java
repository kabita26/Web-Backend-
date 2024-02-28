package com.example.skincare_backend.controller;
import com.example.skincare_backend.dto.CartItemdto;
import com.example.skincare_backend.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @GetMapping("/items")
    public ResponseEntity<List<CartItemdto>> getAllCartItems() {
        List<CartItemdto> cartItems = cartItemService.getAllCartItems();
        return ResponseEntity.ok(cartItems);
    }

    @PostMapping("/add")
    public ResponseEntity<CartItemdto> addToCart(@RequestBody CartItemdto cartItemDTO) {
        CartItemdto addedCartItem = cartItemService.addToCart(cartItemDTO);
        return ResponseEntity.ok(addedCartItem);
    }

    @PutMapping("/update/{cartItemId}")
    public ResponseEntity<CartItemdto> updateCartItem(@PathVariable Long cartItemId, @RequestBody CartItemdto cartItemDTO) {
        CartItemdto updatedCartItem = cartItemService.updateCartItem(cartItemId, cartItemDTO);
        return ResponseEntity.ok(updatedCartItem);
    }

    @DeleteMapping("/remove/{cartItemId}")
    public ResponseEntity<Void> removeCartItem(@PathVariable Long cartItemId) {
        cartItemService.removeCartItem(cartItemId);
        return ResponseEntity.noContent().build();
    }
}
