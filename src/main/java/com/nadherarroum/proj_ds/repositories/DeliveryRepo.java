package com.nadherarroum.proj_ds.repositories;

import com.nadherarroum.proj_ds.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepo extends JpaRepository<Delivery, Integer> {
}
