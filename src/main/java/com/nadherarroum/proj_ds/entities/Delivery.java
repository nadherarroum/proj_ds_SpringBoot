package com.nadherarroum.proj_ds.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "delivery_entity")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String deliveryMan;
    private LocalDate shoppingDate;
    private LocalDate deliveryDate;

    @ManyToOne
    private Order order;
}
