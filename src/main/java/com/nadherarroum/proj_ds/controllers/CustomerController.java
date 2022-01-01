package com.nadherarroum.proj_ds.controllers;
import com.nadherarroum.proj_ds.entities.Customer;
import com.nadherarroum.proj_ds.repositories.CustomerRepo;
import com.nadherarroum.proj_ds.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // DISPLAY Custommers   ------------------------------
    @GetMapping("/display")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    // Get Custommer By ID  ------------------------------
    @GetMapping("/display/{id}")
    public String getCustomerByID(@PathVariable(name = "id") int id){
        return customerService.getCustomerByID(id);
    }

    // ADD NEW Custommer    ------------------------------
    @PostMapping("/add")
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }

    // UPDATE Custommer     ------------------------------
    @PutMapping("/update/{id}")
    public Customer customer(@PathVariable(name = "id") int id,
                             @RequestBody Customer customer){
        return customerService.updateCustomer(id, customer);
    }

    // DELETE Custommer     ------------------------------
    @DeleteMapping("/delete/{id}")
    public void customer(@PathVariable(name = "id") int id){
        customerService.deleteCustomer(id);
    }

}
