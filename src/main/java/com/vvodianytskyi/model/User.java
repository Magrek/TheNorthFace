package com.vvodianytskyi.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public User(int id) {
        this.id = id;
    }

    @Setter(AccessLevel.NONE)
    private int id;
    private String login;
    private String password;
}
