package com.vvodianytskyi.controller;

import com.vvodianytskyi.model.Product;
import com.vvodianytskyi.service.IProductService;
import com.vvodianytskyi.service.impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/confirmation")
public class OrderConfirmationController extends HttpServlet {

    private final IProductService productService = new ProductService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/jsp/confirmation.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        List<Product> products = (List<Product>) session.getAttribute("bag");
        for (Product product : products) productService.decreaseProductQuantity(product);
        products.clear();
        session.setAttribute("bag", products);
        response.sendRedirect("/");
    }
}
