package org.sussanacode.repository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.sussanacode.model.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {


    List<Customer> findByName(String name);

    @Query(value = "{'address.country' : ?0}")
    List<Customer> findByCountry(String country);

    @Query(value = "{'address.city' : ?0}")
    List<Customer> findByCity(String city);

}
