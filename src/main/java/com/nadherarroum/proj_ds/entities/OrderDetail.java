package com.nadherarroum.proj_ds.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orderdetail_entity")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int qty;
    private float tax;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Item item;
}
