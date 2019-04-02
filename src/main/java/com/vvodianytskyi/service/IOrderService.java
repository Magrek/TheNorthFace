package com.vvodianytskyi.service;

import com.vvodianytskyi.model.Order;

public interface IOrderService {

    boolean addOrder(String firstName, String lastName, String country, String address, String phone, String comment);

    boolean addOrder(Order order);

    Order getOrder(int id);

    Order getOrder(String firstName, String lastName);

    boolean updateOrder(Order order);

    boolean deleteOrder(Order order);
}
