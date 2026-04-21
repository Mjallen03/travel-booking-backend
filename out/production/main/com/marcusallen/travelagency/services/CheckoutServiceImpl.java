package com.marcusallen.travelagency.services;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Override
    public PurchaseResponse placeOrder(Purchase purchase) {
        // Generate a random tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
