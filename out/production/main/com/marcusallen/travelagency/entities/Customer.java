package com.marcusallen.travelagency.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")              // matches ERD
    private Long id;

    @Column(name = "customer_first_name")               // matches ERD
    private String firstName;

    @Column(name = "customer_last_name")                // matches ERD
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "phone")
    private String phone;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name = "division_id")          // matches ERD foreign key
    private Division division;

    @OneToMany(mappedBy = "customer")
    private Set<Cart> carts;
}
