package com.dbt.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_cart_fk", referencedColumnName = "id")
    private Cart cart;
    private BigDecimal amountPaid;
    private BigDecimal totalAmount;
    private LocalDateTime paymentDate;

}
