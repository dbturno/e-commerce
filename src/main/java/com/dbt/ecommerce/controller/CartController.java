package com.dbt.ecommerce.controller;

import com.dbt.ecommerce.model.Cart;
import com.dbt.ecommerce.repository.CartRepository;
import com.dbt.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    //TODO: Associate carts to users.

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartService cartService;

    @PostMapping
    public ResponseEntity<Cart>saveCart(@RequestBody Cart cart) {
        return new ResponseEntity<Cart>(cartService.saveCart(cart), HttpStatus.CREATED) ;
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getCarts() {
        return new ResponseEntity<List<Cart>>(cartService.getAllCarts(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Cart> getCart(@PathVariable("id") Long id) {
        return new ResponseEntity<Cart>(cartService.getCartById(id),HttpStatus.OK);
    }

    @PostMapping("{cartId}/product/{productId}")
    public ResponseEntity<Cart> addItemsToCart(@PathVariable("cartId") Long cartId, @PathVariable("productId") Long productId, @RequestParam Integer quantity) {
        return new ResponseEntity<Cart>(cartService.addItemsToCart(cartId, productId, quantity), HttpStatus.OK);
    }

    @DeleteMapping("{cartId}/product/{productId}")
    public ResponseEntity<Cart> removeItemsFromCart(@PathVariable("cartId") Long cartId, @PathVariable("productId") Long productId, @RequestParam Integer quantity) {
        return new ResponseEntity<Cart>(cartService.removeItemsFromCart(cartId, productId, quantity), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteCart(@PathVariable("id") Long id) {
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }
}
