package com.marcusallen.travelagency.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "divisions")
@Getter
@Setter
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")      // matches ERD "Division_ID"
    private Long id;

    @Column(name = "division")         // matches ERD "Division"
    private String divisionName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name = "country_id")   // matches ERD foreign key
    private Country country;

    @OneToMany(mappedBy = "division")
    private Set<Customer> customers;
}
