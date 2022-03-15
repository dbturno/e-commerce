package com.dbt.ecommerce.service;

import com.dbt.ecommerce.exception.CartNotFoundException;
import com.dbt.ecommerce.exception.CartUpdateException;
import com.dbt.ecommerce.model.Cart;
import com.dbt.ecommerce.model.CartItem;
import com.dbt.ecommerce.model.Product;
import com.dbt.ecommerce.repository.CartItemRepository;
import com.dbt.ecommerce.repository.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

public interface CartService {
    public List<Cart> getAllCarts();

    public Cart getCartById(Long id);

    public Cart saveCart(Cart cart);

    public Cart addItemsToCart(Long cartId, Long productId, Integer quantity);

    public Cart removeItemsFromCart(Long cartId, Long productId, Integer quantity);

}
