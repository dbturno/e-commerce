package com.dbt.ecommerce.service;

import com.dbt.ecommerce.model.CartItem;
import com.dbt.ecommerce.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CartItemService {

    public CartItem saveCartItem(CartItem cartItem);

    public CartItem getCartItemById(Long id);

    public List<CartItem> getAllCatItems();

    public CartItem updateCartItem(Long id, CartItem newCartItem);

    public void deleteById(Long id);
}
