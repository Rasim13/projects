package ru.itis.site.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/search_page")
public class SearchPagesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<form action=\"http://localhost/admin/search\">\n" +
                "\t<input type=\"text\" name=\"query\">\n" +
                "\t<br>\n" +
                "\t<input type=\"submit\" value=\"Search\">\n" +
                "</form>");

    }
}
