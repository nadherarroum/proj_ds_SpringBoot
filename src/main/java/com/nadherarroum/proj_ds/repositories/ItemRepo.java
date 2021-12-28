package com.nadherarroum.proj_ds.repositories;

import com.nadherarroum.proj_ds.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, Integer> {
}
