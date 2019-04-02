package com.vvodianytskyi.dao.impl;

import com.vvodianytskyi.dao.OrderDAO;
import com.vvodianytskyi.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAOPostgres implements OrderDAO {
    /**
     * Connection of database.
     */
    private final Connection connection;

    /**
     * Init database connection
     *
     * @param connection of database
     */
    public OrderDAOPostgres(Connection connection) {
        this.connection = connection;
    }

    /**
     * Add order to database.
     *
     * @param order new Order.
     * @return True is success. False is fail.
     */
    @Override
    public boolean addOrder(Order order) {
        boolean result = false;

        try (PreparedStatement statement = connection.prepareStatement(SQLOrder.INSERT.QUERY)) {
            statement.setString(1, order.getFirstName());
            statement.setString(2, order.getLastName());
            statement.setString(3, order.getCountry());
            statement.setString(4, order.getAddress());
            statement.setString(5, order.getPhone());
            statement.setString(6, order.getComment());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Select order by id.
     *
     * @param id for select order.
     * @return valid entity if exist. If entity doesn't exist returns null.
     */
    @Override
    public Order getOrder(int id) {
        Order order = null;

        try (PreparedStatement statement = connection.prepareStatement(SQLOrder.GET_BY_ID.QUERY)) {
            statement.setInt(1, id);
            final ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                order = new Order(Integer.parseInt(resultSet.getString("id")));
                order.setFirstName(resultSet.getString("firstname"));
                order.setLastName(resultSet.getString("lastname"));
                order.setCountry(resultSet.getString("country"));
                order.setAddress(resultSet.getString("address"));
                order.setPhone(resultSet.getString("phone"));
                order.setComment(resultSet.getString("comment"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    /**
     * Select order by firstname and lastname.
     *
     * @param firstName
     * @param lastName
     * @return valid entity if exist. If entity doesn't exist returns null.
     */
    @Override
    public Order getOrder(String firstName, String lastName) {
        Order order = null;

        try (PreparedStatement statement = connection.prepareStatement(SQLOrder.GET_BY_NAME.QUERY)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            final ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                order = new Order(Integer.parseInt(resultSet.getString("id")));
                order.setFirstName(resultSet.getString("firstname"));
                order.setLastName(resultSet.getString("lastname"));
                order.setCountry(resultSet.getString("country"));
                order.setAddress(resultSet.getString("address"));
                order.setPhone(resultSet.getString("phone"));
                order.setComment(resultSet.getString("comment"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    /**
     * Update order's firstname, lastname, country, address, phone, comment by it's id.
     *
     * @param order new order's state.
     * @return True if success. False if fail.
     */
    @Override
    public boolean updateOrder(Order order) {
        boolean result = false;

        try (PreparedStatement statement = connection.prepareStatement(SQLOrder.UPDATE.QUERY)) {
            statement.setString(1, order.getFirstName());
            statement.setString(2, order.getLastName());
            statement.setString(3, order.getCountry());
            statement.setString(4, order.getAddress());
            statement.setString(5, order.getPhone());
            statement.setString(6, order.getComment());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * DELETE order by id.
     *
     * @param order for delete.
     * @return True if order was deleted. False if Order doesn't exist.
     */
    @Override
    public boolean deleteOrder(Order order) {
        boolean result = false;

        try (PreparedStatement statement = connection.prepareStatement(SQLOrder.DELETE.QUERY)) {
            statement.setInt(1, order.getId());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    enum SQLOrder {
        GET_BY_ID("SELECT * FROM orders WHERE id = ?"),
        GET_BY_NAME("SELECT * FROM orders WHERE firstname = ? AND lastname = ?"),
        INSERT("INSERT INTO orders (id, firstname, lastname, country, address, phone, comment) VALUES (DEFAULT, ?, ?, ?, ?, ?, ?) RETURNING id"),
        DELETE("DELETE FROM orders WHERE id = ? RETURNING id"),
        UPDATE("UPDATE orders SET firstname = ?, lastname= ?, country = ?, phone = ?, comment = ? WHERE id = ? RETURNING id");

        String QUERY;

        SQLOrder(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
