package com.nadherarroum.proj_ds.services;

import com.nadherarroum.proj_ds.entities.Customer;
import com.nadherarroum.proj_ds.repositories.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public Customer saveToDB(Customer customer){
        return customerRepo.save(customer);
    }
}
