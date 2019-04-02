package com.vvodianytskyi.service;

import com.vvodianytskyi.model.User;

public interface IUserService {

    boolean addUser(User user);

    User getUser(String login);

    boolean updateUser(User user);

    boolean deleteUser(User user);
}
