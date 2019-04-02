package com.vvodianytskyi.dao;

import com.vvodianytskyi.model.User;

public interface UserDAO {

    boolean addUser(User user);

    User getUser(String login);

    boolean updateUser(User user);

    boolean deleteUser(User user);
}
