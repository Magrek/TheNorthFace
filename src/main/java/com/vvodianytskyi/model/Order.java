package com.vvodianytskyi.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    public Order(int id){}

    @Setter(AccessLevel.NONE)
    private int id;
    private String firstName;
    private String lastName;
    private String country;
    private String address;
    private String phone;
    private String comment;
}
