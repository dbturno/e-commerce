package com.dbt.ecommerce.controller;

import com.dbt.ecommerce.model.Cart;
import com.dbt.ecommerce.repository.CartRepository;
import com.dbt.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartService cartService;

    @PostMapping
    public Cart saveCart(@RequestBody Cart cart) {
        return cartService.saveCart(cart);
    }

    @GetMapping
    public List<Cart> getCarts() {
        return cartService.getAllCarts();
    }

    @GetMapping("{id}")
    public Cart getCart(@PathVariable("id") Long id) {
        return cartService.getCartById(id);
    }

    @PostMapping("{cartId}/product/{productId}")
    @Transactional
    public Cart addItemsToCart(@PathVariable("cartId") Long cartId, @PathVariable("productId") Long productId, @RequestParam Integer quantity) {
        return cartService.addItemsToCart(cartId, productId, quantity);
    }

    @DeleteMapping("{cartId}/product/{productId}")
    @Transactional
    public Cart removeItemsFromCart(@PathVariable("cartId") Long cartId, @PathVariable("productId") Long productId, @RequestParam Integer quantity) {
        return cartService.removeItemsFromCart(cartId, productId, quantity);
    }
}
