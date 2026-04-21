package com.marcusallen.travelagency.services;

import com.marcusallen.travelagency.dao.*;
import com.marcusallen.travelagency.entities.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ExcursionRepository excursionRepository;
    private final DivisionRepository divisionRepository;
    private final CountryRepository countryRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository,
                               CartRepository cartRepository,
                               CartItemRepository cartItemRepository,
                               ExcursionRepository excursionRepository,
                               DivisionRepository divisionRepository,
                               CountryRepository countryRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.excursionRepository = excursionRepository;
        this.divisionRepository = divisionRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        System.out.println("✅ Received Purchase Request:");
        System.out.println("Customer: " + purchase.getCustomer());
        System.out.println("Cart: " + purchase.getCart());
        System.out.println("CartItems: " + purchase.getCartItems());

        Customer customer = purchase.getCustomer();
        Cart cart = purchase.getCart();
        Set<CartItem> cartItems = purchase.getCartItems();

        // Ensure default country/division exist (safe self-init)
        Division defaultDivision = ensureDefaultDivision();

        // --- Customer setup ---
        if (customer.getPostalCode() == null || customer.getPostalCode().isBlank()) {
            customer.setPostalCode("00000");
        }
        if (customer.getCreateDate() == null) {
            customer.setCreateDate(new Date());
        }
        customer.setLastUpdate(new Date());
        customer.setDivision(defaultDivision);

        // --- Cart setup ---
        cart.setId(null);
        cart.setCustomer(customer);
        cart.setOrderTrackingNumber(generateOrderTrackingNumber());
        if (cart.getCreateDate() == null) cart.setCreateDate(new Date());
        cart.setLastUpdate(new Date());
        if (cart.getPartySize() <= 0) cart.setPartySize(1);


        cart.setStatus(StatusType.ordered);

        // --- Price calculation ---
        BigDecimal total = BigDecimal.ZERO;
        Set<CartItem> fixedItems = new HashSet<>();

        for (CartItem item : cartItems) {
            item.setId(null);
            item.setCart(cart);

            Set<Excursion> attachedExcursions = new HashSet<>();
            if (item.getExcursions() != null) {
                for (Excursion ex : item.getExcursions()) {
                    if (ex.getId() != null) {
                        Excursion existing = excursionRepository.findById(ex.getId())
                                .orElseThrow(() -> new IllegalArgumentException("Excursion ID not found: " + ex.getId()));
                        attachedExcursions.add(existing);
                        if (existing.getExcursionPrice() != null) {
                            total = total.add(existing.getExcursionPrice());
                        }
                    }
                }
            }

            item.setExcursions(attachedExcursions);

            if (item.getVacation() != null && item.getVacation().getTravel_price() != null) {
                total = total.add(item.getVacation().getTravel_price());
            }

            fixedItems.add(item);
        }

        BigDecimal adjustedTotal = total.multiply(BigDecimal.valueOf(cart.getPartySize()));
        cart.setCartItems(fixedItems);
        cart.setPackagePrice(adjustedTotal);

        // --- Debug info ---
        System.out.println("🧾 Saving purchase...");
        System.out.println("Customer: " + customer.getFirstName() + " " + customer.getLastName());
        System.out.println("Division: " + (customer.getDivision() != null ? customer.getDivision().getDivisionName() : "null"));
        System.out.println("Tracking: " + cart.getOrderTrackingNumber());
        System.out.println("Party Size: " + cart.getPartySize());
        System.out.println("Status: " + cart.getStatus());
        System.out.println("Total (Base): " + total);
        System.out.println("Total (Adjusted for Party Size): " + adjustedTotal);

        // --- Persist ---
        Customer savedCustomer = customerRepository.save(customer);
        Cart savedCart = cartRepository.save(cart);
        cartItemRepository.saveAll(fixedItems);

        System.out.println("✅ Purchase saved successfully!");
        System.out.println("✅ Tracking Number: " + savedCart.getOrderTrackingNumber());

        return new PurchaseResponse(savedCart.getOrderTrackingNumber());
    }

    /** Ensures a default Country and Division exist. */
    private Division ensureDefaultDivision() {
        Optional<Division> existing = divisionRepository.findById(1L);
        if (existing.isPresent()) return existing.get();

        System.out.println("⚙ Auto-creating default Country and Division...");
        Country country = countryRepository.findById(1L).orElseGet(() -> {
            Country c = new Country();
            c.setCountryName("Default Country");
            return countryRepository.save(c);
        });

        Division d = new Division();
        d.setDivisionName("Default Division");
        d.setCountry(country);
        return divisionRepository.save(d);
    }

    private String generateOrderTrackingNumber() {
        String tracking = UUID.randomUUID().toString();
        System.out.println("🎯 Generated Tracking Number: " + tracking);
        return tracking;
    }
}
