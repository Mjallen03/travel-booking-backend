package com.marcusallen.travelagency.controllers;

import com.marcusallen.travelagency.services.CheckoutService;
import com.marcusallen.travelagency.services.Purchase;
import com.marcusallen.travelagency.services.PurchaseResponse;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }


    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        System.out.println("✅ Received Purchase Request:");
        System.out.println("Customer: " + purchase.getCustomer());
        System.out.println("Cart: " + purchase.getCart());
        System.out.println("CartItems: " + purchase.getCartItems());

        PurchaseResponse response = checkoutService.placeOrder(purchase);
        System.out.println("✅ Returning tracking number: " + response.getOrderTrackingNumber());
        return response;
    }
}
