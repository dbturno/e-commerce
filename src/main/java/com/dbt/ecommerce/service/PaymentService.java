package com.dbt.ecommerce.service;

import com.dbt.ecommerce.exception.PaymentException;
import com.dbt.ecommerce.model.Cart;
import com.dbt.ecommerce.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
public interface PaymentService {

    public Double pay(Long cartId, Double paymentAmount);
}
