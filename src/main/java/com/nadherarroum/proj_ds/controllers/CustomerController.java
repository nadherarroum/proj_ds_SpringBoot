package com.nadherarroum.proj_ds.controllers;

import com.nadherarroum.proj_ds.entities.Customer;
import com.nadherarroum.proj_ds.repositories.CustomerRepo;
import com.nadherarroum.proj_ds.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    CustomerService customerService;

    @PostMapping(value = "/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.saveToDB(customer);
    }

    @GetMapping(value = "/customers")
    public List<Customer> customers(){
        return customerRepo.findAll();
    }

    @PutMapping(value = "/updateCustomer/{id}")
    public Customer updateCustomer(@PathVariable(name = "id") int id, @RequestBody Customer customer){
        customer.setId(id);
        return customerRepo.save(customer) ;
    }

    @DeleteMapping(value = "/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable(name = "id") int id){
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()){
            customerRepo.delete(customer.get());
            return "Custommer id : "+id+" is deleted";
        }else{
            throw new RuntimeException("Custommer not found for the id "+id);
        }
    }

}
