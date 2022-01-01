package com.nadherarroum.proj_ds.services;

import com.nadherarroum.proj_ds.entities.Customer;
import com.nadherarroum.proj_ds.repositories.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public List<Customer> getCustomers() {
        return customerRepo.findAll();
    }


    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public Customer updateCustomer(int id, Customer customer) {
        customer.setId(id);
        return customerRepo.save(customer);
    }

    public String getCustomerByID(int id) {

        Customer customer = customerRepo.findById(id).get();

        if (customerRepo.existsById(id)) {
            return ("ID "+id+" assigned to : "+customer.getName());
        }
        return null;
    }

    public String deleteCustomer(int id) {
        boolean exists = customerRepo.existsById(id);
        if (!exists){
            throw new IllegalStateException("Customer id "+id+" not exists !");
        }else{
            customerRepo.deleteById(id);
            throw new IllegalStateException("Customer id "+id+" deleted !");
        }
    }
}
