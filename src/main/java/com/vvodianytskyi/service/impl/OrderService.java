package com.vvodianytskyi.service.impl;

import com.vvodianytskyi.dao.DriverFactory;
import com.vvodianytskyi.dao.OrderDAO;
import com.vvodianytskyi.dao.impl.OrderDAOPostgres;
import com.vvodianytskyi.model.Order;
import com.vvodianytskyi.service.IOrderService;

public class OrderService implements IOrderService {

    private final OrderDAO orderDAO;

    public OrderService() {
        orderDAO = new OrderDAOPostgres(DriverFactory.getConnection());
    }

    @Override
    public boolean addOrder(String firstName, String lastName, String country, String address, String phone, String comment) {
        Order order = new Order();
        order.setFirstName(firstName);
        order.setLastName(lastName);
        order.setCountry(country);
        order.setAddress(address);
        order.setPhone(phone);
        order.setComment(comment);
        return addOrder(order);
    }

    @Override
    public boolean addOrder(Order order) {
        return orderDAO.addOrder(order);
    }

    @Override
    public Order getOrder(int id) {
        return orderDAO.getOrder(id);
    }

    @Override
    public Order getOrder(String firstName, String lastName) {
        return orderDAO.getOrder(firstName, lastName);
    }

    @Override
    public boolean updateOrder(Order order) {
        return orderDAO.updateOrder(order);
    }

    @Override
    public boolean deleteOrder(Order order) {
        return orderDAO.deleteOrder(order);
    }
}
