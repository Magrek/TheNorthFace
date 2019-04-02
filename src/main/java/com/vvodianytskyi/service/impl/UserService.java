package com.vvodianytskyi.service.impl;

import com.vvodianytskyi.dao.DriverFactory;
import com.vvodianytskyi.dao.UserDAO;
import com.vvodianytskyi.dao.impl.UserDAOPostgres;
import com.vvodianytskyi.model.User;
import com.vvodianytskyi.service.IUserService;

public class UserService implements IUserService {

    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAOPostgres(DriverFactory.getConnection());
    }

    @Override
    public boolean addUser(User user) {
        return userDAO.addUser(user);
    }

    @Override
    public User getUser(String login) {
        return userDAO.getUser(login);
    }

    @Override
    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }

    @Override
    public boolean deleteUser(User user) {
        return userDAO.deleteUser(user);
    }
}
