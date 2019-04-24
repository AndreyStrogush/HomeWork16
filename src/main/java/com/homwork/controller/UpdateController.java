package com.homwork.controller;

import com.homwork.dao.UserDao;
import com.homwork.dao.UserImpl.UserDaoImpl;
import com.homwork.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class UpdateController extends HttpServlet {
    private UserDao repository = UserDaoImpl.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("id");
        if (Objects.equals(userId, null))
            request.getRequestDispatcher("/list").forward(request, response);
        else {
            Long id = Long.parseLong(userId);
            User user = repository.getUserById(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/list").forward(request, response);
        }
    }
}
