package com.dbt.ecommerce.controller;

import com.dbt.ecommerce.model.CartItem;
import com.dbt.ecommerce.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart-item")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping
    public ResponseEntity<CartItem> saveCartItem(@RequestBody CartItem cartItem) {
        return new ResponseEntity<CartItem>(cartItemService.saveCartItem(cartItem), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CartItem> getCartItem(@PathVariable("id") Long id) {
        return new ResponseEntity<CartItem>(cartItemService.getCartItemById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CartItem>> getAllCartItems(){
        return new ResponseEntity<List<CartItem>>(cartItemService.getAllCatItems(), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<CartItem> updateCartItem(@PathVariable("id") Long id, @RequestBody CartItem cartItem) {
        return new ResponseEntity<CartItem>(cartItemService.saveCartItem(cartItem), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteCartItem(@PathVariable("id") Long id) {
        cartItemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
