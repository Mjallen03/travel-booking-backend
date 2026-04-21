package com.marcusallen.travelagency.services;

import com.marcusallen.travelagency.entities.Cart;
import com.marcusallen.travelagency.entities.CartItem;
import com.marcusallen.travelagency.entities.Customer;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}
