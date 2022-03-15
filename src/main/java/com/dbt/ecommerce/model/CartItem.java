package com.dbt.ecommerce.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartitem_product_fk", referencedColumnName = "id")
    private Product product;
    private Integer quantity;
    private BigDecimal price;

    public void calculatePrice(){
        this.price = product.getPrice().multiply(new BigDecimal(quantity));
    }
}

