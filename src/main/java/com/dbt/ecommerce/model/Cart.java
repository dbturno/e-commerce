package com.dbt.ecommerce.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(targetEntity = CartItem.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cartitem_cart_fk", referencedColumnName = "id")
    private List<CartItem> cartItems = new ArrayList<CartItem>();

    public Cart() {
    }

    public Cart(Long id, List<CartItem> cartItems) {
        this.id = id;
        this.cartItems = cartItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", cartItems=" + cartItems +
                '}';
    }

    public void addItemToCart(CartItem cartItem) {
        cartItems.add(cartItem);
    }
}
