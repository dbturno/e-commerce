package com.dbt.ecommerce.service.impl;

import com.dbt.ecommerce.exception.PaymentException;
import com.dbt.ecommerce.model.Cart;
import com.dbt.ecommerce.model.CartItem;
import com.dbt.ecommerce.model.Payment;
import com.dbt.ecommerce.model.Product;
import com.dbt.ecommerce.repository.PaymentRepository;
import com.dbt.ecommerce.service.CartService;
import com.dbt.ecommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Payment service implementation for JPA
 *
 */
@Service
@Primary
public class PaymentServiceJpaImpl implements PaymentService {

    @Autowired
    CartService cartService;

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public Payment pay(Long cartId, BigDecimal paymentAmount) {
        BigDecimal totalAmount = new BigDecimal(0);
        BigDecimal changeAmount;

        Cart cart =  cartService.getCartById(cartId);

        List<CartItem> cartItemList = cart.getCartItems();

        for(CartItem cItem : cartItemList) {
            totalAmount = totalAmount.add(cItem.getPrice());
            //totalAmount += cItem.getPrice();
        }

        if (totalAmount.compareTo(paymentAmount) == 1) {
            throw new PaymentException("Insufficient Payment Amount");
        } else {
            changeAmount = paymentAmount.subtract(totalAmount);
        }

        return savePayment(Payment.builder()
                .amountPaid(paymentAmount)
                .paymentDate(LocalDateTime.now())
                .cart(cart)
                .totalAmount(totalAmount)
                .build());
    }

    public Payment savePayment(Payment product) {
        return paymentRepository.save(product);
    }
}
