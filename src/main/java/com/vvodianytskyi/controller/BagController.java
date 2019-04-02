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

@WebServlet("/bag")
public class BagController extends HttpServlet {

    private final IProductService productService = new ProductService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/jsp/bag.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Product> bag = (List<Product>) session.getAttribute("bag");
        bag.remove(productService.getProduct(Integer.parseInt(request.getParameter("id"))));
        session.setAttribute("bag", bag);
        response.sendRedirect("/bag");
    }
}
