package com.vvodianytskyi.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    public Product(int id) {
        this.id = id;
    }

    @Setter(AccessLevel.NONE)
    private int id;
    private String title;
    private double price;
    private int quantity;
    private String type;
    private String gender;
}
