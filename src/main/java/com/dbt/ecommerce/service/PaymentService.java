package com.dbt.ecommerce.service;

import com.dbt.ecommerce.exception.PaymentException;
import com.dbt.ecommerce.model.Cart;
import com.dbt.ecommerce.model.CartItem;
import com.dbt.ecommerce.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
public interface PaymentService {
    public Payment pay(Long cartId, Double paymentAmount);
}
