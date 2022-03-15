package com.dbt.ecommerce.service.impl;

import com.dbt.ecommerce.exception.CartNotFoundException;
import com.dbt.ecommerce.exception.CartUpdateException;
import com.dbt.ecommerce.model.Cart;
import com.dbt.ecommerce.model.CartItem;
import com.dbt.ecommerce.model.Product;
import com.dbt.ecommerce.repository.CartItemRepository;
import com.dbt.ecommerce.repository.CartRepository;
import com.dbt.ecommerce.service.CartService;
import com.dbt.ecommerce.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

@Service
@Primary
@Slf4j
@Transactional
public class CartServiceJpaImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductService productService;

    @Autowired
    CartItemRepository cartItemRepository;

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart getCartById(Long id) {
        return cartRepository.findById(id)
                .orElseThrow(()-> new CartNotFoundException("Cart with id: " + id + " does not exist."));
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart addItemsToCart(Long cartId, Long productId, Integer quantity) {

        //Get Cart
        Cart cart = getCartById(cartId);

        //Get Product
        Product product = productService.getProductById(productId);

        //Check if product already exist in cart, if yes, just add quantity else create new cart item
        List<CartItem> cartItemList = cart.getCartItems();

        boolean sameProductFound = false;
        for (CartItem cartItem : cartItemList) {
            if (cartItem.getProduct().getId().equals(productId)) {
                log.debug("Same product found on cart, updating the price and quantity");
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                cartItem.setPrice(cartItem.getProduct().getPrice() * cartItem.getQuantity());
                sameProductFound = true;
            }
        }

        if (!sameProductFound) {
            log.debug("Cart does not have this product yet, creating new cart item for this product.");
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cartItem.setPrice(product.getPrice() * quantity);
            cart.addItemToCart(cartItem);
        }

        return cartRepository.save(cart);
    }

    public Cart removeItemsFromCart(Long cartId, Long productId, Integer quantity) {
        log.debug("Removing items from cart...");


        Cart cart = getCartById(cartId);

        List<CartItem> cartItemList = cart.getCartItems();

        Iterator<CartItem> cItemItr = cartItemList.iterator();
        Boolean productFound = false;
        while (cItemItr.hasNext()) {
            CartItem cItem = cItemItr.next();
            if (cItem.getProduct().getId().equals(productId)){
                productFound = true;
                if(cItem.getQuantity() < quantity) {
                    throw new IllegalStateException("Unable to remove more than the quantity inside the cart.");
                } else if (cItem.getQuantity() > quantity){
                    cItem.setQuantity(cItem.getQuantity() - quantity);
                    cItem.setPrice(cItem.getProduct().getPrice() * cItem.getQuantity());
                } else {
                    cItemItr.remove();
                }
            }
        }

        if (productFound == false) {
            log.error("Attempting to remove product that does not exist in cart.");
            throw new CartUpdateException("No Product with id: " + productId + " exist in cart.");
        }

        cart.setCartItems(cartItemList);

        log.debug("Removing of items from cart completed new cart: \n {}", cart);
        return cartRepository.save(cart);
    }

}
