package com.vvodianytskyi.dao.impl;

import com.vvodianytskyi.dao.UserDAO;
import com.vvodianytskyi.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOPostgres implements UserDAO {
    /**
     * Connection of database.
     */
    private final Connection connection;

    /**
     * Init database connection.
     *
     * @param connection of database.
     */
    public UserDAOPostgres(Connection connection) {
        this.connection = connection;
    }

    /**
     * Add user to database.
     *
     * @param user new User.
     * @return True is success. False is fail.
     */
    @Override
    public boolean addUser(final User user) {
        boolean result = false;

        try (PreparedStatement statement = connection.prepareStatement(SQLUser.INSERT.QUERY)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Select user by login.
     *
     * @param login for select user.
     * @return valid entity if exist. If entity doesn't exist returns null.
     */
    @Override
    public User getUser(final String login) {
        User user = null;

        try (PreparedStatement statement = connection.prepareStatement(SQLUser.GET.QUERY)) {
            statement.setString(1, login);
            final ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User(Integer.parseInt(resultSet.getString("id")));
                user.setLogin(login);
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Updates user's password by login.
     *
     * @param user new user's state.
     * @return True is success. False is fail.
     */
    @Override
    public boolean updateUser(final User user) {
        boolean result = false;

        try (PreparedStatement statement = connection.prepareStatement(SQLUser.UPDATE.QUERY)) {
            statement.setString(1, user.getPassword());
            statement.setString(2, user.getLogin());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Delete User by id AND login AND password
     *
     * @param user for delete.
     * @return True if User was deleted. False if User doesn't exist.
     */
    @Override
    public boolean deleteUser(User user) {
        boolean result = false;

        try (PreparedStatement statement = connection.prepareStatement(SQLUser.DELETE.QUERY)) {
            statement.setInt(1, user.getId());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * SQL queries for users table.
     */
    enum SQLUser {
        GET("SELECT * FROM users WHERE login LIKE ?"),
        INSERT("INSERT INTO users (id, login, password) VALUES (DEFAULT, ?, ?) RETURNING id"),
        DELETE("DELETE FROM users WHERE login = ? AND login = ? AND password = ? RETURNING id"),
        UPDATE("UPDATE users SET password = ? WHERE login = ? RETURNING id");

        String QUERY;

        SQLUser(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
