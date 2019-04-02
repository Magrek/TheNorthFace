package com.vvodianytskyi.dao;

import com.vvodianytskyi.model.Order;

public interface OrderDAO {

    boolean addOrder(Order order);

    Order getOrder(int id);

    Order getOrder(String firstName, String lastName);

    boolean updateOrder(Order order);

    boolean deleteOrder(Order order);
}
