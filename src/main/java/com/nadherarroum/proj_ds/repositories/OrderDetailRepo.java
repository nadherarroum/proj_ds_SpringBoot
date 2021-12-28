package com.nadherarroum.proj_ds.repositories;

import com.nadherarroum.proj_ds.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepo extends JpaRepository<OrderDetail, Integer> {
}
