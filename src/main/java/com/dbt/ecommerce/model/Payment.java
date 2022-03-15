package com.dbt.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Payment {

    private Long id;
    private Cart cart;
    private BigDecimal amountPaid;
    private LocalDateTime paymentDate;



}
