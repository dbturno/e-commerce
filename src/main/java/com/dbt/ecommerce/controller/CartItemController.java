package com.dbt.ecommerce.controller;

import com.dbt.ecommerce.model.CartItem;
import com.dbt.ecommerce.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart-item")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping
    public CartItem saveCartItem(@RequestBody CartItem cartItem) {
        return cartItemService.saveCartItem(cartItem);
    }

    @GetMapping("{id}")
    public CartItem getCartItem(@PathVariable("id") Long id) {
        return cartItemService.getCartItemById(id);
    }

    @GetMapping
    public List<CartItem> getAllCartItems(){
        return cartItemService.getAllCatItems();
    }

    @PutMapping("{id}")
    public CartItem updateCartItem(@PathVariable("id") Long id, @RequestBody CartItem cartItem) {
        return cartItemService.saveCartItem(cartItem);
    }

    @DeleteMapping("{id}")
    public void deleteCartItem(@PathVariable("id") Long id) {
        cartItemService.deleteById(id);
    }

}
