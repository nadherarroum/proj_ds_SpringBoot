package com.nadherarroum.proj_ds.entities;

import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "customer_entity")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String deliveryAddress;
    private String contact;
    private boolean active;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
