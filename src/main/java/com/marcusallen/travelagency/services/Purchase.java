package com.marcusallen.travelagency.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcusallen.travelagency.entities.Cart;
import com.marcusallen.travelagency.entities.CartItem;
import com.marcusallen.travelagency.entities.Customer;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    @JsonProperty("customer")
    private Customer customer;

    @JsonProperty("cart")
    private Cart cart;

    @JsonProperty("cartItems")
    private Set<CartItem> cartItems;
}
