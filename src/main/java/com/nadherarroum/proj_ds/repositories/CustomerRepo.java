package com.nadherarroum.proj_ds.repositories;

import com.nadherarroum.proj_ds.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
