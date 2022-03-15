package com.dbt.ecommerce.controller;

import com.dbt.ecommerce.model.Payment;
import com.dbt.ecommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/cart/{cartId}")
    public Payment pay(@PathVariable("cartId") Long cartId, @RequestParam Double paymentAmount) {
        return paymentService.pay(cartId, paymentAmount);
    }
}
