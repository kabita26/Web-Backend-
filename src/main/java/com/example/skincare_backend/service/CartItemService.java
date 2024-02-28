package com.example.skincare_backend.service;



import com.example.skincare_backend.dto.CartItemdto;

import java.util.List;

public interface CartItemService {
    List<CartItemdto> getAllCartItems();
    CartItemdto addToCart(CartItemdto cartItemDTO);
    CartItemdto updateCartItem(Long cartItemId, CartItemdto cartItemDTO);
    void removeCartItem(Long cartItemId);
}
