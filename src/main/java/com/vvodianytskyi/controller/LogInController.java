package com.vvodianytskyi.controller;

import com.vvodianytskyi.model.User;
import com.vvodianytskyi.service.IUserService;
import com.vvodianytskyi.service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LogInController extends HttpServlet {

    private final IUserService userService = new UserService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/jsp/login.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user;
        if (username.length() != 0 && password.length() != 0) {
            user = userService.getUser(username);
        } else {
            response.sendRedirect("/login");
            return;
        }

        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("isLoggedIn", true);
            session.setAttribute("username", username.toUpperCase());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            response.sendRedirect("/login");
        }
    }
}