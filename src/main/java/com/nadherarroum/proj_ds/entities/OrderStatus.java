package com.nadherarroum.proj_ds.entities;

import lombok.Data;

import javax.persistence.*;

public enum OrderStatus {
    CREATE,
    SHIPPING,
    DELIVERED,
    PAID
}
