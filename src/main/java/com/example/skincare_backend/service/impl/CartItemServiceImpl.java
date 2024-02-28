package com.example.skincare_backend.service.impl;

import com.example.skincare_backend.dto.CartItemdto;
import com.example.skincare_backend.entity.CartItem;
import com.example.skincare_backend.repository.CartItemRepository;
import com.example.skincare_backend.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public List<CartItemdto> getAllCartItems() {
        List<CartItem> cartItems = cartItemRepository.findAll();
        // Convert CartItem entities to CartItemDTOs
        return cartItems.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CartItemdto addToCart(CartItemdto cartItemDTO) {
        CartItem cartItem = convertToEntity(cartItemDTO);
        CartItem savedCartItem = cartItemRepository.save(cartItem);
        return convertToDto(savedCartItem);
    }

    @Override
    public CartItemdto updateCartItem(Long cartItemId, CartItemdto cartItemDTO) {
        Optional<CartItem> optionalCartItem = cartItemRepository.findById(cartItemId);
        if (optionalCartItem.isPresent()) {
            CartItem cartItem = optionalCartItem.get();
            cartItem.setQuantity(cartItemDTO.getQuantity());
            CartItem updatedCartItem = cartItemRepository.save(cartItem);
            return convertToDto(updatedCartItem);
        } else {
            throw new IllegalArgumentException("Cart item with ID " + cartItemId + " not found.");
        }
    }

    @Override
    public void removeCartItem(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    private CartItemdto convertToDto(CartItem cartItem) {
        CartItemdto cartItemDTO = new CartItemdto();
        cartItemDTO.setId(cartItem.getId());
        cartItemDTO.setName(cartItem.getName());
        cartItemDTO.setPrice(cartItem.getPrice());
        return cartItemDTO;
    }

    private CartItem convertToEntity(CartItemdto cartItemDTO) {
        CartItem cartItem = new CartItem();
        // Convert CartItemDTO to CartItem entity
        // Example conversion:
        cartItem.setId(cartItemDTO.getId());
        cartItem.setName(cartItemDTO.getName());
        cartItem.setPrice(cartItemDTO.getPrice());
        cartItem.setQuantity(cartItemDTO.getQuantity());
        return cartItem;
    }
}
