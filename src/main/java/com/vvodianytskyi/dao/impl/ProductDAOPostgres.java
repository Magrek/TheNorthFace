package com.vvodianytskyi.dao.impl;

import com.vvodianytskyi.dao.ProductDAO;
import com.vvodianytskyi.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOPostgres implements ProductDAO {
    /**
     * Connection of database.
     */
    private final Connection connection;

    /**
     * Init database connection
     *
     * @param connection of database
     */
    public ProductDAOPostgres(Connection connection) {
        this.connection = connection;
    }

    /**
     * Add product to database.
     *
     * @param product new User.
     * @return True is success. False is fail.
     */
    @Override
    public boolean addProduct(final Product product) {
        boolean result = false;

        try (PreparedStatement statement = connection.prepareStatement(SQLProduct.INSERT.QUERY)) {
            statement.setString(1, product.getTitle());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getType());
            statement.setString(5, product.getGender());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Select product by id.
     *
     * @param id for select product.
     * @return valid entity if exist. If entity doesn't exist returns null.
     */
    @Override
    public Product getProduct(final int id) {
        Product product = null;

        try (PreparedStatement statement = connection.prepareStatement(SQLProduct.GET_PRODUCT.QUERY)) {
            statement.setInt(1, id);
            final ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                product = new Product(Integer.parseInt(resultSet.getString("id")));
                product.setTitle(resultSet.getString("title"));
                product.setPrice(resultSet.getDouble("price"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setType(resultSet.getString("type"));
                product.setGender(resultSet.getString("gender"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    /**
     * Select products by type and gender.
     *
     * @param type   for select product.
     * @param gender for select product.
     * @return list of valid entities if exist. If entity doesn't exist returns empty ArrayList.
     */
    @Override
    public List<Product> getProductList(String type, String gender) {
        List<Product> products = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(SQLProduct.GET_PRODUCTS.QUERY)) {
            statement.setString(1, type);
            statement.setString(2, gender);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product(Integer.parseInt(resultSet.getString("id")));
                product.setTitle(resultSet.getString("title"));
                product.setPrice(resultSet.getDouble("price"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setType(resultSet.getString("type"));
                product.setGender(resultSet.getString("gender"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    /**
     * Update product's price and quantity by it's id.
     *
     * @param product new product's state.
     * @return True if success. False if fail.
     */
    @Override
    public boolean updateProduct(final Product product) {
        boolean result = false;

        try (PreparedStatement statement = connection.prepareStatement(SQLProduct.UPDATE.QUERY)) {
            statement.setDouble(1, product.getPrice());
            statement.setInt(2, product.getQuantity());
            statement.setString(3, product.getType());
            statement.setString(4, product.getGender());
            statement.setString(5, product.getTitle());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * DELETE product by id AND title AND price AND quantity AND type AND gender
     *
     * @param product for delete.
     * @return True if Product was deleted. False if Product doesn't exist.
     */
    @Override
    public boolean deleteProduct(final Product product) {
        boolean result = false;

        try (PreparedStatement statement = connection.prepareStatement(SQLProduct.DELETE.QUERY)) {
            statement.setInt(1, product.getId());
            statement.setString(2, product.getTitle());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getQuantity());
            statement.setString(5, product.getType());
            statement.setString(6, product.getGender());
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * SQL queries for products table.
     */
    enum SQLProduct {
        GET_PRODUCT("SELECT * FROM products WHERE id = ?"),
        GET_PRODUCTS("SELECT * FROM products WHERE type = ? AND gender = ?"),
        INSERT("INSERT INTO products (id, title, price, quantity, type, gender) VALUES (DEFAULT, ?, ?, ?, ?, ?) RETURNING id"),
        DELETE("DELETE FROM products WHERE id = ? AND title = ? AND price = ? AND quantity = ? AND type = ? AND gender = ? RETURNING id"),
        UPDATE("UPDATE products SET price = ?, quantity = ?, type = ?, gender = ? WHERE title = ? RETURNING id");

        String QUERY;

        SQLProduct(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
