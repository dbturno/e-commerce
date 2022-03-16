package com.dbt.ecommerce.controller;

import com.dbt.ecommerce.model.Payment;
import com.dbt.ecommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/cart/{cartId}")
    public ResponseEntity<Payment> pay(@PathVariable("cartId") Long cartId, @RequestParam BigDecimal paymentAmount) {
        return new ResponseEntity<Payment>(paymentService.pay(cartId, paymentAmount), HttpStatus.OK);
    }
}
