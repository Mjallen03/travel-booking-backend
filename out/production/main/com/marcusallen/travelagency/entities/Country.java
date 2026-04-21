package com.marcusallen.travelagency.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "countries")
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")          //  Matches ERD "Country_ID"
    private Long id;

    @Column(name = "country")             //  Matches ERD "Country"
    private String countryName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date lastUpdate;

    @OneToMany(mappedBy = "country")
    private Set<Division> divisions;
}
