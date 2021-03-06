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
import java.util.List;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = Model.getInstance();
        List<String> names = model.list();
        request.setAttribute("userNames", names);
//        request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/list.jsp");
        requestDispatcher.forward(request, response);
    }
}
