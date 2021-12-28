package com.nadherarroum.proj_ds.repositories;

import com.nadherarroum.proj_ds.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}
