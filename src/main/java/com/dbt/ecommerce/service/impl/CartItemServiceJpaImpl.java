package com.dbt.ecommerce.service.impl;

import com.dbt.ecommerce.model.CartItem;
import com.dbt.ecommerce.repository.CartItemRepository;
import com.dbt.ecommerce.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class CartItemServiceJpaImpl implements CartItemService {

    @Autowired
    CartItemRepository cartItemRepository;

    public CartItem saveCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public CartItem getCartItemById(Long id) {
        return cartItemRepository.findById(id).get();
    }

    public List<CartItem> getAllCatItems() {
        return cartItemRepository.findAll();
    }

    public CartItem updateCartItem(Long id, CartItem newCartItem) {
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() ->new IllegalStateException("Product with id: "+ id + " not found."));
        cartItem.setProduct(newCartItem.getProduct());
        cartItem.setQuantity(newCartItem.getQuantity());
        cartItem.setPrice(newCartItem.getPrice());
        return cartItemRepository.save(cartItem);
    }

    public void deleteById(Long id) {
        cartItemRepository.deleteById(id);
    }
}
