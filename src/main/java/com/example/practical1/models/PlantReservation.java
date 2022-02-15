package com.example.practical1.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PlantReservation {
    @Id
    @GeneratedValue
    Long id;

    @Embedded
    BussinesPeriod schedule;

    @ManyToOne
    PurchaseOrder rental;

    @ManyToOne
    PlantInventoryItem plant;
}
