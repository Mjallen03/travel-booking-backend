package com.marcusallen.travelagency.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id") // matches ERD "CartItem_ID"
    private Long id;

    // Each cart item references one Vacation
    @ManyToOne
    @JoinColumn(name = "vacation_id") // matches ERD FK
    private Vacation vacation;

    // Many-to-Many relationship with Excursion
    @ManyToMany
    @JoinTable(
            name = "excursion_cartitem", // matches ERD join table
            joinColumns = @JoinColumn(name = "cart_item_id"),
            inverseJoinColumns = @JoinColumn(name = "excursion_id")
    )
    private Set<Excursion> excursions;

    // Each cart item belongs to one Cart
    @ManyToOne
    @JoinColumn(name = "cart_id") // matches ERD FK
    private Cart cart;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date lastUpdate;
}
