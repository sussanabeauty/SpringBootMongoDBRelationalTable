package org.sussanacode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Orders")
public class Customer {

    //create the sex enum
    public enum sex {
        MALE,FEMALE;
    }


    @Id
    private String id;
    private String name;

    //private String gender;
    @Enumerated(EnumType.STRING)
    private sex gender;

    private List<Product> products;
    private Address address;


    public Customer(String name, sex gender,
                List<Product> products, Address address)
    {
        this.name = name;
        this.gender = gender;
        this.products = products;
        this.address = address;
    }
}
