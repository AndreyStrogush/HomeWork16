package com.homwork.controller;

import com.homwork.dao.UserDao;
import com.homwork.dao.UserImpl.UserDaoImpl;
import com.homwork.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet
public class CreateController extends HttpServlet {
    private UserDao repository = UserDaoImpl.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/list").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("id");
        String name = request.getParameter("name");
        Integer age = Integer.valueOf(request.getParameter("age"));
        User user = new User()
                .setName(name)
                .setAge(age);
        if (Objects.equals(userId, null))
            repository.insertUser(user);
        else {
            Long id = Long.parseLong(userId);
            user.setId(id);
            repository.updateUser(user);
        }
        response.sendRedirect(request.getContextPath() + "/list");
    }
}
