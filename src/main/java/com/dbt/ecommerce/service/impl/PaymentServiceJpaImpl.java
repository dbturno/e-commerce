package com.dbt.ecommerce.service.impl;

import com.dbt.ecommerce.exception.PaymentException;
import com.dbt.ecommerce.model.Cart;
import com.dbt.ecommerce.model.CartItem;
import com.dbt.ecommerce.service.CartService;
import com.dbt.ecommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Payment service implementation for
 *
 */
@Service
@Primary
public class PaymentServiceJpaImpl implements PaymentService {

    @Autowired
    CartService cartService;

    public Double pay(Long cartId, Double paymentAmount){
        Double totalAmount = 0.0;
        Double changeAmount;

        Cart cart =  cartService.getCartById(cartId);

        List<CartItem> cartItemList = cart.getCartItems();

        for(CartItem cItem : cartItemList) {
            totalAmount += cItem.getPrice();
        }

        if (paymentAmount < totalAmount) {
            throw new PaymentException("Insufficient Payment Amount");
        } else {
            changeAmount = paymentAmount - totalAmount;
        }

        return changeAmount;

    }
}
