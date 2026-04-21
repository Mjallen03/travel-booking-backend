package com.marcusallen.travelagency.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "vacations")
@Getter
@Setter
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Long id;

    // Angular expects "vacationTitle"
    @Column(name = "vacation_title")
    private String vacationTitle;

    @Column(name = "description")
    private String description;

    // Angular expects "travelPrice"
    @Column(name = "travel_fare_price")
    private BigDecimal travelPrice;

    // Angular expects "imageURL"
    @Column(name = "image_url")
    private String imageURL;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date lastUpdate;

    @OneToMany(mappedBy = "vacation")
    private Set<Excursion> excursions;
}
