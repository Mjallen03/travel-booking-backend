package com.marcusallen.travelagency.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "excursions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    private Long id;

    @JsonProperty("excursion_title")
    @Column(name = "excursion_title")
    private String excursionTitle;

    @JsonProperty("excursion_price")
    @Column(name = "excursion_price")
    private BigDecimal excursionPrice;

    @JsonProperty("image_URL")
    @Column(name = "image_url")
    private String imageURL;

    @JsonProperty("create_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @JsonProperty("last_update")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name = "vacation_id")
    @JsonIgnore
    private Vacation vacation;

    @ManyToMany(mappedBy = "excursions")
    @JsonIgnore
    private Set<CartItem> cartItems;
}
