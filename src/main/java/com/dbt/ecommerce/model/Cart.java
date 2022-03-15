package com.dbt.ecommerce.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(targetEntity = CartItem.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cartitem_cart_fk", referencedColumnName = "id")
    private List<CartItem> cartItems = new ArrayList<CartItem>();

    public void addItemToCart(CartItem cartItem) {
        cartItems.add(cartItem);
    }

}
