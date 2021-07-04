package ru.itis.servlets;

import ru.itis.entities.User;
import ru.itis.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/add.jsp");
        requestDispatcher.forward(request, response);
//        request.getRequestDispatcher("/WEB-INF/views/add.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = new User(name, password);
        Model model = Model.getInstance();
        model.add(user);

        request.setAttribute("userName", name);
        doGet(request, response);
    }
}
