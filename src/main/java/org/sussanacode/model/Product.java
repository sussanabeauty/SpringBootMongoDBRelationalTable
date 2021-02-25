package org.sussanacode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String name;

    @Indexed(direction = IndexDirection.ASCENDING)
    private int quantity;
    @Indexed(direction = IndexDirection.ASCENDING)
    private double price;


}
