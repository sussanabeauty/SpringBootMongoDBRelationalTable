package org.sussanacode.database;


import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.sussanacode.model.Address;
import org.sussanacode.model.Product;
import org.sussanacode.model.Customer;
import org.sussanacode.repository.CustomerRepository;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class DBSeeder implements CommandLineRunner {

    private final CustomerRepository userRepo;



    @Override
    public void run(String... args) throws Exception {

        Customer tommy = new Customer(
                "Tommy Holmes",
                Customer.sex.MALE,
                Arrays.asList(
                        new Product ("Fruits", 8, 10.99),
                        new Product ("Cookie", 1, 2.78),
                        new Product ("Water", 2, 4.99)
                ),
                new Address( "Duluth", "Georgia", "60067", "USA")

        );
        Customer andy = new Customer(
                "Andy Jones",
                Customer.sex.MALE,
                Arrays.asList(
                        new Product ("Snow Shovel", 1, 11.99),
                        new Product ("Cookie", 1, 2.78),
                        new Product ("Water", 2, 4.99)
                ),
                new Address( "Fairfield", "Ohio", "53002", "USA")

        );
        Customer gina = new Customer(
                "Gina Hilton",
                Customer.sex.FEMALE,
                Arrays.asList(
                        new Product ("Body Lotion", 1, 4.99),
                        new Product ("Water", 1, 2.99)
                ),
                new Address( "Newton", "Texas", "4787", "USA")

        );

        Customer james = new Customer(
                "James Owen",
                Customer.sex.MALE,
                Arrays.asList(
                        new Product ("Laptop", 1, 850.99)
                ),
                new Address( "Dampier", "Null", "00100", "Australia")

        );
        Customer sandra = new Customer(
                "Sandra Walls",
                Customer.sex.FEMALE,
                Arrays.asList(
                        new Product ("Cookie", 1, 2.78),
                        new Product ("Drink and Beverages", 3, 5.99)
                ),
                new Address( "Toronto", "Null", "00000", "Canada")
        );


        //drop all hotels
        this.userRepo.deleteAll();

        //add our new hotel records to the database
        List<Customer> users = Arrays.asList(tommy, andy, gina, sandra, james);
        this.userRepo.saveAll(users);

    }
}
