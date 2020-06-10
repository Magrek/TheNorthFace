package com.vvodianytskyi.controller;

import com.vvodianytskyi.service.IOrderService;
import com.vvodianytskyi.service.impl.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkout")
public class CheckoutController extends HttpServlet {

    private final IOrderService orderService = new OrderService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/jsp/checkout.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        orderService.addOrder(firstName, lastName,
                request.getParameter("country"),
                request.getParameter("address"),
                request.getParameter("phone"),
                request.getParameter("subject"));
        request.getSession().setAttribute("order", orderService.getOrder(firstName, lastName));
        response.sendRedirect("/confirmation");
    }
}
