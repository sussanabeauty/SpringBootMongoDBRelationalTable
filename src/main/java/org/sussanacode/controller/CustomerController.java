package org.sussanacode.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.sussanacode.model.Customer;
import org.sussanacode.repository.CustomerRepository;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepo;


    //get all customers
    @GetMapping
    public List<Customer> getAllCustomer(){
        List<Customer> customers = this.customerRepo.findAll();

        return customers;
    }


    @PostMapping("/placeOrder")
    public String placeOrder(@RequestBody Customer customer) {

        customerRepo.save(customer);
        return "Order placed Successfully...";
    }


    //find user by name
    @GetMapping("/{name}")
    public List<Customer> getCustomerByName(@PathVariable("name") String name){

        return customerRepo.findByName(name);

    }

    @GetMapping("/country/{country}")
    public List<Customer> getCustomerByCountry(@PathVariable("country") String country){

        List<Customer> customers = customerRepo.findByCountry(country);

        return customers;

    }

    @GetMapping("/address/{state}")
    public List<Customer> getCustomerByCity(@PathVariable("state") String city){

        List<Customer> customers = customerRepo.findByCity(city);
        return customers;

    }


    //edit and delete customers by Id
    @PutMapping("/edit/{id}")
    public Customer updateCustomerAndOrder(@PathVariable("id") String id, @RequestBody Customer customer){
        customer.setId(id);
        this.customerRepo.save(customer);

        return customer;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteHotel(@PathVariable("id") String id){
        this.customerRepo.deleteById(id);
    }





}
