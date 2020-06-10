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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/climbing")
public class MenClimbingCategoryController extends HttpServlet {

    private final IProductService productService = new ProductService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("catalog", productService.getProductList("climbing", "men"));
        request.getRequestDispatcher("view/jsp/climbing.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        List<Product> bag = (List<Product>) session.getAttribute("bag");
        if (bag == null) bag = new ArrayList<>();
        bag.add(productService.getProduct(id));
        session.setAttribute("bag", bag);
        response.sendRedirect("/climbing");
    }
}
